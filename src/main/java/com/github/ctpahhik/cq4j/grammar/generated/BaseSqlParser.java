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
		PLUS=1, MINUS=2, STAR=3, DIV=4, MOD=5, AND=6, OR=7, AS=8, BETWEEN=9, NOT=10, 
		NULL=11, IN=12, IS=13, L_PAREN=14, R_PAREN=15, COMA=16, DOT=17, LT_EQ=18, 
		LT=19, GT_EQ=20, GT=21, EQ=22, NOT_EQ=23, SELECT=24, FROM=25, JOIN=26, 
		WHERE=27, ORDER=28, GROUP=29, BY=30, ASC=31, DESC=32, CASE=33, WHEN=34, 
		THEN=35, ELSE=36, END=37, INNER=38, OUTER=39, CROSS=40, LEFT=41, RIGHT=42, 
		FULL=43, ON=44, BOOLEAN=45, ID=46, INT=47, FLOAT=48, STRING=49, WS=50;
	public static final String[] tokenNames = {
		"<INVALID>", "'+'", "'-'", "'*'", "'/'", "'%'", "'and'", "'or'", "'as'", 
		"'between'", "'not'", "'null'", "'in'", "'is'", "'('", "')'", "','", "'.'", 
		"LT_EQ", "'<'", "GT_EQ", "'>'", "'='", "NOT_EQ", "'select'", "'from'", 
		"'join'", "'where'", "'order'", "'group'", "'by'", "'asc'", "'desc'", 
		"'case'", "'when'", "'then'", "'else'", "'end'", "'inner'", "'outer'", 
		"'cross'", "'left'", "'right'", "'full'", "'on'", "BOOLEAN", "ID", "INT", 
		"FLOAT", "STRING", "WS"
	};
	public static final int
		RULE_query = 0, RULE_selectExpression = 1, RULE_selectElement = 2, RULE_tableName = 3, 
		RULE_fromExpression = 4, RULE_fromElement = 5, RULE_groupByClause = 6, 
		RULE_orderByClause = 7, RULE_orderByElement = 8, RULE_whereClause = 9, 
		RULE_simpleCondition = 10, RULE_condition = 11, RULE_predicate = 12, RULE_subPredicate = 13, 
		RULE_comparison = 14, RULE_expression = 15, RULE_function = 16, RULE_primitive = 17;
	public static final String[] ruleNames = {
		"query", "selectExpression", "selectElement", "tableName", "fromExpression", 
		"fromElement", "groupByClause", "orderByClause", "orderByElement", "whereClause", 
		"simpleCondition", "condition", "predicate", "subPredicate", "comparison", 
		"expression", "function", "primitive"
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
		public TerminalNode BY(int i) {
			return getToken(BaseSqlParser.BY, i);
		}
		public FromExpressionContext fromExpression() {
			return getRuleContext(FromExpressionContext.class,0);
		}
		public TerminalNode ORDER() { return getToken(BaseSqlParser.ORDER, 0); }
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public GroupByClauseContext groupByClause() {
			return getRuleContext(GroupByClauseContext.class,0);
		}
		public List<TerminalNode> BY() { return getTokens(BaseSqlParser.BY); }
		public SelectExpressionContext selectExpression() {
			return getRuleContext(SelectExpressionContext.class,0);
		}
		public TerminalNode SELECT() { return getToken(BaseSqlParser.SELECT, 0); }
		public TerminalNode FROM() { return getToken(BaseSqlParser.FROM, 0); }
		public TerminalNode GROUP() { return getToken(BaseSqlParser.GROUP, 0); }
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
			setState(38);
			_la = _input.LA(1);
			if (_la==SELECT) {
				{
				setState(36); match(SELECT);
				setState(37); selectExpression();
				}
			}

			setState(42);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(40); match(FROM);
				setState(41); fromExpression();
				}
			}

			setState(46);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(44); match(WHERE);
				setState(45); whereClause();
				}
			}

			setState(51);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(48); match(GROUP);
				setState(49); match(BY);
				setState(50); groupByClause();
				}
			}

			setState(56);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(53); match(ORDER);
				setState(54); match(BY);
				setState(55); orderByClause();
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
		public List<TerminalNode> COMA() { return getTokens(BaseSqlParser.COMA); }
		public List<SelectElementContext> selectElement() {
			return getRuleContexts(SelectElementContext.class);
		}
		public SelectElementContext selectElement(int i) {
			return getRuleContext(SelectElementContext.class,i);
		}
		public TerminalNode COMA(int i) {
			return getToken(BaseSqlParser.COMA, i);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); selectElement();
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(59); match(COMA);
				setState(60); selectElement();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class SelectElementContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(BaseSqlParser.AS, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode ID() { return getToken(BaseSqlParser.ID, 0); }
		public TerminalNode STAR() { return getToken(BaseSqlParser.STAR, 0); }
		public SelectElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterSelectElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitSelectElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitSelectElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectElementContext selectElement() throws RecognitionException {
		SelectElementContext _localctx = new SelectElementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_selectElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			switch (_input.LA(1)) {
			case STAR:
				{
				setState(66); match(STAR);
				}
				break;
			case PLUS:
			case MINUS:
			case NOT:
			case NULL:
			case L_PAREN:
			case CASE:
			case BOOLEAN:
			case ID:
			case INT:
			case FLOAT:
			case STRING:
				{
				setState(67); condition(0);
				setState(70);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(68); match(AS);
					setState(69); match(ID);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(BaseSqlParser.AS, 0); }
		public List<TerminalNode> ID() { return getTokens(BaseSqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(BaseSqlParser.ID, i);
		}
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); match(ID);
			setState(77);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(75); match(AS);
				setState(76); match(ID);
				}
				break;
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
		public List<FromElementContext> fromElement() {
			return getRuleContexts(FromElementContext.class);
		}
		public List<TerminalNode> COMA() { return getTokens(BaseSqlParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(BaseSqlParser.COMA, i);
		}
		public FromElementContext fromElement(int i) {
			return getRuleContext(FromElementContext.class,i);
		}
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
		enterRule(_localctx, 8, RULE_fromExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79); fromElement(0);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(80); match(COMA);
				setState(81); fromElement(0);
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FromElementContext extends ParserRuleContext {
		public int _p;
		public TerminalNode JOIN() { return getToken(BaseSqlParser.JOIN, 0); }
		public TerminalNode OUTER() { return getToken(BaseSqlParser.OUTER, 0); }
		public TerminalNode FULL() { return getToken(BaseSqlParser.FULL, 0); }
		public TerminalNode R_PAREN() { return getToken(BaseSqlParser.R_PAREN, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode L_PAREN() { return getToken(BaseSqlParser.L_PAREN, 0); }
		public TerminalNode LEFT() { return getToken(BaseSqlParser.LEFT, 0); }
		public TerminalNode ON() { return getToken(BaseSqlParser.ON, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<FromElementContext> fromElement() {
			return getRuleContexts(FromElementContext.class);
		}
		public TerminalNode CROSS() { return getToken(BaseSqlParser.CROSS, 0); }
		public TerminalNode INNER() { return getToken(BaseSqlParser.INNER, 0); }
		public TerminalNode RIGHT() { return getToken(BaseSqlParser.RIGHT, 0); }
		public FromElementContext fromElement(int i) {
			return getRuleContext(FromElementContext.class,i);
		}
		public FromElementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FromElementContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_fromElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterFromElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitFromElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitFromElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromElementContext fromElement(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FromElementContext _localctx = new FromElementContext(_ctx, _parentState, _p);
		FromElementContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, RULE_fromElement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(88); tableName();
				}
				break;
			case L_PAREN:
				{
				setState(89); match(L_PAREN);
				setState(90); fromElement(0);
				setState(91); match(R_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FromElementContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_fromElement);
					setState(95);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(105);
					switch (_input.LA(1)) {
					case INNER:
						{
						setState(96); match(INNER);
						}
						break;
					case OUTER:
					case LEFT:
					case RIGHT:
					case FULL:
						{
						setState(102);
						switch (_input.LA(1)) {
						case LEFT:
						case RIGHT:
						case FULL:
							{
							setState(97);
							_la = _input.LA(1);
							if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT) | (1L << RIGHT) | (1L << FULL))) != 0)) ) {
							_errHandler.recoverInline(this);
							}
							consume();
							setState(99);
							_la = _input.LA(1);
							if (_la==OUTER) {
								{
								setState(98); match(OUTER);
								}
							}

							}
							break;
						case OUTER:
							{
							setState(101); match(OUTER);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case CROSS:
						{
						setState(104); match(CROSS);
						}
						break;
					case JOIN:
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(107); match(JOIN);
					setState(108); fromElement(0);
					setState(109); match(ON);
					setState(110); condition(0);
					}
					} 
				}
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class GroupByClauseContext extends ParserRuleContext {
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(BaseSqlParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(BaseSqlParser.COMA, i);
		}
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
		enterRule(_localctx, 12, RULE_groupByClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); condition(0);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(118); match(COMA);
				setState(119); condition(0);
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		public List<OrderByElementContext> orderByElement() {
			return getRuleContexts(OrderByElementContext.class);
		}
		public List<TerminalNode> COMA() { return getTokens(BaseSqlParser.COMA); }
		public OrderByElementContext orderByElement(int i) {
			return getRuleContext(OrderByElementContext.class,i);
		}
		public TerminalNode COMA(int i) {
			return getToken(BaseSqlParser.COMA, i);
		}
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
		enterRule(_localctx, 14, RULE_orderByClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125); orderByElement();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(126); match(COMA);
				setState(127); orderByElement();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class OrderByElementContext extends ParserRuleContext {
		public Token direction;
		public TerminalNode DESC() { return getToken(BaseSqlParser.DESC, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode ASC() { return getToken(BaseSqlParser.ASC, 0); }
		public OrderByElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderByElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterOrderByElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitOrderByElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitOrderByElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderByElementContext orderByElement() throws RecognitionException {
		OrderByElementContext _localctx = new OrderByElementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_orderByElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); condition(0);
			setState(135);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(134);
				((OrderByElementContext)_localctx).direction = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
					((OrderByElementContext)_localctx).direction = (Token)_errHandler.recoverInline(this);
				}
				consume();
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

	public static class WhereClauseContext extends ParserRuleContext {
		public ConditionContext value;
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
		enterRule(_localctx, 18, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); ((WhereClauseContext)_localctx).value = condition(0);
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
		enterRule(_localctx, 20, RULE_simpleCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); ((SimpleConditionContext)_localctx).value = condition(0);
			setState(140); match(EOF);
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
		int _startState = 22;
		enterRecursionRule(_localctx, RULE_condition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new NotConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(143); match(NOT);
				setState(144); ((NotConditionContext)_localctx).value = condition(5);
				}
				break;

			case 2:
				{
				_localctx = new SkipConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145); match(L_PAREN);
				setState(146); condition(0);
				setState(147); match(R_PAREN);
				}
				break;

			case 3:
				{
				_localctx = new SkipConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149); predicate();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(158);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new AndOperatorContext(new ConditionContext(_parentctx, _parentState, _p));
						((AndOperatorContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(152);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(153); match(AND);
						setState(154); ((AndOperatorContext)_localctx).right = condition(4);
						}
						break;

					case 2:
						{
						_localctx = new OrOperatorContext(new ConditionContext(_parentctx, _parentState, _p));
						((OrOperatorContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(155);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(156); match(OR);
						setState(157); ((OrOperatorContext)_localctx).right = condition(3);
						}
						break;
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_predicate);
		int _la;
		try {
			setState(181);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new SkipPredicateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(163); ((SkipPredicateContext)_localctx).value = expression(0);
				}
				break;

			case 2:
				_localctx = new IsNullPredicateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164); ((IsNullPredicateContext)_localctx).value = expression(0);
				setState(165); match(IS);
				setState(167);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(166); match(NOT);
					}
				}

				setState(169); match(NULL);
				}
				break;

			case 3:
				_localctx = new ComparePredicateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(171); ((ComparePredicateContext)_localctx).left = expression(0);
				setState(172);
				((ComparePredicateContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT_EQ) | (1L << LT) | (1L << GT_EQ) | (1L << GT) | (1L << EQ) | (1L << NOT_EQ))) != 0)) ) {
					((ComparePredicateContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(173); ((ComparePredicateContext)_localctx).right = expression(0);
				}
				break;

			case 4:
				_localctx = new NegatablePredicateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(175); ((NegatablePredicateContext)_localctx).value = expression(0);
				setState(177);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(176); match(NOT);
					}
				}

				setState(179); ((NegatablePredicateContext)_localctx).detailedPredicate = subPredicate();
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
		public ConditionContext condition;
		public List<ConditionContext> el = new ArrayList<ConditionContext>();
		public TerminalNode IN() { return getToken(BaseSqlParser.IN, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public TerminalNode R_PAREN() { return getToken(BaseSqlParser.R_PAREN, 0); }
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode L_PAREN() { return getToken(BaseSqlParser.L_PAREN, 0); }
		public List<TerminalNode> COMA() { return getTokens(BaseSqlParser.COMA); }
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
		enterRule(_localctx, 26, RULE_subPredicate);
		int _la;
		try {
			setState(200);
			switch (_input.LA(1)) {
			case BETWEEN:
				_localctx = new BetweenPredicateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(183); match(BETWEEN);
				setState(184); ((BetweenPredicateContext)_localctx).lower = expression(0);
				setState(185); match(AND);
				setState(186); ((BetweenPredicateContext)_localctx).upper = expression(0);
				}
				break;
			case IN:
				_localctx = new InPredicateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(188); match(IN);
				setState(189); match(L_PAREN);
				setState(190); ((InPredicateContext)_localctx).condition = condition(0);
				((InPredicateContext)_localctx).el.add(((InPredicateContext)_localctx).condition);
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(191); match(COMA);
					setState(192); ((InPredicateContext)_localctx).condition = condition(0);
					((InPredicateContext)_localctx).el.add(((InPredicateContext)_localctx).condition);
					}
					}
					setState(197);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(198); match(R_PAREN);
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
		enterRule(_localctx, 28, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
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
		public ConditionContext valueExpr;
		public ConditionContext condition;
		public List<ConditionContext> whenExpr = new ArrayList<ConditionContext>();
		public List<ConditionContext> thenExpr = new ArrayList<ConditionContext>();
		public ConditionContext elseExpr;
		public List<TerminalNode> THEN() { return getTokens(BaseSqlParser.THEN); }
		public TerminalNode WHEN(int i) {
			return getToken(BaseSqlParser.WHEN, i);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public TerminalNode THEN(int i) {
			return getToken(BaseSqlParser.THEN, i);
		}
		public TerminalNode ELSE() { return getToken(BaseSqlParser.ELSE, 0); }
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode CASE() { return getToken(BaseSqlParser.CASE, 0); }
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
		public List<ConditionContext> thenExpr = new ArrayList<ConditionContext>();
		public ConditionContext elseExpr;
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
	public static class UnaryOperatorContext extends ExpressionContext {
		public Token operator;
		public ConditionContext value;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(BaseSqlParser.MINUS, 0); }
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

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new SkipExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(205); match(L_PAREN);
				setState(206); condition(0);
				setState(207); match(R_PAREN);
				}
				break;

			case 2:
				{
				_localctx = new UnaryOperatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				((UnaryOperatorContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((UnaryOperatorContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(210); ((UnaryOperatorContext)_localctx).value = condition(0);
				}
				break;

			case 3:
				{
				_localctx = new CaseOperatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211); match(CASE);
				setState(212); ((CaseOperatorContext)_localctx).valueExpr = condition(0);
				setState(218); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(213); match(WHEN);
					setState(214); ((CaseOperatorContext)_localctx).condition = condition(0);
					((CaseOperatorContext)_localctx).whenExpr.add(((CaseOperatorContext)_localctx).condition);
					setState(215); match(THEN);
					setState(216); ((CaseOperatorContext)_localctx).condition = condition(0);
					((CaseOperatorContext)_localctx).thenExpr.add(((CaseOperatorContext)_localctx).condition);
					}
					}
					setState(220); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(224);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(222); match(ELSE);
					setState(223); ((CaseOperatorContext)_localctx).elseExpr = condition(0);
					}
				}

				setState(226); match(END);
				}
				break;

			case 4:
				{
				_localctx = new SearchedCaseOperatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228); match(CASE);
				setState(234); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(229); match(WHEN);
					setState(230); ((SearchedCaseOperatorContext)_localctx).condition = condition(0);
					((SearchedCaseOperatorContext)_localctx).whenExpr.add(((SearchedCaseOperatorContext)_localctx).condition);
					setState(231); match(THEN);
					setState(232); ((SearchedCaseOperatorContext)_localctx).condition = condition(0);
					((SearchedCaseOperatorContext)_localctx).thenExpr.add(((SearchedCaseOperatorContext)_localctx).condition);
					}
					}
					setState(236); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(240);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(238); match(ELSE);
					setState(239); ((SearchedCaseOperatorContext)_localctx).elseExpr = condition(0);
					}
				}

				setState(242); match(END);
				}
				break;

			case 5:
				{
				_localctx = new SkipExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244); function();
				}
				break;

			case 6:
				{
				_localctx = new SkipExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(245); primitive();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(254);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticOperatorContext(new ExpressionContext(_parentctx, _parentState, _p));
						((ArithmeticOperatorContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(248);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(249);
						((ArithmeticOperatorContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((ArithmeticOperatorContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(250); ((ArithmeticOperatorContext)_localctx).right = expression(7);
						}
						break;

					case 2:
						{
						_localctx = new ArithmeticOperatorContext(new ExpressionContext(_parentctx, _parentState, _p));
						((ArithmeticOperatorContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(251);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(252);
						((ArithmeticOperatorContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ArithmeticOperatorContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(253); ((ArithmeticOperatorContext)_localctx).right = expression(6);
						}
						break;
					}
					} 
				}
				setState(258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
		public ConditionContext condition;
		public List<ConditionContext> el = new ArrayList<ConditionContext>();
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public TerminalNode R_PAREN() { return getToken(BaseSqlParser.R_PAREN, 0); }
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode L_PAREN() { return getToken(BaseSqlParser.L_PAREN, 0); }
		public TerminalNode ID() { return getToken(BaseSqlParser.ID, 0); }
		public List<TerminalNode> COMA() { return getTokens(BaseSqlParser.COMA); }
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
		public ConditionContext value;
		public ConditionContext inValue;
		public ConditionContext from;
		public TerminalNode IN() { return getToken(BaseSqlParser.IN, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public TerminalNode R_PAREN() { return getToken(BaseSqlParser.R_PAREN, 0); }
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode L_PAREN() { return getToken(BaseSqlParser.L_PAREN, 0); }
		public TerminalNode ID() { return getToken(BaseSqlParser.ID, 0); }
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
		enterRule(_localctx, 32, RULE_function);
		int _la;
		try {
			setState(284);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				_localctx = new SimpleFunctionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(259); match(ID);
				setState(260); match(L_PAREN);
				setState(261); ((SimpleFunctionContext)_localctx).condition = condition(0);
				((SimpleFunctionContext)_localctx).el.add(((SimpleFunctionContext)_localctx).condition);
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << NULL) | (1L << L_PAREN) | (1L << COMA) | (1L << CASE) | (1L << BOOLEAN) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << STRING))) != 0)) {
					{
					{
					setState(263);
					_la = _input.LA(1);
					if (_la==COMA) {
						{
						setState(262); match(COMA);
						}
					}

					setState(265); ((SimpleFunctionContext)_localctx).condition = condition(0);
					((SimpleFunctionContext)_localctx).el.add(((SimpleFunctionContext)_localctx).condition);
					}
					}
					setState(270);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(271); match(R_PAREN);
				}
				break;

			case 2:
				_localctx = new InFunctionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(273); match(ID);
				setState(274); match(L_PAREN);
				setState(275); ((InFunctionContext)_localctx).value = condition(0);
				setState(276); match(IN);
				setState(277); ((InFunctionContext)_localctx).inValue = condition(0);
				setState(280);
				_la = _input.LA(1);
				if (_la==FROM) {
					{
					setState(278); match(FROM);
					setState(279); ((InFunctionContext)_localctx).from = condition(0);
					}
				}

				setState(282); match(R_PAREN);
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
	public static class TableFieldContext extends PrimitiveContext {
		public TerminalNode DOT() { return getToken(BaseSqlParser.DOT, 0); }
		public List<TerminalNode> ID() { return getTokens(BaseSqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(BaseSqlParser.ID, i);
		}
		public TableFieldContext(PrimitiveContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).enterTableField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseSqlListener ) ((BaseSqlListener)listener).exitTableField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseSqlVisitor ) return ((BaseSqlVisitor<? extends T>)visitor).visitTableField(this);
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
	public static class BooleanContext extends PrimitiveContext {
		public TerminalNode BOOLEAN() { return getToken(BaseSqlParser.BOOLEAN, 0); }
		public BooleanContext(PrimitiveContext ctx) { copyFrom(ctx); }
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
		enterRule(_localctx, 34, RULE_primitive);
		try {
			setState(295);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(286); match(BOOLEAN);
				}
				break;

			case 2:
				_localctx = new NullContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(287); match(NULL);
				}
				break;

			case 3:
				_localctx = new FieldContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(288); match(ID);
				}
				break;

			case 4:
				_localctx = new TableFieldContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(289); match(ID);
				setState(290); match(DOT);
				setState(291); match(ID);
				}
				break;

			case 5:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(292); match(INT);
				}
				break;

			case 6:
				_localctx = new FloatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(293); match(FLOAT);
				}
				break;

			case 7:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(294); match(STRING);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5: return fromElement_sempred((FromElementContext)_localctx, predIndex);

		case 11: return condition_sempred((ConditionContext)_localctx, predIndex);

		case 15: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return 6 >= _localctx._p;

		case 4: return 5 >= _localctx._p;
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return 3 >= _localctx._p;

		case 2: return 2 >= _localctx._p;
		}
		return true;
	}
	private boolean fromElement_sempred(FromElementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 1 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\64\u012c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\5\2)\n\2\3\2\3\2\5\2-\n\2\3\2\3\2\5\2\61\n\2\3\2\3"+
		"\2\3\2\5\2\66\n\2\3\2\3\2\3\2\5\2;\n\2\3\3\3\3\3\3\7\3@\n\3\f\3\16\3C"+
		"\13\3\3\4\3\4\3\4\3\4\5\4I\n\4\5\4K\n\4\3\5\3\5\3\5\5\5P\n\5\3\6\3\6\3"+
		"\6\7\6U\n\6\f\6\16\6X\13\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7`\n\7\3\7\3\7\3"+
		"\7\3\7\5\7f\n\7\3\7\5\7i\n\7\3\7\5\7l\n\7\3\7\3\7\3\7\3\7\3\7\7\7s\n\7"+
		"\f\7\16\7v\13\7\3\b\3\b\3\b\7\b{\n\b\f\b\16\b~\13\b\3\t\3\t\3\t\7\t\u0083"+
		"\n\t\f\t\16\t\u0086\13\t\3\n\3\n\5\n\u008a\n\n\3\13\3\13\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0099\n\r\3\r\3\r\3\r\3\r\3\r\3\r\7"+
		"\r\u00a1\n\r\f\r\16\r\u00a4\13\r\3\16\3\16\3\16\3\16\5\16\u00aa\n\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00b4\n\16\3\16\3\16\5\16"+
		"\u00b8\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00c4"+
		"\n\17\f\17\16\17\u00c7\13\17\3\17\3\17\5\17\u00cb\n\17\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\6\21"+
		"\u00dd\n\21\r\21\16\21\u00de\3\21\3\21\5\21\u00e3\n\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\6\21\u00ed\n\21\r\21\16\21\u00ee\3\21\3\21\5"+
		"\21\u00f3\n\21\3\21\3\21\3\21\3\21\5\21\u00f9\n\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\7\21\u0101\n\21\f\21\16\21\u0104\13\21\3\22\3\22\3\22\3\22"+
		"\5\22\u010a\n\22\3\22\7\22\u010d\n\22\f\22\16\22\u0110\13\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u011b\n\22\3\22\3\22\5\22\u011f"+
		"\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u012a\n\23\3\23"+
		"\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\7\3\2+-\3\2!\"\3\2"+
		"\24\31\3\2\3\4\3\2\5\7\u014d\2(\3\2\2\2\4<\3\2\2\2\6J\3\2\2\2\bL\3\2\2"+
		"\2\nQ\3\2\2\2\f_\3\2\2\2\16w\3\2\2\2\20\177\3\2\2\2\22\u0087\3\2\2\2\24"+
		"\u008b\3\2\2\2\26\u008d\3\2\2\2\30\u0098\3\2\2\2\32\u00b7\3\2\2\2\34\u00ca"+
		"\3\2\2\2\36\u00cc\3\2\2\2 \u00f8\3\2\2\2\"\u011e\3\2\2\2$\u0129\3\2\2"+
		"\2&\'\7\32\2\2\')\5\4\3\2(&\3\2\2\2()\3\2\2\2),\3\2\2\2*+\7\33\2\2+-\5"+
		"\n\6\2,*\3\2\2\2,-\3\2\2\2-\60\3\2\2\2./\7\35\2\2/\61\5\24\13\2\60.\3"+
		"\2\2\2\60\61\3\2\2\2\61\65\3\2\2\2\62\63\7\37\2\2\63\64\7 \2\2\64\66\5"+
		"\16\b\2\65\62\3\2\2\2\65\66\3\2\2\2\66:\3\2\2\2\678\7\36\2\289\7 \2\2"+
		"9;\5\20\t\2:\67\3\2\2\2:;\3\2\2\2;\3\3\2\2\2<A\5\6\4\2=>\7\22\2\2>@\5"+
		"\6\4\2?=\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\5\3\2\2\2CA\3\2\2\2DK"+
		"\7\5\2\2EH\5\30\r\2FG\7\n\2\2GI\7\60\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2"+
		"JD\3\2\2\2JE\3\2\2\2K\7\3\2\2\2LO\7\60\2\2MN\7\n\2\2NP\7\60\2\2OM\3\2"+
		"\2\2OP\3\2\2\2P\t\3\2\2\2QV\5\f\7\2RS\7\22\2\2SU\5\f\7\2TR\3\2\2\2UX\3"+
		"\2\2\2VT\3\2\2\2VW\3\2\2\2W\13\3\2\2\2XV\3\2\2\2YZ\b\7\1\2Z`\5\b\5\2["+
		"\\\7\20\2\2\\]\5\f\7\2]^\7\21\2\2^`\3\2\2\2_Y\3\2\2\2_[\3\2\2\2`t\3\2"+
		"\2\2ak\6\7\2\3bl\7(\2\2ce\t\2\2\2df\7)\2\2ed\3\2\2\2ef\3\2\2\2fi\3\2\2"+
		"\2gi\7)\2\2hc\3\2\2\2hg\3\2\2\2il\3\2\2\2jl\7*\2\2kb\3\2\2\2kh\3\2\2\2"+
		"kj\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\7\34\2\2no\5\f\7\2op\7.\2\2pq\5\30\r"+
		"\2qs\3\2\2\2ra\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\r\3\2\2\2vt\3\2"+
		"\2\2w|\5\30\r\2xy\7\22\2\2y{\5\30\r\2zx\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}"+
		"\3\2\2\2}\17\3\2\2\2~|\3\2\2\2\177\u0084\5\22\n\2\u0080\u0081\7\22\2\2"+
		"\u0081\u0083\5\22\n\2\u0082\u0080\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\21\3\2\2\2\u0086\u0084\3\2\2\2\u0087"+
		"\u0089\5\30\r\2\u0088\u008a\t\3\2\2\u0089\u0088\3\2\2\2\u0089\u008a\3"+
		"\2\2\2\u008a\23\3\2\2\2\u008b\u008c\5\30\r\2\u008c\25\3\2\2\2\u008d\u008e"+
		"\5\30\r\2\u008e\u008f\7\2\2\3\u008f\27\3\2\2\2\u0090\u0091\b\r\1\2\u0091"+
		"\u0092\7\f\2\2\u0092\u0099\5\30\r\2\u0093\u0094\7\20\2\2\u0094\u0095\5"+
		"\30\r\2\u0095\u0096\7\21\2\2\u0096\u0099\3\2\2\2\u0097\u0099\5\32\16\2"+
		"\u0098\u0090\3\2\2\2\u0098\u0093\3\2\2\2\u0098\u0097\3\2\2\2\u0099\u00a2"+
		"\3\2\2\2\u009a\u009b\6\r\3\3\u009b\u009c\7\b\2\2\u009c\u00a1\5\30\r\2"+
		"\u009d\u009e\6\r\4\3\u009e\u009f\7\t\2\2\u009f\u00a1\5\30\r\2\u00a0\u009a"+
		"\3\2\2\2\u00a0\u009d\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\31\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00b8\5 \21"+
		"\2\u00a6\u00a7\5 \21\2\u00a7\u00a9\7\17\2\2\u00a8\u00aa\7\f\2\2\u00a9"+
		"\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\r"+
		"\2\2\u00ac\u00b8\3\2\2\2\u00ad\u00ae\5 \21\2\u00ae\u00af\t\4\2\2\u00af"+
		"\u00b0\5 \21\2\u00b0\u00b8\3\2\2\2\u00b1\u00b3\5 \21\2\u00b2\u00b4\7\f"+
		"\2\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b6\5\34\17\2\u00b6\u00b8\3\2\2\2\u00b7\u00a5\3\2\2\2\u00b7\u00a6\3"+
		"\2\2\2\u00b7\u00ad\3\2\2\2\u00b7\u00b1\3\2\2\2\u00b8\33\3\2\2\2\u00b9"+
		"\u00ba\7\13\2\2\u00ba\u00bb\5 \21\2\u00bb\u00bc\7\b\2\2\u00bc\u00bd\5"+
		" \21\2\u00bd\u00cb\3\2\2\2\u00be\u00bf\7\16\2\2\u00bf\u00c0\7\20\2\2\u00c0"+
		"\u00c5\5\30\r\2\u00c1\u00c2\7\22\2\2\u00c2\u00c4\5\30\r\2\u00c3\u00c1"+
		"\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c8\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00c9\7\21\2\2\u00c9\u00cb\3"+
		"\2\2\2\u00ca\u00b9\3\2\2\2\u00ca\u00be\3\2\2\2\u00cb\35\3\2\2\2\u00cc"+
		"\u00cd\t\4\2\2\u00cd\37\3\2\2\2\u00ce\u00cf\b\21\1\2\u00cf\u00d0\7\20"+
		"\2\2\u00d0\u00d1\5\30\r\2\u00d1\u00d2\7\21\2\2\u00d2\u00f9\3\2\2\2\u00d3"+
		"\u00d4\t\5\2\2\u00d4\u00f9\5\30\r\2\u00d5\u00d6\7#\2\2\u00d6\u00dc\5\30"+
		"\r\2\u00d7\u00d8\7$\2\2\u00d8\u00d9\5\30\r\2\u00d9\u00da\7%\2\2\u00da"+
		"\u00db\5\30\r\2\u00db\u00dd\3\2\2\2\u00dc\u00d7\3\2\2\2\u00dd\u00de\3"+
		"\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0"+
		"\u00e1\7&\2\2\u00e1\u00e3\5\30\r\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2"+
		"\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\7\'\2\2\u00e5\u00f9\3\2\2\2\u00e6"+
		"\u00ec\7#\2\2\u00e7\u00e8\7$\2\2\u00e8\u00e9\5\30\r\2\u00e9\u00ea\7%\2"+
		"\2\u00ea\u00eb\5\30\r\2\u00eb\u00ed\3\2\2\2\u00ec\u00e7\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f2\3\2"+
		"\2\2\u00f0\u00f1\7&\2\2\u00f1\u00f3\5\30\r\2\u00f2\u00f0\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\7\'\2\2\u00f5\u00f9\3\2"+
		"\2\2\u00f6\u00f9\5\"\22\2\u00f7\u00f9\5$\23\2\u00f8\u00ce\3\2\2\2\u00f8"+
		"\u00d3\3\2\2\2\u00f8\u00d5\3\2\2\2\u00f8\u00e6\3\2\2\2\u00f8\u00f6\3\2"+
		"\2\2\u00f8\u00f7\3\2\2\2\u00f9\u0102\3\2\2\2\u00fa\u00fb\6\21\5\3\u00fb"+
		"\u00fc\t\6\2\2\u00fc\u0101\5 \21\2\u00fd\u00fe\6\21\6\3\u00fe\u00ff\t"+
		"\5\2\2\u00ff\u0101\5 \21\2\u0100\u00fa\3\2\2\2\u0100\u00fd\3\2\2\2\u0101"+
		"\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103!\3\2\2\2"+
		"\u0104\u0102\3\2\2\2\u0105\u0106\7\60\2\2\u0106\u0107\7\20\2\2\u0107\u010e"+
		"\5\30\r\2\u0108\u010a\7\22\2\2\u0109\u0108\3\2\2\2\u0109\u010a\3\2\2\2"+
		"\u010a\u010b\3\2\2\2\u010b\u010d\5\30\r\2\u010c\u0109\3\2\2\2\u010d\u0110"+
		"\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\3\2\2\2\u0110"+
		"\u010e\3\2\2\2\u0111\u0112\7\21\2\2\u0112\u011f\3\2\2\2\u0113\u0114\7"+
		"\60\2\2\u0114\u0115\7\20\2\2\u0115\u0116\5\30\r\2\u0116\u0117\7\16\2\2"+
		"\u0117\u011a\5\30\r\2\u0118\u0119\7\33\2\2\u0119\u011b\5\30\r\2\u011a"+
		"\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\7\21"+
		"\2\2\u011d\u011f\3\2\2\2\u011e\u0105\3\2\2\2\u011e\u0113\3\2\2\2\u011f"+
		"#\3\2\2\2\u0120\u012a\7/\2\2\u0121\u012a\7\r\2\2\u0122\u012a\7\60\2\2"+
		"\u0123\u0124\7\60\2\2\u0124\u0125\7\23\2\2\u0125\u012a\7\60\2\2\u0126"+
		"\u012a\7\61\2\2\u0127\u012a\7\62\2\2\u0128\u012a\7\63\2\2\u0129\u0120"+
		"\3\2\2\2\u0129\u0121\3\2\2\2\u0129\u0122\3\2\2\2\u0129\u0123\3\2\2\2\u0129"+
		"\u0126\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u0128\3\2\2\2\u012a%\3\2\2\2"+
		"((,\60\65:AHJOV_ehkt|\u0084\u0089\u0098\u00a0\u00a2\u00a9\u00b3\u00b7"+
		"\u00c5\u00ca\u00de\u00e2\u00ee\u00f2\u00f8\u0100\u0102\u0109\u010e\u011a"+
		"\u011e\u0129";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}