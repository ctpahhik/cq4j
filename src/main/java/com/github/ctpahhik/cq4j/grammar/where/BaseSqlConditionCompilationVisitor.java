package com.github.ctpahhik.cq4j.grammar.where;

import com.github.ctpahhik.cq4j.functions.FunctionsFactory;
import com.github.ctpahhik.cq4j.common.IOperator;
import com.github.ctpahhik.cq4j.grammar.BaseSqlAbstractVisitor;
import com.github.ctpahhik.cq4j.grammar.from.FromElements;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlParser;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlVisitor;
import com.github.ctpahhik.cq4j.operations.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides an empty implementation of {@link com.github.ctpahhik.cq4j.grammar.generated.BaseSqlVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 */
public class BaseSqlConditionCompilationVisitor extends BaseSqlAbstractVisitor<IOperator> implements BaseSqlVisitor<IOperator> {

    private FromElements from;
    private FunctionsFactory factory;

    public BaseSqlConditionCompilationVisitor(FromElements from) {
        this(from, FunctionsFactory.getInstance());
    }

    public BaseSqlConditionCompilationVisitor(FromElements from, FunctionsFactory factory) {
        this.from = from;
        this.factory = factory;
    }

    private <T> IOperator<T> postProcess(IOperator<T> operator) {
        if (operator.isDeterministic()) {
            return new ConstantOperator<T>(operator.evaluate(null));
        } else {
            return operator;
        }
    }

    @Override
    public IOperator visitFloat(@NotNull BaseSqlParser.FloatContext ctx) {
        return new ConstantOperator<Number>(new BigDecimal(ctx.getText())); //TODO: parse Double and Float
    }

    @Override
    public IOperator visitWhereClause(@NotNull BaseSqlParser.WhereClauseContext ctx) {
        return ctx.value.accept(this);
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperator visitOrOperator(@NotNull BaseSqlParser.OrOperatorContext ctx) {
        return postProcess(new OrOperator(ctx.left.accept(this), ctx.right.accept(this)));
    }

    @Override
    public IOperator visitField(@NotNull BaseSqlParser.FieldContext ctx) {
        String fieldName = ctx.getText();
        int tableId = from.getTableIdByFieldName(fieldName);

        return new MultiTableDataAccessOperator(tableId, from.getDataAdapterById(tableId), fieldName);
    }

    @Override
    public IOperator visitTableField(@NotNull BaseSqlParser.TableFieldContext ctx) {
        String tableName = ctx.ID(0).getText();
        String fieldName = ctx.ID(1).getText();
        int tableId = from.getTableIdByName(tableName);

        return new MultiTableDataAccessOperator(tableId, from.getDataAdapterById(tableId), fieldName);
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperator visitComparePredicate(@NotNull BaseSqlParser.ComparePredicateContext ctx) {
        CompareOperator.Type type = null;
        switch (ctx.operator.getType()) {
            case BaseSqlParser.LT :
                type = CompareOperator.Type.LT_EQ;
                break;
            case BaseSqlParser.LT_EQ :
                type = CompareOperator.Type.LT;
                break;
            case BaseSqlParser.GT :
                type = CompareOperator.Type.GT;
                break;
            case BaseSqlParser.GT_EQ :
                type = CompareOperator.Type.GT_EQ;
                break;
            case BaseSqlParser.EQ :
                type = CompareOperator.Type.EQ;
                break;
            case BaseSqlParser.NOT_EQ :
                type = CompareOperator.Type.NOT_EQ;
                break;
        }

        return postProcess(new CompareOperator(ctx.left.accept(this), ctx.right.accept(this), type));
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperator visitNegatablePredicate(@NotNull BaseSqlParser.NegatablePredicateContext ctx) {
        IOperator<Boolean> operation = ctx.detailedPredicate.accept(this);
        if (ctx.NOT() == null) {
            return postProcess(operation);
        } else {
            return postProcess(new NotOperator(operation));
        }
    }

    @Override
    public IOperator visitSkipExpression(@NotNull BaseSqlParser.SkipExpressionContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public IOperator visitInPredicate(@NotNull BaseSqlParser.InPredicateContext ctx) {
        IOperator operationValue = ((BaseSqlParser.NegatablePredicateContext)ctx.getParent()).value.accept(this);
        List<IOperator> listOp = new ArrayList<IOperator>(ctx.el.size());
        for (ParserRuleContext context : ctx.el) {
            listOp.add(context.accept(this));
        }
        return postProcess(new InOperator(operationValue, listOp));
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperator visitNotCondition(@NotNull BaseSqlParser.NotConditionContext ctx) {
        return postProcess(new NotOperator(ctx.value.accept(this)));
    }

    @Override
    public IOperator visitSimpleCondition(@NotNull BaseSqlParser.SimpleConditionContext ctx) {
        return ctx.value.accept(this);
    }

    @Override
    public IOperator visitBoolean(@NotNull BaseSqlParser.BooleanContext ctx) {
        return new ConstantOperator<Boolean>(Boolean.parseBoolean(ctx.getText()));
    }

    @Override
    public IOperator visitComparison(@NotNull BaseSqlParser.ComparisonContext ctx) {
        throw new java.lang.IllegalStateException("Comparison shouldn't be visited directly");
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperator visitInFunction(@NotNull BaseSqlParser.InFunctionContext ctx) {
        String name = ctx.ID().getText();
        IOperator value = ctx.value.accept(this);
        IOperator inValue = ctx.inValue.accept(this);
        IOperator<Integer> fromValue = (ctx.from == null ? null : ctx.from.accept(this));
        return postProcess(factory.createInFunction(name, value, inValue, fromValue));
    }

    @Override
    public IOperator visitSimpleFunction(@NotNull BaseSqlParser.SimpleFunctionContext ctx) {
        String name = ctx.ID().getText();
        List<IOperator> listOp = new ArrayList<IOperator>(ctx.el.size());
        for (ParserRuleContext context : ctx.el) {
            listOp.add(context.accept(this));
        }
        return postProcess(factory.createSimpleFunction(name, listOp));
    }

    @Override
    public IOperator visitSkipCondition(@NotNull BaseSqlParser.SkipConditionContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public IOperator visitUnaryOperator(@NotNull BaseSqlParser.UnaryOperatorContext ctx) {
        IOperator operation = ctx.value.accept(this);
        switch (ctx.operator.getType()) {
            case BaseSqlParser.PLUS :
                return operation;
            case BaseSqlParser.MINUS :
                return postProcess(new UnaryOperator(operation, UnaryOperator.Type.MINUS));
            default:
                return postProcess(new UnaryOperator(operation, null));
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperator visitAndOperator(@NotNull BaseSqlParser.AndOperatorContext ctx) {
        return postProcess(new AndOperator(ctx.left.accept(this), ctx.right.accept(this)));
    }

    @Override
    public IOperator visitString(@NotNull BaseSqlParser.StringContext ctx) {
        String text = ctx.getText();
        return new ConstantOperator<String>(text.substring(1, text.length()-1));
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperator visitBetweenPredicate(@NotNull BaseSqlParser.BetweenPredicateContext ctx) {
        IOperator<Comparable> operationValue = ((BaseSqlParser.NegatablePredicateContext)ctx.getParent()).value.accept(this);
        return postProcess(new BetweenOperator(operationValue, ctx.lower.accept(this), ctx.upper.accept(this)));
    }

    @Override
    public IOperator visitSkipPredicate(@NotNull BaseSqlParser.SkipPredicateContext ctx) {
        return ctx.value.accept(this);
    }

    @Override
    public IOperator visitInteger(@NotNull BaseSqlParser.IntegerContext ctx) {
        return new ConstantOperator<Number>(new BigInteger(ctx.getText())); //TODO: parse Long and Integer
    }

    @Override
    public IOperator visitNull(@NotNull BaseSqlParser.NullContext ctx) {
        return null;
    }

    @Override
    public IOperator visitIsNullPredicate(@NotNull BaseSqlParser.IsNullPredicateContext ctx) {
        IOperator<Boolean> operation = new IsNullOperator(ctx.value.accept(this));
        if (ctx.NOT() == null) {
            return postProcess(operation);
        } else {
            return postProcess(new NotOperator(operation));
        }
    }

    @Override
    public IOperator visitArithmeticOperator(@NotNull BaseSqlParser.ArithmeticOperatorContext ctx) {
        ArithmeticOperator.Type type = null;
        switch (ctx.operator.getType()) {
            case BaseSqlParser.PLUS :
                type = ArithmeticOperator.Type.PLUS;
                break;
            case BaseSqlParser.MINUS :
                type = ArithmeticOperator.Type.MINUS;
                break;
            case BaseSqlParser.STAR :
                type = ArithmeticOperator.Type.MULT;
                break;
            case BaseSqlParser.DIV :
                type = ArithmeticOperator.Type.DIV;
                break;
            case BaseSqlParser.MOD :
                type = ArithmeticOperator.Type.MOD;
                break;
        }

        return postProcess(new ArithmeticOperator(ctx.left.accept(this), ctx.right.accept(this), type));
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperator visitSearchedCaseOperator(@NotNull BaseSqlParser.SearchedCaseOperatorContext ctx) {
        List<IOperator<Boolean>> whenOps = new ArrayList<IOperator<Boolean>>(ctx.whenExpr.size());
        for (BaseSqlParser.ConditionContext context : ctx.whenExpr) {
            whenOps.add(context.accept(this));
        }
        List<IOperator> thenOps = new ArrayList<IOperator>(ctx.thenExpr.size());
        for (ParserRuleContext context : ctx.thenExpr) {
            thenOps.add(context.accept(this));
        }
        IOperator elseOp = (ctx.elseExpr == null) ? null : ctx.elseExpr.accept(this);

        return postProcess(new SearchedCaseOperator(whenOps, thenOps, elseOp));
    }

    @Override
    public IOperator visitCaseOperator(@NotNull BaseSqlParser.CaseOperatorContext ctx) {
        List<IOperator> whenOps = new ArrayList<IOperator>(ctx.whenExpr.size());
        for (ParserRuleContext context : ctx.whenExpr) {
            whenOps.add(context.accept(this));
        }
        List<IOperator> thenOps = new ArrayList<IOperator>(ctx.thenExpr.size());
        for (ParserRuleContext context : ctx.thenExpr) {
            thenOps.add(context.accept(this));
        }
        IOperator elseOp = (ctx.elseExpr == null) ? null : ctx.elseExpr.accept(this);

        return postProcess(new CaseOperator(ctx.valueExpr.accept(this), whenOps, thenOps, elseOp));
    }
}
