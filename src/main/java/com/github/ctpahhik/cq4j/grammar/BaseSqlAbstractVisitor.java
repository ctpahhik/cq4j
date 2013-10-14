// Generated from BaseSql.g4 by ANTLR 4.1
package com.github.ctpahhik.cq4j.grammar;
import com.github.ctpahhik.cq4j.common.IDataAdapter;
import com.github.ctpahhik.cq4j.data.BeanCodeGenDataAdapter;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlParser;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlVisitor;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * This class provides an empty implementation of {@link com.github.ctpahhik.cq4j.grammar.generated.BaseSqlVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public abstract class BaseSqlAbstractVisitor<T> extends AbstractParseTreeVisitor<T> implements BaseSqlVisitor<T> {

    private static ConcurrentMap<Class, IDataAdapter> cache = new ConcurrentHashMap<Class, IDataAdapter>();

    @SuppressWarnings("unchecked")
    protected static <V> IDataAdapter<V> getDefaultDataAdapter(Class<V> clazz) {
        IDataAdapter<V> result = cache.get(clazz);
        if (result == null) {
            cache.putIfAbsent(clazz, new BeanCodeGenDataAdapter<V>(clazz));
            result = cache.get(clazz);
        }

        return result;
    }

    protected static Map<String, IDataAdapter> buildAdaptersMap(Class... classes) {
        Map<String, IDataAdapter> result = new HashMap<String, IDataAdapter>();
        for (Class clazz : classes) {
            result.put(clazz.getSimpleName().toLowerCase(), getDefaultDataAdapter(clazz));
        }
        return result;
    }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitWhereClause(@NotNull BaseSqlParser.WhereClauseContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitField(@NotNull BaseSqlParser.FieldContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitQuery(@NotNull BaseSqlParser.QueryContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitNegatablePredicate(@NotNull BaseSqlParser.NegatablePredicateContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitAndOperator(@NotNull BaseSqlParser.AndOperatorContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitNotCondition(@NotNull BaseSqlParser.NotConditionContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitSimpleCondition(@NotNull BaseSqlParser.SimpleConditionContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitSkipCondition(@NotNull BaseSqlParser.SkipConditionContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitTableName(@NotNull BaseSqlParser.TableNameContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitBetweenPredicate(@NotNull BaseSqlParser.BetweenPredicateContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitSkipPredicate(@NotNull BaseSqlParser.SkipPredicateContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitFloat(@NotNull BaseSqlParser.FloatContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitSearchedCaseOperator(@NotNull BaseSqlParser.SearchedCaseOperatorContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitCaseOperator(@NotNull BaseSqlParser.CaseOperatorContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitComparePredicate(@NotNull BaseSqlParser.ComparePredicateContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitFromElement(@NotNull BaseSqlParser.FromElementContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitIsNullPredicate(@NotNull BaseSqlParser.IsNullPredicateContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitSkipExpression(@NotNull BaseSqlParser.SkipExpressionContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitOrderByClause(@NotNull BaseSqlParser.OrderByClauseContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitInPredicate(@NotNull BaseSqlParser.InPredicateContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitSelectElement(@NotNull BaseSqlParser.SelectElementContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitBoolean(@NotNull BaseSqlParser.BooleanContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitComparison(@NotNull BaseSqlParser.ComparisonContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitInFunction(@NotNull BaseSqlParser.InFunctionContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitSimpleFunction(@NotNull BaseSqlParser.SimpleFunctionContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitArithmeticOperator(@NotNull BaseSqlParser.ArithmeticOperatorContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitFromExpression(@NotNull BaseSqlParser.FromExpressionContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitOrOperator(@NotNull BaseSqlParser.OrOperatorContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitString(@NotNull BaseSqlParser.StringContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitUnaryOperator(@NotNull BaseSqlParser.UnaryOperatorContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitSelectExpression(@NotNull BaseSqlParser.SelectExpressionContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitInteger(@NotNull BaseSqlParser.IntegerContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitGroupByClause(@NotNull BaseSqlParser.GroupByClauseContext ctx) { throw new UnsupportedOperationException(); }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 */
	@Override public T visitNull(@NotNull BaseSqlParser.NullContext ctx) { throw new UnsupportedOperationException(); }
}