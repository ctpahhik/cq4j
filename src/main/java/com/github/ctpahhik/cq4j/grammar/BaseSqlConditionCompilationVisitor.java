package com.github.ctpahhik.cq4j.grammar;

import com.github.ctpahhik.cq4j.functions.FunctionsFactory;
import com.github.ctpahhik.cq4j.common.IDataAdapter;
import com.github.ctpahhik.cq4j.common.IOperator;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlParser;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlVisitor;
import com.github.ctpahhik.cq4j.operations.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides an empty implementation of {@link com.github.ctpahhik.cq4j.grammar.generated.BaseSqlVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 */
public class BaseSqlConditionCompilationVisitor extends AbstractParseTreeVisitor<IOperator> implements BaseSqlVisitor<IOperator> {

    private IDataAdapter dataAdapter;
    private FunctionsFactory factory;

    public BaseSqlConditionCompilationVisitor(IDataAdapter dataAdapter, FunctionsFactory factory) {
        this.dataAdapter = dataAdapter;
        this.factory = factory;
    }

    @Override
    public IOperator visitFloat(@NotNull BaseSqlParser.FloatContext ctx) {
        return new ConstantOperator<Number>(Float.parseFloat(ctx.getText())); //TODO: parse Double and BigDecimal
    }

    @Override
    public IOperator visitWhereClause(@NotNull BaseSqlParser.WhereClauseContext ctx) {
        return ctx.value.accept(this);
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperator visitOrOperator(@NotNull BaseSqlParser.OrOperatorContext ctx) {
        return new OrOperator(ctx.left.accept(this), ctx.right.accept(this));
    }

    @Override
    public IOperator visitField(@NotNull BaseSqlParser.FieldContext ctx) {
        return new DataAccessOperator(dataAdapter, ctx.getText());
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

        return new CompareOperator(ctx.left.accept(this), ctx.right.accept(this), type);
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperator visitNegatablePredicate(@NotNull BaseSqlParser.NegatablePredicateContext ctx) {
        IOperator<Boolean> operation = ctx.detailedPredicate.accept(this);
        if (ctx.NOT() == null) {
            return operation;
        } else {
            return new NotOperator(operation);
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
        for (BaseSqlParser.ExpressionContext context : ctx.el) {
            listOp.add(context.accept(this));
        }
        return new InOperator(operationValue, listOp);
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperator visitNotCondition(@NotNull BaseSqlParser.NotConditionContext ctx) {
        return new NotOperator(ctx.value.accept(this));
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
        return factory.createInFunction(name, value, inValue, fromValue);
    }

    @Override
    public IOperator visitSimpleFunction(@NotNull BaseSqlParser.SimpleFunctionContext ctx) {
        String name = ctx.ID().getText();
        List<IOperator> listOp = new ArrayList<IOperator>(ctx.el.size());
        for (BaseSqlParser.ExpressionContext context : ctx.el) {
            listOp.add(context.accept(this));
        }
        return factory.createSimpleFunction(name, listOp);
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
                return new UnaryOperator(operation, UnaryOperator.Type.MINUS);
            default:
                return new UnaryOperator(operation, null);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperator visitAndOperator(@NotNull BaseSqlParser.AndOperatorContext ctx) {
        return new AndOperator(ctx.left.accept(this), ctx.right.accept(this));
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
        return new BetweenOperator(operationValue, ctx.lower.accept(this), ctx.upper.accept(this));
    }

    @Override
    public IOperator visitSkipPredicate(@NotNull BaseSqlParser.SkipPredicateContext ctx) {
        return ctx.value.accept(this);
    }

    @Override
    public IOperator visitInteger(@NotNull BaseSqlParser.IntegerContext ctx) {
        return new ConstantOperator<Number>(Integer.parseInt(ctx.getText())); //TODO: parse Long and BigInteger
    }

    @Override
    public IOperator visitNull(@NotNull BaseSqlParser.NullContext ctx) {
        return null;
    }

    @Override
    public IOperator visitIsNullPredicate(@NotNull BaseSqlParser.IsNullPredicateContext ctx) {
        IOperator<Boolean> operation = new IsNullOperator(ctx.value.accept(this));
        if (ctx.NOT() == null) {
            return operation;
        } else {
            return new NotOperator(operation);
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
            case BaseSqlParser.MULT :
                type = ArithmeticOperator.Type.MULT;
                break;
            case BaseSqlParser.DIV :
                type = ArithmeticOperator.Type.DIV;
                break;
        }

        return new ArithmeticOperator(ctx.left.accept(this), ctx.right.accept(this), type);
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperator visitSearchedCaseOperator(@NotNull BaseSqlParser.SearchedCaseOperatorContext ctx) {
        List<IOperator<Boolean>> whenOps = new ArrayList<IOperator<Boolean>>(ctx.whenExpr.size());
        for (BaseSqlParser.ConditionContext context : ctx.whenExpr) {
            whenOps.add(context.accept(this));
        }
        List<IOperator> thenOps = new ArrayList<IOperator>(ctx.thenExpr.size());
        for (BaseSqlParser.ExpressionContext context : ctx.thenExpr) {
            thenOps.add(context.accept(this));
        }
        IOperator elseOp = (ctx.elseExpr == null) ? null : ctx.elseExpr.accept(this);

        return new SearchedCaseOperator(whenOps, thenOps, elseOp);
    }

    @Override
    public IOperator visitCaseOperator(@NotNull BaseSqlParser.CaseOperatorContext ctx) {
        List<IOperator> whenOps = new ArrayList<IOperator>(ctx.whenExpr.size());
        for (BaseSqlParser.ExpressionContext context : ctx.whenExpr) {
            whenOps.add(context.accept(this));
        }
        List<IOperator> thenOps = new ArrayList<IOperator>(ctx.thenExpr.size());
        for (BaseSqlParser.ExpressionContext context : ctx.thenExpr) {
            thenOps.add(context.accept(this));
        }
        IOperator elseOp = (ctx.elseExpr == null) ? null : ctx.elseExpr.accept(this);

        return new CaseOperator(ctx.valueExpr.accept(this), whenOps, thenOps, elseOp);
    }

    @Override
    public IOperator visitQuery(@NotNull BaseSqlParser.QueryContext ctx) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IOperator visitOrderByClause(@NotNull BaseSqlParser.OrderByClauseContext ctx) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IOperator visitFromExpression(@NotNull BaseSqlParser.FromExpressionContext ctx) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IOperator visitSelectExpression(@NotNull BaseSqlParser.SelectExpressionContext ctx) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IOperator visitGroupByClause(@NotNull BaseSqlParser.GroupByClauseContext ctx) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
