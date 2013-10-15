// Generated from BaseSql.g4 by ANTLR 4.1
package com.github.ctpahhik.cq4j.grammar.generated;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BaseSqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BaseSqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(@NotNull BaseSqlParser.WhereClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#Field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(@NotNull BaseSqlParser.FieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(@NotNull BaseSqlParser.QueryContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#NegatablePredicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegatablePredicate(@NotNull BaseSqlParser.NegatablePredicateContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#AndOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOperator(@NotNull BaseSqlParser.AndOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#NotCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCondition(@NotNull BaseSqlParser.NotConditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#simpleCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleCondition(@NotNull BaseSqlParser.SimpleConditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#orderByElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByElement(@NotNull BaseSqlParser.OrderByElementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#SkipCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipCondition(@NotNull BaseSqlParser.SkipConditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(@NotNull BaseSqlParser.TableNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#BetweenPredicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenPredicate(@NotNull BaseSqlParser.BetweenPredicateContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#SkipPredicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipPredicate(@NotNull BaseSqlParser.SkipPredicateContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#Float}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat(@NotNull BaseSqlParser.FloatContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#SearchedCaseOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchedCaseOperator(@NotNull BaseSqlParser.SearchedCaseOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#CaseOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseOperator(@NotNull BaseSqlParser.CaseOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#ComparePredicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparePredicate(@NotNull BaseSqlParser.ComparePredicateContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#TableField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableField(@NotNull BaseSqlParser.TableFieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#fromElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromElement(@NotNull BaseSqlParser.FromElementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#IsNullPredicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsNullPredicate(@NotNull BaseSqlParser.IsNullPredicateContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#SkipExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipExpression(@NotNull BaseSqlParser.SkipExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#orderByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByClause(@NotNull BaseSqlParser.OrderByClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#InPredicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInPredicate(@NotNull BaseSqlParser.InPredicateContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#selectElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectElement(@NotNull BaseSqlParser.SelectElementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#Boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(@NotNull BaseSqlParser.BooleanContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(@NotNull BaseSqlParser.ComparisonContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#InFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInFunction(@NotNull BaseSqlParser.InFunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#SimpleFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleFunction(@NotNull BaseSqlParser.SimpleFunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#ArithmeticOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticOperator(@NotNull BaseSqlParser.ArithmeticOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#fromExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromExpression(@NotNull BaseSqlParser.FromExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#OrOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrOperator(@NotNull BaseSqlParser.OrOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#String}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(@NotNull BaseSqlParser.StringContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#UnaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(@NotNull BaseSqlParser.UnaryOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#selectExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectExpression(@NotNull BaseSqlParser.SelectExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#Integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(@NotNull BaseSqlParser.IntegerContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#groupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByClause(@NotNull BaseSqlParser.GroupByClauseContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseSqlParser#Null}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull(@NotNull BaseSqlParser.NullContext ctx);
}