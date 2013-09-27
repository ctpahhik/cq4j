// Generated from BaseSql.g4 by ANTLR 4.1
package com.github.ctpahhik.cq4j.grammar.generated;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BaseSqlParser}.
 */
public interface BaseSqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(@NotNull BaseSqlParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(@NotNull BaseSqlParser.WhereClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#Field}.
	 * @param ctx the parse tree
	 */
	void enterField(@NotNull BaseSqlParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#Field}.
	 * @param ctx the parse tree
	 */
	void exitField(@NotNull BaseSqlParser.FieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(@NotNull BaseSqlParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(@NotNull BaseSqlParser.QueryContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#NegatablePredicate}.
	 * @param ctx the parse tree
	 */
	void enterNegatablePredicate(@NotNull BaseSqlParser.NegatablePredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#NegatablePredicate}.
	 * @param ctx the parse tree
	 */
	void exitNegatablePredicate(@NotNull BaseSqlParser.NegatablePredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#AndOperator}.
	 * @param ctx the parse tree
	 */
	void enterAndOperator(@NotNull BaseSqlParser.AndOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#AndOperator}.
	 * @param ctx the parse tree
	 */
	void exitAndOperator(@NotNull BaseSqlParser.AndOperatorContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#NotCondition}.
	 * @param ctx the parse tree
	 */
	void enterNotCondition(@NotNull BaseSqlParser.NotConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#NotCondition}.
	 * @param ctx the parse tree
	 */
	void exitNotCondition(@NotNull BaseSqlParser.NotConditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#simpleCondition}.
	 * @param ctx the parse tree
	 */
	void enterSimpleCondition(@NotNull BaseSqlParser.SimpleConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#simpleCondition}.
	 * @param ctx the parse tree
	 */
	void exitSimpleCondition(@NotNull BaseSqlParser.SimpleConditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#SkipCondition}.
	 * @param ctx the parse tree
	 */
	void enterSkipCondition(@NotNull BaseSqlParser.SkipConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#SkipCondition}.
	 * @param ctx the parse tree
	 */
	void exitSkipCondition(@NotNull BaseSqlParser.SkipConditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#BetweenPredicate}.
	 * @param ctx the parse tree
	 */
	void enterBetweenPredicate(@NotNull BaseSqlParser.BetweenPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#BetweenPredicate}.
	 * @param ctx the parse tree
	 */
	void exitBetweenPredicate(@NotNull BaseSqlParser.BetweenPredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#SkipPredicate}.
	 * @param ctx the parse tree
	 */
	void enterSkipPredicate(@NotNull BaseSqlParser.SkipPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#SkipPredicate}.
	 * @param ctx the parse tree
	 */
	void exitSkipPredicate(@NotNull BaseSqlParser.SkipPredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#Float}.
	 * @param ctx the parse tree
	 */
	void enterFloat(@NotNull BaseSqlParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#Float}.
	 * @param ctx the parse tree
	 */
	void exitFloat(@NotNull BaseSqlParser.FloatContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#CaseOperator}.
	 * @param ctx the parse tree
	 */
	void enterCaseOperator(@NotNull BaseSqlParser.CaseOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#CaseOperator}.
	 * @param ctx the parse tree
	 */
	void exitCaseOperator(@NotNull BaseSqlParser.CaseOperatorContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#SearchedCaseOperator}.
	 * @param ctx the parse tree
	 */
	void enterSearchedCaseOperator(@NotNull BaseSqlParser.SearchedCaseOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#SearchedCaseOperator}.
	 * @param ctx the parse tree
	 */
	void exitSearchedCaseOperator(@NotNull BaseSqlParser.SearchedCaseOperatorContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#ComparePredicate}.
	 * @param ctx the parse tree
	 */
	void enterComparePredicate(@NotNull BaseSqlParser.ComparePredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#ComparePredicate}.
	 * @param ctx the parse tree
	 */
	void exitComparePredicate(@NotNull BaseSqlParser.ComparePredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#IsNullPredicate}.
	 * @param ctx the parse tree
	 */
	void enterIsNullPredicate(@NotNull BaseSqlParser.IsNullPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#IsNullPredicate}.
	 * @param ctx the parse tree
	 */
	void exitIsNullPredicate(@NotNull BaseSqlParser.IsNullPredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#SkipExpression}.
	 * @param ctx the parse tree
	 */
	void enterSkipExpression(@NotNull BaseSqlParser.SkipExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#SkipExpression}.
	 * @param ctx the parse tree
	 */
	void exitSkipExpression(@NotNull BaseSqlParser.SkipExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderByClause(@NotNull BaseSqlParser.OrderByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderByClause(@NotNull BaseSqlParser.OrderByClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#InPredicate}.
	 * @param ctx the parse tree
	 */
	void enterInPredicate(@NotNull BaseSqlParser.InPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#InPredicate}.
	 * @param ctx the parse tree
	 */
	void exitInPredicate(@NotNull BaseSqlParser.InPredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#Boolean}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(@NotNull BaseSqlParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#Boolean}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(@NotNull BaseSqlParser.BooleanContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(@NotNull BaseSqlParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(@NotNull BaseSqlParser.ComparisonContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#InFunction}.
	 * @param ctx the parse tree
	 */
	void enterInFunction(@NotNull BaseSqlParser.InFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#InFunction}.
	 * @param ctx the parse tree
	 */
	void exitInFunction(@NotNull BaseSqlParser.InFunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#SimpleFunction}.
	 * @param ctx the parse tree
	 */
	void enterSimpleFunction(@NotNull BaseSqlParser.SimpleFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#SimpleFunction}.
	 * @param ctx the parse tree
	 */
	void exitSimpleFunction(@NotNull BaseSqlParser.SimpleFunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#ArithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticOperator(@NotNull BaseSqlParser.ArithmeticOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#ArithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticOperator(@NotNull BaseSqlParser.ArithmeticOperatorContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#fromExpression}.
	 * @param ctx the parse tree
	 */
	void enterFromExpression(@NotNull BaseSqlParser.FromExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#fromExpression}.
	 * @param ctx the parse tree
	 */
	void exitFromExpression(@NotNull BaseSqlParser.FromExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#OrOperator}.
	 * @param ctx the parse tree
	 */
	void enterOrOperator(@NotNull BaseSqlParser.OrOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#OrOperator}.
	 * @param ctx the parse tree
	 */
	void exitOrOperator(@NotNull BaseSqlParser.OrOperatorContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#String}.
	 * @param ctx the parse tree
	 */
	void enterString(@NotNull BaseSqlParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#String}.
	 * @param ctx the parse tree
	 */
	void exitString(@NotNull BaseSqlParser.StringContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#UnaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(@NotNull BaseSqlParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#UnaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(@NotNull BaseSqlParser.UnaryOperatorContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#selectExpression}.
	 * @param ctx the parse tree
	 */
	void enterSelectExpression(@NotNull BaseSqlParser.SelectExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#selectExpression}.
	 * @param ctx the parse tree
	 */
	void exitSelectExpression(@NotNull BaseSqlParser.SelectExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#Integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(@NotNull BaseSqlParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#Integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(@NotNull BaseSqlParser.IntegerContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupByClause(@NotNull BaseSqlParser.GroupByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupByClause(@NotNull BaseSqlParser.GroupByClauseContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseSqlParser#Null}.
	 * @param ctx the parse tree
	 */
	void enterNull(@NotNull BaseSqlParser.NullContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseSqlParser#Null}.
	 * @param ctx the parse tree
	 */
	void exitNull(@NotNull BaseSqlParser.NullContext ctx);
}