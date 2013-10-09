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
		NULL=11, IN=12, IS=13, L_PAREN=14, R_PAREN=15, COMA=16, LT_EQ=17, LT=18, 
		GT_EQ=19, GT=20, EQ=21, NOT_EQ=22, SELECT=23, FROM=24, JOIN=25, WHERE=26, 
		ORDER=27, GROUP=28, BY=29, CASE=30, WHEN=31, THEN=32, ELSE=33, END=34, 
		INNER=35, OUTER=36, CROSS=37, LEFT=38, RIGHT=39, FULL=40, ON=41, BOOLEAN=42, 
		ID=43, INT=44, FLOAT=45, STRING=46, WS=47;
	public static final String[] tokenNames = {
		"<INVALID>", "'+'", "'-'", "'*'", "'/'", "'%'", "'and'", "'or'", "'as'", 
		"'between'", "'not'", "'null'", "'in'", "'is'", "'('", "')'", "','", "LT_EQ", 
		"'<'", "GT_EQ", "'>'", "'='", "NOT_EQ", "'select'", "'from'", "'join'", 
		"'where'", "'order'", "'group'", "'by'", "'case'", "'when'", "'then'", 
		"'else'", "'end'", "'inner'", "'outer'", "'cross'", "'left'", "'right'", 
		"'full'", "'on'", "BOOLEAN", "ID", "INT", "FLOAT", "STRING", "WS"
	};
	public static final int
		RULE_query = 0, RULE_selectExpression = 1, RULE_selectElement = 2, RULE_tableName = 3, 
		RULE_fromExpression = 4, RULE_fromElement = 5, RULE_groupByClause = 6, 
		RULE_orderByClause = 7, RULE_whereClause = 8, RULE_simpleCondition = 9, 
		RULE_condition = 10, RULE_predicate = 11, RULE_subPredicate = 12, RULE_comparison = 13, 
		RULE_expression = 14, RULE_function = 15, RULE_primitive = 16;
	public static final String[] ruleNames = {
		"query", "selectExpression", "selectElement", "tableName", "fromExpression", 
		"fromElement", "groupByClause", "orderByClause", "whereClause", "simpleCondition", 
		"condition", "predicate", "subPredicate", "comparison", "expression", 
		"function", "primitive"
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
			setState(36);
			_la = _input.LA(1);
			if (_la==SELECT) {
				{
				setState(34); match(SELECT);
				setState(35); selectExpression();
				}
			}

			setState(40);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(38); match(FROM);
				setState(39); fromExpression();
				}
			}

			setState(44);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(42); match(WHERE);
				setState(43); whereClause();
				}
			}

			setState(49);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(46); match(GROUP);
				setState(47); match(BY);
				setState(48); groupByClause();
				}
			}

			setState(54);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(51); match(ORDER);
				setState(52); match(BY);
				setState(53); orderByClause();
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
			setState(56); selectElement();
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(57); match(COMA);
				setState(58); selectElement();
				}
				}
				setState(63);
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
			setState(70);
			switch (_input.LA(1)) {
			case STAR:
				{
				setState(64); match(STAR);
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
				setState(65); condition(0);
				setState(68);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(66); match(AS);
					setState(67); match(ID);
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
			setState(72); match(ID);
			setState(75);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(73); match(AS);
				setState(74); match(ID);
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
			setState(77); fromElement(0);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(78); match(COMA);
				setState(79); fromElement(0);
				}
				}
				setState(84);
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
			setState(91);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(86); tableName();
				}
				break;
			case L_PAREN:
				{
				setState(87); match(L_PAREN);
				setState(88); fromElement(0);
				setState(89); match(R_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(112);
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
					setState(93);
					if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
					setState(103);
					switch (_input.LA(1)) {
					case INNER:
						{
						setState(94); match(INNER);
						}
						break;
					case OUTER:
					case LEFT:
					case RIGHT:
					case FULL:
						{
						setState(100);
						switch (_input.LA(1)) {
						case LEFT:
						case RIGHT:
						case FULL:
							{
							setState(95);
							_la = _input.LA(1);
							if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT) | (1L << RIGHT) | (1L << FULL))) != 0)) ) {
							_errHandler.recoverInline(this);
							}
							consume();
							setState(97);
							_la = _input.LA(1);
							if (_la==OUTER) {
								{
								setState(96); match(OUTER);
								}
							}

							}
							break;
						case OUTER:
							{
							setState(99); match(OUTER);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case CROSS:
						{
						setState(102); match(CROSS);
						}
						break;
					case JOIN:
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(105); match(JOIN);
					setState(106); fromElement(0);
					setState(107); match(ON);
					setState(108); condition(0);
					}
					} 
				}
				setState(114);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=1 && _alt!=-1 ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(115);
					matchWildcard();
					}
					} 
				}
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		enterRule(_localctx, 14, RULE_orderByClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=1 && _alt!=-1 ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(121);
					matchWildcard();
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		enterRule(_localctx, 16, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); ((WhereClauseContext)_localctx).value = condition(0);
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
		enterRule(_localctx, 18, RULE_simpleCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); ((SimpleConditionContext)_localctx).value = condition(0);
			setState(130); match(EOF);
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
		int _startState = 20;
		enterRecursionRule(_localctx, RULE_condition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				_localctx = new NotConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(133); match(NOT);
				setState(134); ((NotConditionContext)_localctx).value = condition(5);
				}
				break;

			case 2:
				{
				_localctx = new SkipConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135); match(L_PAREN);
				setState(136); condition(0);
				setState(137); match(R_PAREN);
				}
				break;

			case 3:
				{
				_localctx = new SkipConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139); predicate();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(148);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new AndOperatorContext(new ConditionContext(_parentctx, _parentState, _p));
						((AndOperatorContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(142);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(143); match(AND);
						setState(144); ((AndOperatorContext)_localctx).right = condition(4);
						}
						break;

					case 2:
						{
						_localctx = new OrOperatorContext(new ConditionContext(_parentctx, _parentState, _p));
						((OrOperatorContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(145);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(146); match(OR);
						setState(147); ((OrOperatorContext)_localctx).right = condition(3);
						}
						break;
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		enterRule(_localctx, 22, RULE_predicate);
		int _la;
		try {
			setState(171);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new SkipPredicateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(153); ((SkipPredicateContext)_localctx).value = expression(0);
				}
				break;

			case 2:
				_localctx = new IsNullPredicateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(154); ((IsNullPredicateContext)_localctx).value = expression(0);
				setState(155); match(IS);
				setState(157);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(156); match(NOT);
					}
				}

				setState(159); match(NULL);
				}
				break;

			case 3:
				_localctx = new ComparePredicateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(161); ((ComparePredicateContext)_localctx).left = expression(0);
				setState(162);
				((ComparePredicateContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT_EQ) | (1L << LT) | (1L << GT_EQ) | (1L << GT) | (1L << EQ) | (1L << NOT_EQ))) != 0)) ) {
					((ComparePredicateContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(163); ((ComparePredicateContext)_localctx).right = expression(0);
				}
				break;

			case 4:
				_localctx = new NegatablePredicateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(165); ((NegatablePredicateContext)_localctx).value = expression(0);
				setState(167);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(166); match(NOT);
					}
				}

				setState(169); ((NegatablePredicateContext)_localctx).detailedPredicate = subPredicate();
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
		enterRule(_localctx, 24, RULE_subPredicate);
		int _la;
		try {
			setState(190);
			switch (_input.LA(1)) {
			case BETWEEN:
				_localctx = new BetweenPredicateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(173); match(BETWEEN);
				setState(174); ((BetweenPredicateContext)_localctx).lower = expression(0);
				setState(175); match(AND);
				setState(176); ((BetweenPredicateContext)_localctx).upper = expression(0);
				}
				break;
			case IN:
				_localctx = new InPredicateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(178); match(IN);
				setState(179); match(L_PAREN);
				setState(180); ((InPredicateContext)_localctx).condition = condition(0);
				((InPredicateContext)_localctx).el.add(((InPredicateContext)_localctx).condition);
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(181); match(COMA);
					setState(182); ((InPredicateContext)_localctx).condition = condition(0);
					((InPredicateContext)_localctx).el.add(((InPredicateContext)_localctx).condition);
					}
					}
					setState(187);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(188); match(R_PAREN);
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
		enterRule(_localctx, 26, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
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
		int _startState = 28;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				_localctx = new SkipExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(195); match(L_PAREN);
				setState(196); condition(0);
				setState(197); match(R_PAREN);
				}
				break;

			case 2:
				{
				_localctx = new UnaryOperatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				((UnaryOperatorContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((UnaryOperatorContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(200); ((UnaryOperatorContext)_localctx).value = condition(0);
				}
				break;

			case 3:
				{
				_localctx = new CaseOperatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201); match(CASE);
				setState(202); ((CaseOperatorContext)_localctx).valueExpr = condition(0);
				setState(208); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(203); match(WHEN);
					setState(204); ((CaseOperatorContext)_localctx).condition = condition(0);
					((CaseOperatorContext)_localctx).whenExpr.add(((CaseOperatorContext)_localctx).condition);
					setState(205); match(THEN);
					setState(206); ((CaseOperatorContext)_localctx).condition = condition(0);
					((CaseOperatorContext)_localctx).thenExpr.add(((CaseOperatorContext)_localctx).condition);
					}
					}
					setState(210); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(214);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(212); match(ELSE);
					setState(213); ((CaseOperatorContext)_localctx).elseExpr = condition(0);
					}
				}

				setState(216); match(END);
				}
				break;

			case 4:
				{
				_localctx = new SearchedCaseOperatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218); match(CASE);
				setState(224); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(219); match(WHEN);
					setState(220); ((SearchedCaseOperatorContext)_localctx).condition = condition(0);
					((SearchedCaseOperatorContext)_localctx).whenExpr.add(((SearchedCaseOperatorContext)_localctx).condition);
					setState(221); match(THEN);
					setState(222); ((SearchedCaseOperatorContext)_localctx).condition = condition(0);
					((SearchedCaseOperatorContext)_localctx).thenExpr.add(((SearchedCaseOperatorContext)_localctx).condition);
					}
					}
					setState(226); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(230);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(228); match(ELSE);
					setState(229); ((SearchedCaseOperatorContext)_localctx).elseExpr = condition(0);
					}
				}

				setState(232); match(END);
				}
				break;

			case 5:
				{
				_localctx = new SkipExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234); function();
				}
				break;

			case 6:
				{
				_localctx = new SkipExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(235); primitive();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(246);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(244);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticOperatorContext(new ExpressionContext(_parentctx, _parentState, _p));
						((ArithmeticOperatorContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(238);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(239);
						((ArithmeticOperatorContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((ArithmeticOperatorContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(240); ((ArithmeticOperatorContext)_localctx).right = expression(7);
						}
						break;

					case 2:
						{
						_localctx = new ArithmeticOperatorContext(new ExpressionContext(_parentctx, _parentState, _p));
						((ArithmeticOperatorContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(241);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(242);
						((ArithmeticOperatorContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ArithmeticOperatorContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(243); ((ArithmeticOperatorContext)_localctx).right = expression(6);
						}
						break;
					}
					} 
				}
				setState(248);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		enterRule(_localctx, 30, RULE_function);
		int _la;
		try {
			setState(274);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new SimpleFunctionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(249); match(ID);
				setState(250); match(L_PAREN);
				setState(251); ((SimpleFunctionContext)_localctx).condition = condition(0);
				((SimpleFunctionContext)_localctx).el.add(((SimpleFunctionContext)_localctx).condition);
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << NULL) | (1L << L_PAREN) | (1L << COMA) | (1L << CASE) | (1L << BOOLEAN) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << STRING))) != 0)) {
					{
					{
					setState(253);
					_la = _input.LA(1);
					if (_la==COMA) {
						{
						setState(252); match(COMA);
						}
					}

					setState(255); ((SimpleFunctionContext)_localctx).condition = condition(0);
					((SimpleFunctionContext)_localctx).el.add(((SimpleFunctionContext)_localctx).condition);
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(261); match(R_PAREN);
				}
				break;

			case 2:
				_localctx = new InFunctionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(263); match(ID);
				setState(264); match(L_PAREN);
				setState(265); ((InFunctionContext)_localctx).value = condition(0);
				setState(266); match(IN);
				setState(267); ((InFunctionContext)_localctx).inValue = condition(0);
				setState(270);
				_la = _input.LA(1);
				if (_la==FROM) {
					{
					setState(268); match(FROM);
					setState(269); ((InFunctionContext)_localctx).from = condition(0);
					}
				}

				setState(272); match(R_PAREN);
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
		enterRule(_localctx, 32, RULE_primitive);
		try {
			setState(282);
			switch (_input.LA(1)) {
			case BOOLEAN:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(276); match(BOOLEAN);
				}
				break;
			case NULL:
				_localctx = new NullContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(277); match(NULL);
				}
				break;
			case ID:
				_localctx = new FieldContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(278); match(ID);
				}
				break;
			case INT:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(279); match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FloatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(280); match(FLOAT);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(281); match(STRING);
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
		case 5: return fromElement_sempred((FromElementContext)_localctx, predIndex);

		case 10: return condition_sempred((ConditionContext)_localctx, predIndex);

		case 14: return expression_sempred((ExpressionContext)_localctx, predIndex);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\61\u011f\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\5\2\'\n\2\3\2\3\2\5\2+\n\2\3\2\3\2\5\2/\n\2\3\2\3\2\3\2\5\2\64"+
		"\n\2\3\2\3\2\3\2\5\29\n\2\3\3\3\3\3\3\7\3>\n\3\f\3\16\3A\13\3\3\4\3\4"+
		"\3\4\3\4\5\4G\n\4\5\4I\n\4\3\5\3\5\3\5\5\5N\n\5\3\6\3\6\3\6\7\6S\n\6\f"+
		"\6\16\6V\13\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7^\n\7\3\7\3\7\3\7\3\7\5\7d\n"+
		"\7\3\7\5\7g\n\7\3\7\5\7j\n\7\3\7\3\7\3\7\3\7\3\7\7\7q\n\7\f\7\16\7t\13"+
		"\7\3\b\7\bw\n\b\f\b\16\bz\13\b\3\t\7\t}\n\t\f\t\16\t\u0080\13\t\3\n\3"+
		"\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u008f\n\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\7\f\u0097\n\f\f\f\16\f\u009a\13\f\3\r\3\r\3\r\3\r\5"+
		"\r\u00a0\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00aa\n\r\3\r\3\r\5\r"+
		"\u00ae\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00ba"+
		"\n\16\f\16\16\16\u00bd\13\16\3\16\3\16\5\16\u00c1\n\16\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\6\20"+
		"\u00d3\n\20\r\20\16\20\u00d4\3\20\3\20\5\20\u00d9\n\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\6\20\u00e3\n\20\r\20\16\20\u00e4\3\20\3\20\5"+
		"\20\u00e9\n\20\3\20\3\20\3\20\3\20\5\20\u00ef\n\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\7\20\u00f7\n\20\f\20\16\20\u00fa\13\20\3\21\3\21\3\21\3\21"+
		"\5\21\u0100\n\21\3\21\7\21\u0103\n\21\f\21\16\21\u0106\13\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0111\n\21\3\21\3\21\5\21\u0115"+
		"\n\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u011d\n\22\3\22\4x~\23\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\6\3\2(*\3\2\23\30\3\2\3\4\3\2\5"+
		"\7\u013f\2&\3\2\2\2\4:\3\2\2\2\6H\3\2\2\2\bJ\3\2\2\2\nO\3\2\2\2\f]\3\2"+
		"\2\2\16x\3\2\2\2\20~\3\2\2\2\22\u0081\3\2\2\2\24\u0083\3\2\2\2\26\u008e"+
		"\3\2\2\2\30\u00ad\3\2\2\2\32\u00c0\3\2\2\2\34\u00c2\3\2\2\2\36\u00ee\3"+
		"\2\2\2 \u0114\3\2\2\2\"\u011c\3\2\2\2$%\7\31\2\2%\'\5\4\3\2&$\3\2\2\2"+
		"&\'\3\2\2\2\'*\3\2\2\2()\7\32\2\2)+\5\n\6\2*(\3\2\2\2*+\3\2\2\2+.\3\2"+
		"\2\2,-\7\34\2\2-/\5\22\n\2.,\3\2\2\2./\3\2\2\2/\63\3\2\2\2\60\61\7\36"+
		"\2\2\61\62\7\37\2\2\62\64\5\16\b\2\63\60\3\2\2\2\63\64\3\2\2\2\648\3\2"+
		"\2\2\65\66\7\35\2\2\66\67\7\37\2\2\679\5\20\t\28\65\3\2\2\289\3\2\2\2"+
		"9\3\3\2\2\2:?\5\6\4\2;<\7\22\2\2<>\5\6\4\2=;\3\2\2\2>A\3\2\2\2?=\3\2\2"+
		"\2?@\3\2\2\2@\5\3\2\2\2A?\3\2\2\2BI\7\5\2\2CF\5\26\f\2DE\7\n\2\2EG\7-"+
		"\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HB\3\2\2\2HC\3\2\2\2I\7\3\2\2\2JM\7"+
		"-\2\2KL\7\n\2\2LN\7-\2\2MK\3\2\2\2MN\3\2\2\2N\t\3\2\2\2OT\5\f\7\2PQ\7"+
		"\22\2\2QS\5\f\7\2RP\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\13\3\2\2\2"+
		"VT\3\2\2\2WX\b\7\1\2X^\5\b\5\2YZ\7\20\2\2Z[\5\f\7\2[\\\7\21\2\2\\^\3\2"+
		"\2\2]W\3\2\2\2]Y\3\2\2\2^r\3\2\2\2_i\6\7\2\3`j\7%\2\2ac\t\2\2\2bd\7&\2"+
		"\2cb\3\2\2\2cd\3\2\2\2dg\3\2\2\2eg\7&\2\2fa\3\2\2\2fe\3\2\2\2gj\3\2\2"+
		"\2hj\7\'\2\2i`\3\2\2\2if\3\2\2\2ih\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\7\33"+
		"\2\2lm\5\f\7\2mn\7+\2\2no\5\26\f\2oq\3\2\2\2p_\3\2\2\2qt\3\2\2\2rp\3\2"+
		"\2\2rs\3\2\2\2s\r\3\2\2\2tr\3\2\2\2uw\13\2\2\2vu\3\2\2\2wz\3\2\2\2xy\3"+
		"\2\2\2xv\3\2\2\2y\17\3\2\2\2zx\3\2\2\2{}\13\2\2\2|{\3\2\2\2}\u0080\3\2"+
		"\2\2~\177\3\2\2\2~|\3\2\2\2\177\21\3\2\2\2\u0080~\3\2\2\2\u0081\u0082"+
		"\5\26\f\2\u0082\23\3\2\2\2\u0083\u0084\5\26\f\2\u0084\u0085\7\2\2\3\u0085"+
		"\25\3\2\2\2\u0086\u0087\b\f\1\2\u0087\u0088\7\f\2\2\u0088\u008f\5\26\f"+
		"\2\u0089\u008a\7\20\2\2\u008a\u008b\5\26\f\2\u008b\u008c\7\21\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008f\5\30\r\2\u008e\u0086\3\2\2\2\u008e\u0089\3"+
		"\2\2\2\u008e\u008d\3\2\2\2\u008f\u0098\3\2\2\2\u0090\u0091\6\f\3\3\u0091"+
		"\u0092\7\b\2\2\u0092\u0097\5\26\f\2\u0093\u0094\6\f\4\3\u0094\u0095\7"+
		"\t\2\2\u0095\u0097\5\26\f\2\u0096\u0090\3\2\2\2\u0096\u0093\3\2\2\2\u0097"+
		"\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\27\3\2\2"+
		"\2\u009a\u0098\3\2\2\2\u009b\u00ae\5\36\20\2\u009c\u009d\5\36\20\2\u009d"+
		"\u009f\7\17\2\2\u009e\u00a0\7\f\2\2\u009f\u009e\3\2\2\2\u009f\u00a0\3"+
		"\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7\r\2\2\u00a2\u00ae\3\2\2\2\u00a3"+
		"\u00a4\5\36\20\2\u00a4\u00a5\t\3\2\2\u00a5\u00a6\5\36\20\2\u00a6\u00ae"+
		"\3\2\2\2\u00a7\u00a9\5\36\20\2\u00a8\u00aa\7\f\2\2\u00a9\u00a8\3\2\2\2"+
		"\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\5\32\16\2\u00ac\u00ae"+
		"\3\2\2\2\u00ad\u009b\3\2\2\2\u00ad\u009c\3\2\2\2\u00ad\u00a3\3\2\2\2\u00ad"+
		"\u00a7\3\2\2\2\u00ae\31\3\2\2\2\u00af\u00b0\7\13\2\2\u00b0\u00b1\5\36"+
		"\20\2\u00b1\u00b2\7\b\2\2\u00b2\u00b3\5\36\20\2\u00b3\u00c1\3\2\2\2\u00b4"+
		"\u00b5\7\16\2\2\u00b5\u00b6\7\20\2\2\u00b6\u00bb\5\26\f\2\u00b7\u00b8"+
		"\7\22\2\2\u00b8\u00ba\5\26\f\2\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2"+
		"\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb"+
		"\3\2\2\2\u00be\u00bf\7\21\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00af\3\2\2\2"+
		"\u00c0\u00b4\3\2\2\2\u00c1\33\3\2\2\2\u00c2\u00c3\t\3\2\2\u00c3\35\3\2"+
		"\2\2\u00c4\u00c5\b\20\1\2\u00c5\u00c6\7\20\2\2\u00c6\u00c7\5\26\f\2\u00c7"+
		"\u00c8\7\21\2\2\u00c8\u00ef\3\2\2\2\u00c9\u00ca\t\4\2\2\u00ca\u00ef\5"+
		"\26\f\2\u00cb\u00cc\7 \2\2\u00cc\u00d2\5\26\f\2\u00cd\u00ce\7!\2\2\u00ce"+
		"\u00cf\5\26\f\2\u00cf\u00d0\7\"\2\2\u00d0\u00d1\5\26\f\2\u00d1\u00d3\3"+
		"\2\2\2\u00d2\u00cd\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d7\7#\2\2\u00d7\u00d9\5\26"+
		"\f\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00db\7$\2\2\u00db\u00ef\3\2\2\2\u00dc\u00e2\7 \2\2\u00dd\u00de\7!\2"+
		"\2\u00de\u00df\5\26\f\2\u00df\u00e0\7\"\2\2\u00e0\u00e1\5\26\f\2\u00e1"+
		"\u00e3\3\2\2\2\u00e2\u00dd\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e2\3\2"+
		"\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e7\7#\2\2\u00e7"+
		"\u00e9\5\26\f\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3"+
		"\2\2\2\u00ea\u00eb\7$\2\2\u00eb\u00ef\3\2\2\2\u00ec\u00ef\5 \21\2\u00ed"+
		"\u00ef\5\"\22\2\u00ee\u00c4\3\2\2\2\u00ee\u00c9\3\2\2\2\u00ee\u00cb\3"+
		"\2\2\2\u00ee\u00dc\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef"+
		"\u00f8\3\2\2\2\u00f0\u00f1\6\20\5\3\u00f1\u00f2\t\5\2\2\u00f2\u00f7\5"+
		"\36\20\2\u00f3\u00f4\6\20\6\3\u00f4\u00f5\t\4\2\2\u00f5\u00f7\5\36\20"+
		"\2\u00f6\u00f0\3\2\2\2\u00f6\u00f3\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6"+
		"\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\37\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb"+
		"\u00fc\7-\2\2\u00fc\u00fd\7\20\2\2\u00fd\u0104\5\26\f\2\u00fe\u0100\7"+
		"\22\2\2\u00ff\u00fe\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\3\2\2\2\u0101"+
		"\u0103\5\26\f\2\u0102\u00ff\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3"+
		"\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107"+
		"\u0108\7\21\2\2\u0108\u0115\3\2\2\2\u0109\u010a\7-\2\2\u010a\u010b\7\20"+
		"\2\2\u010b\u010c\5\26\f\2\u010c\u010d\7\16\2\2\u010d\u0110\5\26\f\2\u010e"+
		"\u010f\7\32\2\2\u010f\u0111\5\26\f\2\u0110\u010e\3\2\2\2\u0110\u0111\3"+
		"\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\7\21\2\2\u0113\u0115\3\2\2\2\u0114"+
		"\u00fb\3\2\2\2\u0114\u0109\3\2\2\2\u0115!\3\2\2\2\u0116\u011d\7,\2\2\u0117"+
		"\u011d\7\r\2\2\u0118\u011d\7-\2\2\u0119\u011d\7.\2\2\u011a\u011d\7/\2"+
		"\2\u011b\u011d\7\60\2\2\u011c\u0116\3\2\2\2\u011c\u0117\3\2\2\2\u011c"+
		"\u0118\3\2\2\2\u011c\u0119\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011b\3\2"+
		"\2\2\u011d#\3\2\2\2\'&*.\638?FHMT]cfirx~\u008e\u0096\u0098\u009f\u00a9"+
		"\u00ad\u00bb\u00c0\u00d4\u00d8\u00e4\u00e8\u00ee\u00f6\u00f8\u00ff\u0104"+
		"\u0110\u0114\u011c";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}