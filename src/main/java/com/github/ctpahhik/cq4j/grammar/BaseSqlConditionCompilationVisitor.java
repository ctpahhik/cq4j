package com.github.ctpahhik.cq4j.grammar;

import com.github.ctpahhik.cq4j.common.FunctionsFactory;
import com.github.ctpahhik.cq4j.common.IDataProvider;
import com.github.ctpahhik.cq4j.common.IOperation;
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
public class BaseSqlConditionCompilationVisitor extends AbstractParseTreeVisitor<IOperation> implements BaseSqlVisitor<IOperation> {

    private IDataProvider dataProvider;
    private FunctionsFactory factory;

    public BaseSqlConditionCompilationVisitor(IDataProvider dataProvider, FunctionsFactory factory) {
        this.dataProvider = dataProvider;
        this.factory = factory;
    }

    @Override
    public IOperation visitFloat(@NotNull BaseSqlParser.FloatContext ctx) {
        return new ConstantOperation<Number>(Float.parseFloat(ctx.getText())); //TODO: parse Double and BigDecimal
    }

    @Override
    public IOperation visitWhereClause(@NotNull BaseSqlParser.WhereClauseContext ctx) {
        return ctx.value.accept(this);
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperation visitOrOperand(@NotNull BaseSqlParser.OrOperandContext ctx) {
        return new OrOperation(ctx.left.accept(this), ctx.right.accept(this));
    }

    @Override
    public IOperation visitField(@NotNull BaseSqlParser.FieldContext ctx) {
        return new DataAccessOperation(dataProvider, ctx.getText());
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperation visitComparePredicate(@NotNull BaseSqlParser.ComparePredicateContext ctx) {
        CompareOperation.Type type = null;
        switch (ctx.operand.getType()) {
            case BaseSqlParser.LT :
                type = CompareOperation.Type.LT_EQ;
                break;
            case BaseSqlParser.LT_EQ :
                type = CompareOperation.Type.LT;
                break;
            case BaseSqlParser.GT :
                type = CompareOperation.Type.GT;
                break;
            case BaseSqlParser.GT_EQ :
                type = CompareOperation.Type.GT_EQ;
                break;
            case BaseSqlParser.EQ :
                type = CompareOperation.Type.EQ;
                break;
            case BaseSqlParser.NOT_EQ :
                type = CompareOperation.Type.NOT_EQ;
                break;
        }

        return new CompareOperation(ctx.left.accept(this), ctx.right.accept(this), type);
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperation visitNegatablePredicate(@NotNull BaseSqlParser.NegatablePredicateContext ctx) {
        IOperation<Boolean> operation = ctx.detailedPredicate.accept(this);
        if (ctx.NOT() == null) {
            return operation;
        } else {
            return new NotOperation(operation);
        }
    }

    @Override
    public IOperation visitSkipExpression(@NotNull BaseSqlParser.SkipExpressionContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public IOperation visitInPredicate(@NotNull BaseSqlParser.InPredicateContext ctx) {
        IOperation operationValue = ((BaseSqlParser.NegatablePredicateContext)ctx.getParent()).value.accept(this);
        List<IOperation> listOp = new ArrayList<IOperation>(ctx.el.size());
        for (BaseSqlParser.ExpressionContext context : ctx.el) {
            listOp.add(context.accept(this));
        }
        return new InOperation(operationValue, listOp);
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperation visitNotCondition(@NotNull BaseSqlParser.NotConditionContext ctx) {
        return new NotOperation(ctx.value.accept(this));
    }

    @Override
    public IOperation visitSimpleCondition(@NotNull BaseSqlParser.SimpleConditionContext ctx) {
        return ctx.value.accept(this);
    }

    @Override
    public IOperation visitBoolean(@NotNull BaseSqlParser.BooleanContext ctx) {
        return new ConstantOperation<Boolean>(Boolean.parseBoolean(ctx.getText()));
    }

    @Override
    public IOperation visitComparison(@NotNull BaseSqlParser.ComparisonContext ctx) {
        throw new java.lang.IllegalStateException("Comparison shouldn't be visited directly");
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperation visitInFunction(@NotNull BaseSqlParser.InFunctionContext ctx) {
        String name = ctx.ID().getText();
        IOperation value = ctx.value.accept(this);
        IOperation inValue = ctx.inValue.accept(this);
        IOperation<Integer> fromValue = (ctx.from == null ? null : ctx.from.accept(this));
        return factory.createInFunction(name, value, inValue, fromValue);
    }

    @Override
    public IOperation visitSimpleFunction(@NotNull BaseSqlParser.SimpleFunctionContext ctx) {
        String name = ctx.ID().getText();
        List<IOperation> listOp = new ArrayList<IOperation>(ctx.el.size());
        for (BaseSqlParser.ExpressionContext context : ctx.el) {
            listOp.add(context.accept(this));
        }
        return factory.createSimpleFunction(name, listOp);
    }

    @Override
    public IOperation visitSkipCondition(@NotNull BaseSqlParser.SkipConditionContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public IOperation visitUnaryOperand(@NotNull BaseSqlParser.UnaryOperandContext ctx) {
        IOperation operation = ctx.value.accept(this);
        switch (ctx.operand.getType()) {
            case BaseSqlParser.PLUS :
                return operation;
            case BaseSqlParser.MINUS :
                return new UnaryOperation(operation, UnaryOperation.Type.MINUS);
            default:
                return new UnaryOperation(operation, null);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperation visitAndOperand(@NotNull BaseSqlParser.AndOperandContext ctx) {
        return new AndOperation(ctx.left.accept(this), ctx.right.accept(this));
    }

    @Override
    public IOperation visitString(@NotNull BaseSqlParser.StringContext ctx) {
        String text = ctx.getText();
        return new ConstantOperation<String>(text.substring(1, text.length()-1));
    }

    @Override
    @SuppressWarnings("unchecked")
    public IOperation visitBetweenPredicate(@NotNull BaseSqlParser.BetweenPredicateContext ctx) {
        IOperation<Comparable> operationValue = ((BaseSqlParser.NegatablePredicateContext)ctx.getParent()).value.accept(this);
        return new BetweenOperation(operationValue, ctx.lower.accept(this), ctx.upper.accept(this));
    }

    @Override
    public IOperation visitSkipPredicate(@NotNull BaseSqlParser.SkipPredicateContext ctx) {
        return ctx.value.accept(this);
    }

    @Override
    public IOperation visitInteger(@NotNull BaseSqlParser.IntegerContext ctx) {
        return new ConstantOperation<Number>(Integer.parseInt(ctx.getText())); //TODO: parse Long and BigInteger
    }

    @Override
    public IOperation visitNull(@NotNull BaseSqlParser.NullContext ctx) {
        return null;
    }

    @Override
    public IOperation visitIsNullPredicate(@NotNull BaseSqlParser.IsNullPredicateContext ctx) {
        IOperation<Boolean> operation = new IsNullOperation(ctx.value.accept(this));
        if (ctx.NOT() == null) {
            return operation;
        } else {
            return new NotOperation(operation);
        }
    }

    @Override
    public IOperation visitArithmeticOperand(@NotNull BaseSqlParser.ArithmeticOperandContext ctx) {
        ArithmeticOperation.Type type = null;
        switch (ctx.operand.getType()) {
            case BaseSqlParser.PLUS :
                type = ArithmeticOperation.Type.PLUS;
                break;
            case BaseSqlParser.MINUS :
                type = ArithmeticOperation.Type.MINUS;
                break;
            case BaseSqlParser.MULT :
                type = ArithmeticOperation.Type.MULT;
                break;
            case BaseSqlParser.DIV :
                type = ArithmeticOperation.Type.DIV;
                break;
        }

        return new ArithmeticOperation(ctx.left.accept(this), ctx.right.accept(this), type);
    }

    @Override
    public IOperation visitSearchedCaseFunction(@NotNull BaseSqlParser.SearchedCaseFunctionContext ctx) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IOperation visitCaseFunction(@NotNull BaseSqlParser.CaseFunctionContext ctx) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IOperation visitQuery(@NotNull BaseSqlParser.QueryContext ctx) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IOperation visitOrderByClause(@NotNull BaseSqlParser.OrderByClauseContext ctx) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IOperation visitFromExpression(@NotNull BaseSqlParser.FromExpressionContext ctx) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IOperation visitSelectExpression(@NotNull BaseSqlParser.SelectExpressionContext ctx) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IOperation visitGroupByClause(@NotNull BaseSqlParser.GroupByClauseContext ctx) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
