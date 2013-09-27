// Generated from BaseSql.g4 by ANTLR 4.1
package com.github.ctpahhik.cq4j.grammar.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BaseSqlParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS=1, MINUS=2, MULT=3, DIV=4, AND=5, OR=6, AS=7, BETWEEN=8, NOT=9, NULL=10, 
		IN=11, IS=12, L_PAREN=13, R_PAREN=14, COMA=15, LT_EQ=16, LT=17, GT_EQ=18, 
		GT=19, EQ=20, NOT_EQ=21, SELECT=22, FROM=23, JOIN=24, WHERE=25, ORDER_BY=26, 
		GROUP_BY=27, CASE=28, WHEN=29, THEN=30, ELSE=31, END=32, BOOLEAN=33, ID=34, 
		INT=35, FLOAT=36, STRING=37, WS=38;
	public static final String[] tokenNames = {
		"<INVALID>", "'+'", "'-'", "'*'", "'/'", "'and'", "'or'", "'as'", "'between'", 
		"'not'", "'null'", "'in'", "'is'", "'('", "')'", "','", "LT_EQ", "'<'", 
		"GT_EQ", "'>'", "'='", "NOT_EQ", "'select'", "'from'", "'join'", "'where'", 
		"ORDER_BY", "GROUP_BY", "'case'", "'when'", "'then'", "'else'", "'end'", 
		"BOOLEAN", "ID", "INT", "FLOAT", "STRING", "WS"
	};
	public static final int
		RULE_query = 0, RULE_selectExpression = 1, RULE_fromExpression = 2, RULE_groupByClause = 3, 
		RULE_orderByClause = 4, RULE_whereClause = 5, RULE_simpleCondition = 6, 
		RULE_condition = 7, RULE_predicate = 8, RULE_subPredicate = 9, RULE_comparison = 10, 
		RULE_expression = 11, RULE_function = 12, RULE_primitive = 13;
	public static final String[] ruleNames = {
		"query", "selectExpression", "fromExpression", "groupByClause", "orderByClause", 
		"whereClause", "simpleCondition", "condition", "predicate", "subPredicate", 
		"comparison", "expression", "function", "primitive"
	};

	@Override
	public String getGrammarFileName() { return "BaseSql.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public BaseSqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueryContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(BaseSqlParser.WHERE, 0); }
		public OrderByClauseContext orderByClause() {
			return getRuleContext(OrderByClauseContext.class,0);
		}
		public FromExpressionContext fromExpression() {
			return getRuleContext(FromExpressionContext.class,0);
		}
		public TerminalNode ORDER_BY() { return getToken(BaseSqlParser.ORDER_BY, 0); }
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public GroupByClauseContext groupByClause() {
			return getRuleContext(GroupByClauseContext.class,0);
		}
		public TerminalNode GROUP_BY() { return getToken(BaseSqlParser.GROUP_BY, 0); }
		public SelectExpressionContext selectExpression() {
			return getRuleContext(SelectExpressionContext.class,0);
		}
		public TerminalNode SELECT() { return getToken(BaseSqlParser.SELECT, 0); }
		public TerminalNode FROM() { return getToken(BaseSqlParser.FROM, 0); }
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); match(SELECT);
			setState(29); selectExpression();
			setState(30); match(FROM);
			setState(31); fromExpression();
			setState(34);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(32); match(WHERE);
				setState(33); whereClause();
				}
			}

			setState(38);
			_la = _input.LA(1);
			if (_la==GROUP_BY) {
				{
				setState(36); match(GROUP_BY);
				setState(37); groupByClause();
				}
			}

			setState(42);
			_la = _input.LA(1);
			if (_la==ORDER_BY) {
				{
				setState(40); match(ORDER_BY);
				setState(41); orderByClause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectExpressionContext extends ParserRuleContext {
		public SelectExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterSelectExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitSelectExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitSelectExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectExpressionContext selectExpression() throws RecognitionException {
		SelectExpressionContext _localctx = new SelectExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_selectExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=1 && _alt!=-1 ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(44);
					matchWildcard();
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromExpressionContext extends ParserRuleContext {
		public FromExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterFromExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitFromExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitFromExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromExpressionContext fromExpression() throws RecognitionException {
		FromExpressionContext _localctx = new FromExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fromExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=1 && _alt!=-1 ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(50);
					matchWildcard();
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupByClauseContext extends ParserRuleContext {
		public GroupByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterGroupByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitGroupByClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitGroupByClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupByClauseContext groupByClause() throws RecognitionException {
		GroupByClauseContext _localctx = new GroupByClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_groupByClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=1 && _alt!=-1 ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(56);
					matchWildcard();
					}
					} 
				}
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderByClauseContext extends ParserRuleContext {
		public OrderByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterOrderByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitOrderByClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitOrderByClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderByClauseContext orderByClause() throws RecognitionException {
		OrderByClauseContext _localctx = new OrderByClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_orderByClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=1 && _alt!=-1 ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(62);
					matchWildcard();
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereClauseContext extends ParserRuleContext {
		public ConditionContext value;
		public TerminalNode WHERE() { return getToken(BaseSqlParser.WHERE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); match(WHERE);
			setState(69); ((WhereClauseContext)_localctx).value = condition(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleConditionContext extends ParserRuleContext {
		public ConditionContext value;
		public TerminalNode EOF() { return getToken(BaseSqlParser.EOF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public SimpleConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterSimpleCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitSimpleCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitSimpleCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleConditionContext simpleCondition() throws RecognitionException {
		SimpleConditionContext _localctx = new SimpleConditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_simpleCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); ((SimpleConditionContext)_localctx).value = condition(0);
			setState(72); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public int _p;
		public ConditionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ConditionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class SkipConditionContext extends ConditionContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public SkipConditionContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterSkipCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitSkipCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitSkipCondition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrOperatorContext extends ConditionContext {
		public ConditionContext left;
		public ConditionContext right;
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode OR() { return getToken(BaseSqlParser.OR, 0); }
		public OrOperatorContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterOrOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitOrOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitOrOperator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndOperatorContext extends ConditionContext {
		public ConditionContext left;
		public ConditionContext right;
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode AND() { return getToken(BaseSqlParser.AND, 0); }
		public AndOperatorContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterAndOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitAndOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitAndOperator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotConditionContext extends ConditionContext {
		public ConditionContext value;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(BaseSqlParser.NOT, 0); }
		public NotConditionContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterNotCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitNotCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitNotCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState, _p);
		ConditionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, RULE_condition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new NotConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(75); match(NOT);
				setState(76); ((NotConditionContext)_localctx).value = condition(5);
				}
				break;

			case 2:
				{
				_localctx = new SkipConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77); match(L_PAREN);
				setState(78); condition(0);
				setState(79); match(R_PAREN);
				}
				break;

			case 3:
				{
				_localctx = new SkipConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81); predicate();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(92);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(90);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new AndOperatorContext(new ConditionContext(_parentctx, _parentState, _p));
						((AndOperatorContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(84);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(85); match(AND);
						setState(86); ((AndOperatorContext)_localctx).right = condition(4);
						}
						break;

					case 2:
						{
						_localctx = new OrOperatorContext(new ConditionContext(_parentctx, _parentState, _p));
						((OrOperatorContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(87);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(88); match(OR);
						setState(89); ((OrOperatorContext)_localctx).right = condition(3);
						}
						break;
					}
					} 
				}
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
	 
		public PredicateContext() { }
		public void copyFrom(PredicateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComparePredicateContext extends PredicateContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LT() { return getToken(BaseSqlParser.LT, 0); }
		public TerminalNode LT_EQ() { return getToken(BaseSqlParser.LT_EQ, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode GT() { return getToken(BaseSqlParser.GT, 0); }
		public TerminalNode NOT_EQ() { return getToken(BaseSqlParser.NOT_EQ, 0); }
		public TerminalNode GT_EQ() { return getToken(BaseSqlParser.GT_EQ, 0); }
		public TerminalNode EQ() { return getToken(BaseSqlParser.EQ, 0); }
		public ComparePredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterComparePredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitComparePredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitComparePredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsNullPredicateContext extends PredicateContext {
		public ExpressionContext value;
		public TerminalNode NOT() { return getToken(BaseSqlParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IS() { return getToken(BaseSqlParser.IS, 0); }
		public TerminalNode NULL() { return getToken(BaseSqlParser.NULL, 0); }
		public IsNullPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterIsNullPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitIsNullPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitIsNullPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegatablePredicateContext extends PredicateContext {
		public ExpressionContext value;
		public SubPredicateContext detailedPredicate;
		public TerminalNode NOT() { return getToken(BaseSqlParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SubPredicateContext subPredicate() {
			return getRuleContext(SubPredicateContext.class,0);
		}
		public NegatablePredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterNegatablePredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitNegatablePredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitNegatablePredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkipPredicateContext extends PredicateContext {
		public ExpressionContext value;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SkipPredicateContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterSkipPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitSkipPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitSkipPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanContext extends PredicateContext {
		public Token value;
		public TerminalNode BOOLEAN() { return getToken(BaseSqlParser.BOOLEAN, 0); }
		public BooleanContext(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_predicate);
		int _la;
		try {
			setState(114);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(95); ((BooleanContext)_localctx).value = match(BOOLEAN);
				}
				break;

			case 2:
				_localctx = new SkipPredicateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(96); ((SkipPredicateContext)_localctx).value = expression(0);
				}
				break;

			case 3:
				_localctx = new IsNullPredicateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(97); ((IsNullPredicateContext)_localctx).value = expression(0);
				setState(98); match(IS);
				setState(100);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(99); match(NOT);
					}
				}

				setState(102); match(NULL);
				}
				break;

			case 4:
				_localctx = new ComparePredicateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(104); ((ComparePredicateContext)_localctx).left = expression(0);
				setState(105);
				((ComparePredicateContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT_EQ) | (1L << LT) | (1L << GT_EQ) | (1L << GT) | (1L << EQ) | (1L << NOT_EQ))) != 0)) ) {
					((ComparePredicateContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(106); ((ComparePredicateContext)_localctx).right = expression(0);
				}
				break;

			case 5:
				_localctx = new NegatablePredicateContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(108); ((NegatablePredicateContext)_localctx).value = expression(0);
				setState(110);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(109); match(NOT);
					}
				}

				setState(112); ((NegatablePredicateContext)_localctx).detailedPredicate = subPredicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubPredicateContext extends ParserRuleContext {
		public SubPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subPredicate; }
	 
		public SubPredicateContext() { }
		public void copyFrom(SubPredicateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BetweenPredicateContext extends SubPredicateContext {
		public ExpressionContext lower;
		public ExpressionContext upper;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BETWEEN() { return getToken(BaseSqlParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(BaseSqlParser.AND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public BetweenPredicateContext(SubPredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterBetweenPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitBetweenPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitBetweenPredicate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InPredicateContext extends SubPredicateContext {
		public ExpressionContext expression;
		public List<ExpressionContext> el = new ArrayList<ExpressionContext>();
		public TerminalNode IN() { return getToken(BaseSqlParser.IN, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode R_PAREN() { return getToken(BaseSqlParser.R_PAREN, 0); }
		public TerminalNode L_PAREN() { return getToken(BaseSqlParser.L_PAREN, 0); }
		public List<TerminalNode> COMA() { return getTokens(BaseSqlParser.COMA); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode COMA(int i) {
			return getToken(BaseSqlParser.COMA, i);
		}
		public InPredicateContext(SubPredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterInPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitInPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitInPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubPredicateContext subPredicate() throws RecognitionException {
		SubPredicateContext _localctx = new SubPredicateContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_subPredicate);
		int _la;
		try {
			setState(133);
			switch (_input.LA(1)) {
			case BETWEEN:
				_localctx = new BetweenPredicateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(116); match(BETWEEN);
				setState(117); ((BetweenPredicateContext)_localctx).lower = expression(0);
				setState(118); match(AND);
				setState(119); ((BetweenPredicateContext)_localctx).upper = expression(0);
				}
				break;
			case IN:
				_localctx = new InPredicateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121); match(IN);
				setState(122); match(L_PAREN);
				setState(123); ((InPredicateContext)_localctx).expression = expression(0);
				((InPredicateContext)_localctx).el.add(((InPredicateContext)_localctx).expression);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(124); match(COMA);
					setState(125); ((InPredicateContext)_localctx).expression = expression(0);
					((InPredicateContext)_localctx).el.add(((InPredicateContext)_localctx).expression);
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(131); match(R_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(BaseSqlParser.LT, 0); }
		public TerminalNode LT_EQ() { return getToken(BaseSqlParser.LT_EQ, 0); }
		public TerminalNode GT() { return getToken(BaseSqlParser.GT, 0); }
		public TerminalNode NOT_EQ() { return getToken(BaseSqlParser.NOT_EQ, 0); }
		public TerminalNode GT_EQ() { return getToken(BaseSqlParser.GT_EQ, 0); }
		public TerminalNode EQ() { return getToken(BaseSqlParser.EQ, 0); }
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT_EQ) | (1L << LT) | (1L << GT_EQ) | (1L << GT) | (1L << EQ) | (1L << NOT_EQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public int _p;
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class CaseOperatorContext extends ExpressionContext {
		public ExpressionContext valueExpr;
		public ExpressionContext expression;
		public List<ExpressionContext> whenExpr = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> thenExpr = new ArrayList<ExpressionContext>();
		public ExpressionContext elseExpr;
		public List<TerminalNode> THEN() { return getTokens(BaseSqlParser.THEN); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode WHEN(int i) {
			return getToken(BaseSqlParser.WHEN, i);
		}
		public TerminalNode THEN(int i) {
			return getToken(BaseSqlParser.THEN, i);
		}
		public TerminalNode ELSE() { return getToken(BaseSqlParser.ELSE, 0); }
		public TerminalNode CASE() { return getToken(BaseSqlParser.CASE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public List<TerminalNode> WHEN() { return getTokens(BaseSqlParser.WHEN); }
		public TerminalNode END() { return getToken(BaseSqlParser.END, 0); }
		public CaseOperatorContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterCaseOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitCaseOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitCaseOperator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SearchedCaseOperatorContext extends ExpressionContext {
		public ConditionContext condition;
		public List<ConditionContext> whenExpr = new ArrayList<ConditionContext>();
		public ExpressionContext expression;
		public List<ExpressionContext> thenExpr = new ArrayList<ExpressionContext>();
		public ExpressionContext elseExpr;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> THEN() { return getTokens(BaseSqlParser.THEN); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public TerminalNode WHEN(int i) {
			return getToken(BaseSqlParser.WHEN, i);
		}
		public TerminalNode THEN(int i) {
			return getToken(BaseSqlParser.THEN, i);
		}
		public TerminalNode ELSE() { return getToken(BaseSqlParser.ELSE, 0); }
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode CASE() { return getToken(BaseSqlParser.CASE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public List<TerminalNode> WHEN() { return getTokens(BaseSqlParser.WHEN); }
		public TerminalNode END() { return getToken(BaseSqlParser.END, 0); }
		public SearchedCaseOperatorContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterSearchedCaseOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitSearchedCaseOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitSearchedCaseOperator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticOperatorContext extends ExpressionContext {
		public ExpressionContext left;
		public Token operator;
		public ExpressionContext right;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(BaseSqlParser.MINUS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode PLUS() { return getToken(BaseSqlParser.PLUS, 0); }
		public ArithmeticOperatorContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterArithmeticOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitArithmeticOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitArithmeticOperator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryOperatorContext extends ExpressionContext {
		public Token operator;
		public ExpressionContext value;
		public TerminalNode MINUS() { return getToken(BaseSqlParser.MINUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(BaseSqlParser.PLUS, 0); }
		public UnaryOperatorContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitUnaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkipExpressionContext extends ExpressionContext {
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public SkipExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterSkipExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitSkipExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitSkipExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryOperatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(138);
				((UnaryOperatorContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((UnaryOperatorContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(139); ((UnaryOperatorContext)_localctx).value = expression(7);
				}
				break;

			case 2:
				{
				_localctx = new SkipExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140); match(L_PAREN);
				setState(141); expression(0);
				setState(142); match(R_PAREN);
				}
				break;

			case 3:
				{
				_localctx = new CaseOperatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144); match(CASE);
				setState(145); ((CaseOperatorContext)_localctx).valueExpr = expression(0);
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(146); match(WHEN);
					setState(147); ((CaseOperatorContext)_localctx).expression = expression(0);
					((CaseOperatorContext)_localctx).whenExpr.add(((CaseOperatorContext)_localctx).expression);
					setState(148); match(THEN);
					setState(149); ((CaseOperatorContext)_localctx).expression = expression(0);
					((CaseOperatorContext)_localctx).thenExpr.add(((CaseOperatorContext)_localctx).expression);
					}
					}
					setState(153); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(157);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(155); match(ELSE);
					setState(156); ((CaseOperatorContext)_localctx).elseExpr = expression(0);
					}
				}

				setState(159); match(END);
				}
				break;

			case 4:
				{
				_localctx = new SearchedCaseOperatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161); match(CASE);
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(162); match(WHEN);
					setState(163); ((SearchedCaseOperatorContext)_localctx).condition = condition(0);
					((SearchedCaseOperatorContext)_localctx).whenExpr.add(((SearchedCaseOperatorContext)_localctx).condition);
					setState(164); match(THEN);
					setState(165); ((SearchedCaseOperatorContext)_localctx).expression = expression(0);
					((SearchedCaseOperatorContext)_localctx).thenExpr.add(((SearchedCaseOperatorContext)_localctx).expression);
					}
					}
					setState(169); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(173);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(171); match(ELSE);
					setState(172); ((SearchedCaseOperatorContext)_localctx).elseExpr = expression(0);
					}
				}

				setState(175); match(END);
				}
				break;

			case 5:
				{
				_localctx = new SkipExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177); function();
				}
				break;

			case 6:
				{
				_localctx = new SkipExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178); primitive();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(187);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticOperatorContext(new ExpressionContext(_parentctx, _parentState, _p));
						((ArithmeticOperatorContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(181);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(182);
						((ArithmeticOperatorContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
							((ArithmeticOperatorContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(183); ((ArithmeticOperatorContext)_localctx).right = expression(7);
						}
						break;

					case 2:
						{
						_localctx = new ArithmeticOperatorContext(new ExpressionContext(_parentctx, _parentState, _p));
						((ArithmeticOperatorContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(184);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(185);
						((ArithmeticOperatorContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ArithmeticOperatorContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(186); ((ArithmeticOperatorContext)_localctx).right = expression(6);
						}
						break;
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	 
		public FunctionContext() { }
		public void copyFrom(FunctionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleFunctionContext extends FunctionContext {
		public ExpressionContext expression;
		public List<ExpressionContext> el = new ArrayList<ExpressionContext>();
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode R_PAREN() { return getToken(BaseSqlParser.R_PAREN, 0); }
		public TerminalNode L_PAREN() { return getToken(BaseSqlParser.L_PAREN, 0); }
		public TerminalNode ID() { return getToken(BaseSqlParser.ID, 0); }
		public List<TerminalNode> COMA() { return getTokens(BaseSqlParser.COMA); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode COMA(int i) {
			return getToken(BaseSqlParser.COMA, i);
		}
		public SimpleFunctionContext(FunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterSimpleFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitSimpleFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitSimpleFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InFunctionContext extends FunctionContext {
		public ExpressionContext value;
		public ExpressionContext inValue;
		public ExpressionContext from;
		public TerminalNode IN() { return getToken(BaseSqlParser.IN, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode R_PAREN() { return getToken(BaseSqlParser.R_PAREN, 0); }
		public TerminalNode L_PAREN() { return getToken(BaseSqlParser.L_PAREN, 0); }
		public TerminalNode ID() { return getToken(BaseSqlParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode FROM() { return getToken(BaseSqlParser.FROM, 0); }
		public InFunctionContext(FunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterInFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitInFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitInFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function);
		int _la;
		try {
			setState(217);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new SimpleFunctionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(192); match(ID);
				setState(193); match(L_PAREN);
				setState(194); ((SimpleFunctionContext)_localctx).expression = expression(0);
				((SimpleFunctionContext)_localctx).el.add(((SimpleFunctionContext)_localctx).expression);
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NULL) | (1L << L_PAREN) | (1L << COMA) | (1L << CASE) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << STRING))) != 0)) {
					{
					{
					setState(196);
					_la = _input.LA(1);
					if (_la==COMA) {
						{
						setState(195); match(COMA);
						}
					}

					setState(198); ((SimpleFunctionContext)_localctx).expression = expression(0);
					((SimpleFunctionContext)_localctx).el.add(((SimpleFunctionContext)_localctx).expression);
					}
					}
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(204); match(R_PAREN);
				}
				break;

			case 2:
				_localctx = new InFunctionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(206); match(ID);
				setState(207); match(L_PAREN);
				setState(208); ((InFunctionContext)_localctx).value = expression(0);
				setState(209); match(IN);
				setState(210); ((InFunctionContext)_localctx).inValue = expression(0);
				setState(213);
				_la = _input.LA(1);
				if (_la==FROM) {
					{
					setState(211); match(FROM);
					setState(212); ((InFunctionContext)_localctx).from = expression(0);
					}
				}

				setState(215); match(R_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveContext extends ParserRuleContext {
		public PrimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive; }
	 
		public PrimitiveContext() { }
		public void copyFrom(PrimitiveContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FloatContext extends PrimitiveContext {
		public TerminalNode FLOAT() { return getToken(BaseSqlParser.FLOAT, 0); }
		public FloatContext(PrimitiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FieldContext extends PrimitiveContext {
		public TerminalNode ID() { return getToken(BaseSqlParser.ID, 0); }
		public FieldContext(PrimitiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends PrimitiveContext {
		public TerminalNode STRING() { return getToken(BaseSqlParser.STRING, 0); }
		public StringContext(PrimitiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerContext extends PrimitiveContext {
		public TerminalNode INT() { return getToken(BaseSqlParser.INT, 0); }
		public IntegerContext(PrimitiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullContext extends PrimitiveContext {
		public TerminalNode NULL() { return getToken(BaseSqlParser.NULL, 0); }
		public NullContext(PrimitiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitNull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitNull(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveContext primitive() throws RecognitionException {
		PrimitiveContext _localctx = new PrimitiveContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_primitive);
		try {
			setState(224);
			switch (_input.LA(1)) {
			case NULL:
				_localctx = new NullContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(219); match(NULL);
				}
				break;
			case ID:
				_localctx = new FieldContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(220); match(ID);
				}
				break;
			case INT:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(221); match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FloatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(222); match(FLOAT);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(223); match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7: return condition_sempred((ConditionContext)_localctx, predIndex);

		case 11: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return 6 >= _localctx._p;

		case 3: return 5 >= _localctx._p;
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 3 >= _localctx._p;

		case 1: return 2 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3(\u00e5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\5\2%\n"+
		"\2\3\2\3\2\5\2)\n\2\3\2\3\2\5\2-\n\2\3\3\7\3\60\n\3\f\3\16\3\63\13\3\3"+
		"\4\7\4\66\n\4\f\4\16\49\13\4\3\5\7\5<\n\5\f\5\16\5?\13\5\3\6\7\6B\n\6"+
		"\f\6\16\6E\13\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\tU\n\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t]\n\t\f\t\16\t`\13\t\3\n\3\n\3"+
		"\n\3\n\3\n\5\ng\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nq\n\n\3\n\3\n\5"+
		"\nu\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0081\n"+
		"\13\f\13\16\13\u0084\13\13\3\13\3\13\5\13\u0088\n\13\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\6\r\u009a\n\r\r\r\16\r"+
		"\u009b\3\r\3\r\5\r\u00a0\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\6\r\u00aa"+
		"\n\r\r\r\16\r\u00ab\3\r\3\r\5\r\u00b0\n\r\3\r\3\r\3\r\3\r\5\r\u00b6\n"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00be\n\r\f\r\16\r\u00c1\13\r\3\16\3\16"+
		"\3\16\3\16\5\16\u00c7\n\16\3\16\7\16\u00ca\n\16\f\16\16\16\u00cd\13\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00d8\n\16\3\16\3\16"+
		"\5\16\u00dc\n\16\3\17\3\17\3\17\3\17\3\17\5\17\u00e3\n\17\3\17\6\61\67"+
		"=C\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\5\3\2\22\27\3\2\3\4\3\2\5"+
		"\6\u00fc\2\36\3\2\2\2\4\61\3\2\2\2\6\67\3\2\2\2\b=\3\2\2\2\nC\3\2\2\2"+
		"\fF\3\2\2\2\16I\3\2\2\2\20T\3\2\2\2\22t\3\2\2\2\24\u0087\3\2\2\2\26\u0089"+
		"\3\2\2\2\30\u00b5\3\2\2\2\32\u00db\3\2\2\2\34\u00e2\3\2\2\2\36\37\7\30"+
		"\2\2\37 \5\4\3\2 !\7\31\2\2!$\5\6\4\2\"#\7\33\2\2#%\5\f\7\2$\"\3\2\2\2"+
		"$%\3\2\2\2%(\3\2\2\2&\'\7\35\2\2\')\5\b\5\2(&\3\2\2\2()\3\2\2\2),\3\2"+
		"\2\2*+\7\34\2\2+-\5\n\6\2,*\3\2\2\2,-\3\2\2\2-\3\3\2\2\2.\60\13\2\2\2"+
		"/.\3\2\2\2\60\63\3\2\2\2\61\62\3\2\2\2\61/\3\2\2\2\62\5\3\2\2\2\63\61"+
		"\3\2\2\2\64\66\13\2\2\2\65\64\3\2\2\2\669\3\2\2\2\678\3\2\2\2\67\65\3"+
		"\2\2\28\7\3\2\2\29\67\3\2\2\2:<\13\2\2\2;:\3\2\2\2<?\3\2\2\2=>\3\2\2\2"+
		"=;\3\2\2\2>\t\3\2\2\2?=\3\2\2\2@B\13\2\2\2A@\3\2\2\2BE\3\2\2\2CD\3\2\2"+
		"\2CA\3\2\2\2D\13\3\2\2\2EC\3\2\2\2FG\7\33\2\2GH\5\20\t\2H\r\3\2\2\2IJ"+
		"\5\20\t\2JK\7\2\2\3K\17\3\2\2\2LM\b\t\1\2MN\7\13\2\2NU\5\20\t\2OP\7\17"+
		"\2\2PQ\5\20\t\2QR\7\20\2\2RU\3\2\2\2SU\5\22\n\2TL\3\2\2\2TO\3\2\2\2TS"+
		"\3\2\2\2U^\3\2\2\2VW\6\t\2\3WX\7\7\2\2X]\5\20\t\2YZ\6\t\3\3Z[\7\b\2\2"+
		"[]\5\20\t\2\\V\3\2\2\2\\Y\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\21\3"+
		"\2\2\2`^\3\2\2\2au\7#\2\2bu\5\30\r\2cd\5\30\r\2df\7\16\2\2eg\7\13\2\2"+
		"fe\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\7\f\2\2iu\3\2\2\2jk\5\30\r\2kl\t\2\2"+
		"\2lm\5\30\r\2mu\3\2\2\2np\5\30\r\2oq\7\13\2\2po\3\2\2\2pq\3\2\2\2qr\3"+
		"\2\2\2rs\5\24\13\2su\3\2\2\2ta\3\2\2\2tb\3\2\2\2tc\3\2\2\2tj\3\2\2\2t"+
		"n\3\2\2\2u\23\3\2\2\2vw\7\n\2\2wx\5\30\r\2xy\7\7\2\2yz\5\30\r\2z\u0088"+
		"\3\2\2\2{|\7\r\2\2|}\7\17\2\2}\u0082\5\30\r\2~\177\7\21\2\2\177\u0081"+
		"\5\30\r\2\u0080~\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\20"+
		"\2\2\u0086\u0088\3\2\2\2\u0087v\3\2\2\2\u0087{\3\2\2\2\u0088\25\3\2\2"+
		"\2\u0089\u008a\t\2\2\2\u008a\27\3\2\2\2\u008b\u008c\b\r\1\2\u008c\u008d"+
		"\t\3\2\2\u008d\u00b6\5\30\r\2\u008e\u008f\7\17\2\2\u008f\u0090\5\30\r"+
		"\2\u0090\u0091\7\20\2\2\u0091\u00b6\3\2\2\2\u0092\u0093\7\36\2\2\u0093"+
		"\u0099\5\30\r\2\u0094\u0095\7\37\2\2\u0095\u0096\5\30\r\2\u0096\u0097"+
		"\7 \2\2\u0097\u0098\5\30\r\2\u0098\u009a\3\2\2\2\u0099\u0094\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f\3\2"+
		"\2\2\u009d\u009e\7!\2\2\u009e\u00a0\5\30\r\2\u009f\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7\"\2\2\u00a2\u00b6\3\2"+
		"\2\2\u00a3\u00a9\7\36\2\2\u00a4\u00a5\7\37\2\2\u00a5\u00a6\5\20\t\2\u00a6"+
		"\u00a7\7 \2\2\u00a7\u00a8\5\30\r\2\u00a8\u00aa\3\2\2\2\u00a9\u00a4\3\2"+
		"\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00af\3\2\2\2\u00ad\u00ae\7!\2\2\u00ae\u00b0\5\30\r\2\u00af\u00ad\3\2"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\7\"\2\2\u00b2"+
		"\u00b6\3\2\2\2\u00b3\u00b6\5\32\16\2\u00b4\u00b6\5\34\17\2\u00b5\u008b"+
		"\3\2\2\2\u00b5\u008e\3\2\2\2\u00b5\u0092\3\2\2\2\u00b5\u00a3\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00bf\3\2\2\2\u00b7\u00b8\6\r"+
		"\4\3\u00b8\u00b9\t\4\2\2\u00b9\u00be\5\30\r\2\u00ba\u00bb\6\r\5\3\u00bb"+
		"\u00bc\t\3\2\2\u00bc\u00be\5\30\r\2\u00bd\u00b7\3\2\2\2\u00bd\u00ba\3"+
		"\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\31\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7$\2\2\u00c3\u00c4\7\17\2"+
		"\2\u00c4\u00cb\5\30\r\2\u00c5\u00c7\7\21\2\2\u00c6\u00c5\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\5\30\r\2\u00c9\u00c6\3"+
		"\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf\7\20\2\2\u00cf\u00dc\3"+
		"\2\2\2\u00d0\u00d1\7$\2\2\u00d1\u00d2\7\17\2\2\u00d2\u00d3\5\30\r\2\u00d3"+
		"\u00d4\7\r\2\2\u00d4\u00d7\5\30\r\2\u00d5\u00d6\7\31\2\2\u00d6\u00d8\5"+
		"\30\r\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00da\7\20\2\2\u00da\u00dc\3\2\2\2\u00db\u00c2\3\2\2\2\u00db\u00d0\3"+
		"\2\2\2\u00dc\33\3\2\2\2\u00dd\u00e3\7\f\2\2\u00de\u00e3\7$\2\2\u00df\u00e3"+
		"\7%\2\2\u00e0\u00e3\7&\2\2\u00e1\u00e3\7\'\2\2\u00e2\u00dd\3\2\2\2\u00e2"+
		"\u00de\3\2\2\2\u00e2\u00df\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e1\3\2"+
		"\2\2\u00e3\35\3\2\2\2\35$(,\61\67=CT\\^fpt\u0082\u0087\u009b\u009f\u00ab"+
		"\u00af\u00b5\u00bd\u00bf\u00c6\u00cb\u00d7\u00db\u00e2";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}