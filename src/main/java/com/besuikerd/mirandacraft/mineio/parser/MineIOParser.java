// Generated from MineIO.g4 by ANTLR 4.5

package com.besuikerd.mirandacraft.mineio.parser;

import com.besuikerd.mirandacraft.mineio.namespace.NamespaceEntry;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MineIOParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TYPE_ITEM=1, TYPE_CONTAINER=2, TYPE_RECIPE=3, TYPE_INT=4, TYPE_STRING=5, 
		TYPE_BOOLEAN=6, TRUE=7, FALSE=8, IF=9, ELSE=10, LPAREN=11, RPAREN=12, 
		LBRACKET=13, RBRACKET=14, LCURLY=15, RCURLY=16, COLON=17, SEMICOLON=18, 
		COMMA=19, ADD=20, SUB=21, MUL=22, DIV=23, MOD=24, GT=25, GTEQ=26, LT=27, 
		LTEQ=28, EQUALS=29, NOTEQUALS=30, AND=31, OR=32, AT=33, NOT=34, TILDE=35, 
		QUOTE=36, BECOMES=37, BECOMESADD=38, BECOMESSUB=39, BECOMESDIV=40, BECOMESMUL=41, 
		FUNCTION=42, RETURN=43, DOT=44, WHILE=45, FOREACH=46, AS=47, ARROWRIGHT=48, 
		Comment=49, WhiteSpace=50, StringLiteral=51, Id=52, Int=53;
	public static final int
		RULE_program = 0, RULE_statementSemicolon = 1, RULE_statement = 2, RULE_formalParameter = 3, 
		RULE_functionBody = 4, RULE_assignmentType = 5, RULE_exp = 6, RULE_variable = 7, 
		RULE_itemDescriptor = 8, RULE_itemModName = 9, RULE_itemName = 10, RULE_typeRef = 11, 
		RULE_arrayRef = 12;
	public static final String[] ruleNames = {
		"program", "statementSemicolon", "statement", "formalParameter", "functionBody", 
		"assignmentType", "exp", "variable", "itemDescriptor", "itemModName", 
		"itemName", "typeRef", "arrayRef"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'item'", "'container'", "'recipe'", "'int'", null, "'boolean'", 
		"'true'", "'false'", "'if'", "'else'", "'('", "')'", "'['", "']'", "'{'", 
		"'}'", "':'", "';'", "','", "'+'", "'-'", "'*'", "'/'", "'%'", "'>'", 
		"'<='", "'<'", "'>='", "'=='", "'!='", "'&&'", "'||'", "'@'", "'!'", "'~'", 
		"'\"'", "'='", null, null, null, null, "'function'", "'return'", "'.'", 
		"'while'", "'foreach'", "'as'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TYPE_ITEM", "TYPE_CONTAINER", "TYPE_RECIPE", "TYPE_INT", "TYPE_STRING", 
		"TYPE_BOOLEAN", "TRUE", "FALSE", "IF", "ELSE", "LPAREN", "RPAREN", "LBRACKET", 
		"RBRACKET", "LCURLY", "RCURLY", "COLON", "SEMICOLON", "COMMA", "ADD", 
		"SUB", "MUL", "DIV", "MOD", "GT", "GTEQ", "LT", "LTEQ", "EQUALS", "NOTEQUALS", 
		"AND", "OR", "AT", "NOT", "TILDE", "QUOTE", "BECOMES", "BECOMESADD", "BECOMESSUB", 
		"BECOMESDIV", "BECOMESMUL", "FUNCTION", "RETURN", "DOT", "WHILE", "FOREACH", 
		"AS", "ARROWRIGHT", "Comment", "WhiteSpace", "StringLiteral", "Id", "Int"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MineIO.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MineIOParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementSemicolonContext> statementSemicolon() {
			return getRuleContexts(StatementSemicolonContext.class);
		}
		public StatementSemicolonContext statementSemicolon(int i) {
			return getRuleContext(StatementSemicolonContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_ITEM) | (1L << TYPE_CONTAINER) | (1L << TYPE_RECIPE) | (1L << TYPE_INT) | (1L << TYPE_STRING) | (1L << TYPE_BOOLEAN) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << LPAREN) | (1L << LBRACKET) | (1L << LCURLY) | (1L << LT) | (1L << NOT) | (1L << TILDE) | (1L << FUNCTION) | (1L << RETURN) | (1L << WHILE) | (1L << FOREACH) | (1L << StringLiteral) | (1L << Id) | (1L << Int))) != 0)) {
				{
				{
				setState(26);
				statementSemicolon();
				}
				}
				setState(31);
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

	public static class StatementSemicolonContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MineIOParser.SEMICOLON, 0); }
		public StatementSemicolonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementSemicolon; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitStatementSemicolon(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementSemicolonContext statementSemicolon() throws RecognitionException {
		StatementSemicolonContext _localctx = new StatementSemicolonContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statementSemicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			statement();
			setState(34);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(33);
				match(SEMICOLON);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatementAssignmentContext extends StatementContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public AssignmentTypeContext assignmentType() {
			return getRuleContext(AssignmentTypeContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatementAssignmentContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitStatementAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementForeachContext extends StatementContext {
		public TerminalNode FOREACH() { return getToken(MineIOParser.FOREACH, 0); }
		public TerminalNode LPAREN() { return getToken(MineIOParser.LPAREN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode AS() { return getToken(MineIOParser.AS, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MineIOParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementForeachContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitStatementForeach(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementReturnContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(MineIOParser.RETURN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatementReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitStatementReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementDeclarationContext extends StatementContext {
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode BECOMES() { return getToken(MineIOParser.BECOMES, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatementDeclarationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitStatementDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementConditionContext extends StatementContext {
		public TerminalNode IF() { return getToken(MineIOParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MineIOParser.LPAREN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MineIOParser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MineIOParser.ELSE, 0); }
		public StatementConditionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitStatementCondition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementBlockContext extends StatementContext {
		public TerminalNode LCURLY() { return getToken(MineIOParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(MineIOParser.RCURLY, 0); }
		public List<StatementSemicolonContext> statementSemicolon() {
			return getRuleContexts(StatementSemicolonContext.class);
		}
		public StatementSemicolonContext statementSemicolon(int i) {
			return getRuleContext(StatementSemicolonContext.class,i);
		}
		public StatementBlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitStatementBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementExpressionContext extends StatementContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatementExpressionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitStatementExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementWhileContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(MineIOParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(MineIOParser.LPAREN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MineIOParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitStatementWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementFunctionDeclarationContext extends StatementContext {
		public TerminalNode FUNCTION() { return getToken(MineIOParser.FUNCTION, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(MineIOParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MineIOParser.RPAREN, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public TerminalNode COLON() { return getToken(MineIOParser.COLON, 0); }
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(MineIOParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MineIOParser.COMMA, i);
		}
		public StatementFunctionDeclarationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitStatementFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			setState(100);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new StatementDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				typeRef();
				setState(37);
				variable();
				setState(40);
				_la = _input.LA(1);
				if (_la==BECOMES) {
					{
					setState(38);
					match(BECOMES);
					setState(39);
					exp(0);
					}
				}

				}
				break;
			case 2:
				_localctx = new StatementAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				variable();
				setState(43);
				assignmentType();
				setState(44);
				exp(0);
				}
				break;
			case 3:
				_localctx = new StatementBlockContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				match(LCURLY);
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_ITEM) | (1L << TYPE_CONTAINER) | (1L << TYPE_RECIPE) | (1L << TYPE_INT) | (1L << TYPE_STRING) | (1L << TYPE_BOOLEAN) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << LPAREN) | (1L << LBRACKET) | (1L << LCURLY) | (1L << LT) | (1L << NOT) | (1L << TILDE) | (1L << FUNCTION) | (1L << RETURN) | (1L << WHILE) | (1L << FOREACH) | (1L << StringLiteral) | (1L << Id) | (1L << Int))) != 0)) {
					{
					{
					setState(47);
					statementSemicolon();
					}
					}
					setState(52);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(53);
				match(RCURLY);
				}
				break;
			case 4:
				_localctx = new StatementConditionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(54);
				match(IF);
				setState(55);
				match(LPAREN);
				setState(56);
				exp(0);
				setState(57);
				match(RPAREN);
				setState(58);
				statement();
				setState(61);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(59);
					match(ELSE);
					setState(60);
					statement();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new StatementExpressionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(63);
				exp(0);
				}
				break;
			case 6:
				_localctx = new StatementFunctionDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(64);
				match(FUNCTION);
				setState(65);
				variable();
				setState(66);
				match(LPAREN);
				setState(75);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_ITEM) | (1L << TYPE_CONTAINER) | (1L << TYPE_RECIPE) | (1L << TYPE_INT) | (1L << TYPE_STRING) | (1L << TYPE_BOOLEAN) | (1L << LPAREN) | (1L << LBRACKET))) != 0)) {
					{
					setState(67);
					formalParameter();
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(68);
						match(COMMA);
						setState(69);
						formalParameter();
						}
						}
						setState(74);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(77);
				match(RPAREN);
				setState(80);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(78);
					match(COLON);
					setState(79);
					typeRef();
					}
				}

				setState(82);
				functionBody();
				}
				break;
			case 7:
				_localctx = new StatementWhileContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(84);
				match(WHILE);
				setState(85);
				match(LPAREN);
				setState(86);
				exp(0);
				setState(87);
				match(RPAREN);
				setState(88);
				statement();
				}
				break;
			case 8:
				_localctx = new StatementForeachContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(90);
				match(FOREACH);
				setState(91);
				match(LPAREN);
				setState(92);
				exp(0);
				setState(93);
				match(AS);
				setState(94);
				variable();
				setState(95);
				match(RPAREN);
				setState(96);
				statement();
				}
				break;
			case 9:
				_localctx = new StatementReturnContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(98);
				match(RETURN);
				setState(99);
				exp(0);
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

	public static class FormalParameterContext extends ParserRuleContext {
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			typeRef();
			setState(103);
			variable();
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

	public static class FunctionBodyContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitFunctionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			statement();
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

	public static class AssignmentTypeContext extends ParserRuleContext {
		public AssignmentTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentType; }
	 
		public AssignmentTypeContext() { }
		public void copyFrom(AssignmentTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignmentTypeBecomesSubContext extends AssignmentTypeContext {
		public TerminalNode BECOMESSUB() { return getToken(MineIOParser.BECOMESSUB, 0); }
		public AssignmentTypeBecomesSubContext(AssignmentTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitAssignmentTypeBecomesSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentTypeBecomesAddContext extends AssignmentTypeContext {
		public TerminalNode BECOMESADD() { return getToken(MineIOParser.BECOMESADD, 0); }
		public AssignmentTypeBecomesAddContext(AssignmentTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitAssignmentTypeBecomesAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentTypeBecomesDivContext extends AssignmentTypeContext {
		public TerminalNode BECOMESDIV() { return getToken(MineIOParser.BECOMESDIV, 0); }
		public AssignmentTypeBecomesDivContext(AssignmentTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitAssignmentTypeBecomesDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentTypeBecomesContext extends AssignmentTypeContext {
		public TerminalNode BECOMES() { return getToken(MineIOParser.BECOMES, 0); }
		public AssignmentTypeBecomesContext(AssignmentTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitAssignmentTypeBecomes(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentTypeBecomesMulContext extends AssignmentTypeContext {
		public TerminalNode BECOMESMUL() { return getToken(MineIOParser.BECOMESMUL, 0); }
		public AssignmentTypeBecomesMulContext(AssignmentTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitAssignmentTypeBecomesMul(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentTypeContext assignmentType() throws RecognitionException {
		AssignmentTypeContext _localctx = new AssignmentTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignmentType);
		try {
			setState(112);
			switch (_input.LA(1)) {
			case BECOMES:
				_localctx = new AssignmentTypeBecomesContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				match(BECOMES);
				}
				break;
			case BECOMESADD:
				_localctx = new AssignmentTypeBecomesAddContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(BECOMESADD);
				}
				break;
			case BECOMESSUB:
				_localctx = new AssignmentTypeBecomesSubContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				match(BECOMESSUB);
				}
				break;
			case BECOMESMUL:
				_localctx = new AssignmentTypeBecomesMulContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
				match(BECOMESMUL);
				}
				break;
			case BECOMESDIV:
				_localctx = new AssignmentTypeBecomesDivContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(111);
				match(BECOMESDIV);
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

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpIntLiteralContext extends ExpContext {
		public TerminalNode Int() { return getToken(MineIOParser.Int, 0); }
		public ExpIntLiteralContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitExpIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpSelectContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode AT() { return getToken(MineIOParser.AT, 0); }
		public ExpSelectContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitExpSelect(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpIndexedContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode LBRACKET() { return getToken(MineIOParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(MineIOParser.RBRACKET, 0); }
		public ExpIndexedContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitExpIndexed(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpTupleLiteralContext extends ExpContext {
		public TerminalNode LPAREN() { return getToken(MineIOParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MineIOParser.RPAREN, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MineIOParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MineIOParser.COMMA, i);
		}
		public ExpTupleLiteralContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitExpTupleLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpFunctionCallContext extends ExpContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(MineIOParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MineIOParser.RPAREN, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MineIOParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MineIOParser.COMMA, i);
		}
		public ExpFunctionCallContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitExpFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpBooleanLiteralContext extends ExpContext {
		public TerminalNode TRUE() { return getToken(MineIOParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MineIOParser.FALSE, 0); }
		public ExpBooleanLiteralContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitExpBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpVarRefContext extends ExpContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpVarRefContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitExpVarRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpBinaryContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode MUL() { return getToken(MineIOParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MineIOParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MineIOParser.MOD, 0); }
		public TerminalNode ADD() { return getToken(MineIOParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(MineIOParser.SUB, 0); }
		public TerminalNode GT() { return getToken(MineIOParser.GT, 0); }
		public TerminalNode GTEQ() { return getToken(MineIOParser.GTEQ, 0); }
		public TerminalNode LT() { return getToken(MineIOParser.LT, 0); }
		public TerminalNode LTEQ() { return getToken(MineIOParser.LTEQ, 0); }
		public TerminalNode EQUALS() { return getToken(MineIOParser.EQUALS, 0); }
		public TerminalNode NOTEQUALS() { return getToken(MineIOParser.NOTEQUALS, 0); }
		public TerminalNode AND() { return getToken(MineIOParser.AND, 0); }
		public TerminalNode OR() { return getToken(MineIOParser.OR, 0); }
		public ExpBinaryContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitExpBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpUnaryContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode NOT() { return getToken(MineIOParser.NOT, 0); }
		public TerminalNode TILDE() { return getToken(MineIOParser.TILDE, 0); }
		public ExpUnaryContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitExpUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpParensContext extends ExpContext {
		public TerminalNode LPAREN() { return getToken(MineIOParser.LPAREN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MineIOParser.RPAREN, 0); }
		public ExpParensContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitExpParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpItemDescriptorContext extends ExpContext {
		public ItemDescriptorContext itemDescriptor() {
			return getRuleContext(ItemDescriptorContext.class,0);
		}
		public ExpItemDescriptorContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitExpItemDescriptor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpFieldContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode DOT() { return getToken(MineIOParser.DOT, 0); }
		public TerminalNode Id() { return getToken(MineIOParser.Id, 0); }
		public ExpFieldContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitExpField(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpArrayLiteralContext extends ExpContext {
		public TerminalNode LBRACKET() { return getToken(MineIOParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(MineIOParser.RBRACKET, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MineIOParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MineIOParser.COMMA, i);
		}
		public ExpArrayLiteralContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitExpArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpStringLiteralContext extends ExpContext {
		public TerminalNode StringLiteral() { return getToken(MineIOParser.StringLiteral, 0); }
		public ExpStringLiteralContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitExpStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpTransferContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode ARROWRIGHT() { return getToken(MineIOParser.ARROWRIGHT, 0); }
		public ExpTransferContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitExpTransfer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new ExpUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(115);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(116);
				exp(3);
				}
				break;
			case 2:
				{
				_localctx = new ExpIntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(Int);
				}
				break;
			case 3:
				{
				_localctx = new ExpBooleanLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 4:
				{
				_localctx = new ExpStringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				match(StringLiteral);
				}
				break;
			case 5:
				{
				_localctx = new ExpArrayLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				match(LBRACKET);
				setState(129);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAREN) | (1L << LBRACKET) | (1L << LT) | (1L << NOT) | (1L << TILDE) | (1L << StringLiteral) | (1L << Id) | (1L << Int))) != 0)) {
					{
					setState(121);
					exp(0);
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(122);
						match(COMMA);
						setState(123);
						exp(0);
						}
						}
						setState(128);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(131);
				match(RBRACKET);
				}
				break;
			case 6:
				{
				_localctx = new ExpTupleLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(132);
				match(LPAREN);
				setState(141);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAREN) | (1L << LBRACKET) | (1L << LT) | (1L << NOT) | (1L << TILDE) | (1L << StringLiteral) | (1L << Id) | (1L << Int))) != 0)) {
					{
					setState(133);
					exp(0);
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(134);
						match(COMMA);
						setState(135);
						exp(0);
						}
						}
						setState(140);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(143);
				match(RPAREN);
				}
				break;
			case 7:
				{
				_localctx = new ExpParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				match(LPAREN);
				setState(145);
				exp(0);
				setState(146);
				match(RPAREN);
				}
				break;
			case 8:
				{
				_localctx = new ExpFunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				variable();
				setState(149);
				match(LPAREN);
				setState(158);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAREN) | (1L << LBRACKET) | (1L << LT) | (1L << NOT) | (1L << TILDE) | (1L << StringLiteral) | (1L << Id) | (1L << Int))) != 0)) {
					{
					setState(150);
					exp(0);
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(151);
						match(COMMA);
						setState(152);
						exp(0);
						}
						}
						setState(157);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(160);
				match(RPAREN);
				}
				break;
			case 9:
				{
				_localctx = new ExpVarRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				variable();
				}
				break;
			case 10:
				{
				_localctx = new ExpItemDescriptorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				itemDescriptor();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(200);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(198);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExpBinaryContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(166);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(167);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(168);
						exp(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpBinaryContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(169);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(170);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(171);
						exp(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpBinaryContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(172);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(173);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GTEQ) | (1L << LT) | (1L << LTEQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(174);
						exp(11);
						}
						break;
					case 4:
						{
						_localctx = new ExpBinaryContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(175);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(176);
						_la = _input.LA(1);
						if ( !(_la==EQUALS || _la==NOTEQUALS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(177);
						exp(10);
						}
						break;
					case 5:
						{
						_localctx = new ExpBinaryContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(178);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(179);
						match(AND);
						setState(180);
						exp(9);
						}
						break;
					case 6:
						{
						_localctx = new ExpBinaryContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(181);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(182);
						match(OR);
						setState(183);
						exp(8);
						}
						break;
					case 7:
						{
						_localctx = new ExpTransferContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(184);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(185);
						match(ARROWRIGHT);
						setState(186);
						exp(7);
						}
						break;
					case 8:
						{
						_localctx = new ExpSelectContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(187);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(188);
						match(AT);
						setState(189);
						exp(6);
						}
						break;
					case 9:
						{
						_localctx = new ExpFieldContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(190);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(191);
						match(DOT);
						setState(192);
						match(Id);
						}
						break;
					case 10:
						{
						_localctx = new ExpIndexedContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(193);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(194);
						match(LBRACKET);
						setState(195);
						exp(0);
						setState(196);
						match(RBRACKET);
						}
						break;
					}
					} 
				}
				setState(202);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class VariableContext extends ParserRuleContext {
		public NamespaceEntry namespaceEntry;
		public TerminalNode Id() { return getToken(MineIOParser.Id, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(Id);
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

	public static class ItemDescriptorContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(MineIOParser.LT, 0); }
		public ItemModNameContext itemModName() {
			return getRuleContext(ItemModNameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MineIOParser.COLON, 0); }
		public ItemNameContext itemName() {
			return getRuleContext(ItemNameContext.class,0);
		}
		public TerminalNode GT() { return getToken(MineIOParser.GT, 0); }
		public ItemDescriptorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itemDescriptor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitItemDescriptor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemDescriptorContext itemDescriptor() throws RecognitionException {
		ItemDescriptorContext _localctx = new ItemDescriptorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_itemDescriptor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(LT);
			setState(206);
			itemModName();
			setState(207);
			match(COLON);
			setState(208);
			itemName();
			setState(209);
			match(GT);
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

	public static class ItemModNameContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(MineIOParser.Id, 0); }
		public ItemModNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itemModName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitItemModName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemModNameContext itemModName() throws RecognitionException {
		ItemModNameContext _localctx = new ItemModNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_itemModName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(Id);
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

	public static class ItemNameContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(MineIOParser.Id, 0); }
		public ItemNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itemName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitItemName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemNameContext itemName() throws RecognitionException {
		ItemNameContext _localctx = new ItemNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_itemName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(Id);
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

	public static class TypeRefContext extends ParserRuleContext {
		public TypeRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeRef; }
	 
		public TypeRefContext() { }
		public void copyFrom(TypeRefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeArrayContext extends TypeRefContext {
		public TerminalNode LBRACKET() { return getToken(MineIOParser.LBRACKET, 0); }
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(MineIOParser.RBRACKET, 0); }
		public TypeArrayContext(TypeRefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitTypeArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeBooleanContext extends TypeRefContext {
		public TerminalNode TYPE_BOOLEAN() { return getToken(MineIOParser.TYPE_BOOLEAN, 0); }
		public TypeBooleanContext(TypeRefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitTypeBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeTupleContext extends TypeRefContext {
		public TerminalNode LPAREN() { return getToken(MineIOParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MineIOParser.RPAREN, 0); }
		public List<TypeRefContext> typeRef() {
			return getRuleContexts(TypeRefContext.class);
		}
		public TypeRefContext typeRef(int i) {
			return getRuleContext(TypeRefContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MineIOParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MineIOParser.COMMA, i);
		}
		public TypeTupleContext(TypeRefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitTypeTuple(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeContainerContext extends TypeRefContext {
		public TerminalNode TYPE_CONTAINER() { return getToken(MineIOParser.TYPE_CONTAINER, 0); }
		public TypeContainerContext(TypeRefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitTypeContainer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeItemContext extends TypeRefContext {
		public TerminalNode TYPE_ITEM() { return getToken(MineIOParser.TYPE_ITEM, 0); }
		public TypeItemContext(TypeRefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitTypeItem(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIntContext extends TypeRefContext {
		public TerminalNode TYPE_INT() { return getToken(MineIOParser.TYPE_INT, 0); }
		public TypeIntContext(TypeRefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitTypeInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeRecipeContext extends TypeRefContext {
		public TerminalNode TYPE_RECIPE() { return getToken(MineIOParser.TYPE_RECIPE, 0); }
		public TypeRecipeContext(TypeRefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitTypeRecipe(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeStringContext extends TypeRefContext {
		public TerminalNode TYPE_STRING() { return getToken(MineIOParser.TYPE_STRING, 0); }
		public TypeStringContext(TypeRefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitTypeString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeRefContext typeRef() throws RecognitionException {
		TypeRefContext _localctx = new TypeRefContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typeRef);
		int _la;
		try {
			setState(237);
			switch (_input.LA(1)) {
			case TYPE_ITEM:
				_localctx = new TypeItemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				match(TYPE_ITEM);
				}
				break;
			case TYPE_CONTAINER:
				_localctx = new TypeContainerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				match(TYPE_CONTAINER);
				}
				break;
			case TYPE_RECIPE:
				_localctx = new TypeRecipeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(217);
				match(TYPE_RECIPE);
				}
				break;
			case TYPE_INT:
				_localctx = new TypeIntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(218);
				match(TYPE_INT);
				}
				break;
			case TYPE_STRING:
				_localctx = new TypeStringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(219);
				match(TYPE_STRING);
				}
				break;
			case TYPE_BOOLEAN:
				_localctx = new TypeBooleanContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(220);
				match(TYPE_BOOLEAN);
				}
				break;
			case LBRACKET:
				_localctx = new TypeArrayContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(221);
				match(LBRACKET);
				setState(222);
				typeRef();
				setState(223);
				match(RBRACKET);
				}
				break;
			case LPAREN:
				_localctx = new TypeTupleContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(225);
				match(LPAREN);
				setState(234);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_ITEM) | (1L << TYPE_CONTAINER) | (1L << TYPE_RECIPE) | (1L << TYPE_INT) | (1L << TYPE_STRING) | (1L << TYPE_BOOLEAN) | (1L << LPAREN) | (1L << LBRACKET))) != 0)) {
					{
					setState(226);
					typeRef();
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(227);
						match(COMMA);
						setState(228);
						typeRef();
						}
						}
						setState(233);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(236);
				match(RPAREN);
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

	public static class ArrayRefContext extends ParserRuleContext {
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(MineIOParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(MineIOParser.RBRACKET, 0); }
		public ArrayRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayRef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitArrayRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayRefContext arrayRef() throws RecognitionException {
		ArrayRefContext _localctx = new ArrayRefContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arrayRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			typeRef();
			setState(240);
			match(LBRACKET);
			setState(241);
			match(RBRACKET);
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
		case 6:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\67\u00f6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\3\3\3"+
		"\5\3%\n\3\3\4\3\4\3\4\3\4\5\4+\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\63\n\4"+
		"\f\4\16\4\66\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4@\n\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\7\4I\n\4\f\4\16\4L\13\4\5\4N\n\4\3\4\3\4\3\4\5\4S\n\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4g\n\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7s\n\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\177\n\b\f\b\16\b\u0082\13\b\5\b\u0084"+
		"\n\b\3\b\3\b\3\b\3\b\3\b\7\b\u008b\n\b\f\b\16\b\u008e\13\b\5\b\u0090\n"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u009c\n\b\f\b\16\b\u009f"+
		"\13\b\5\b\u00a1\n\b\3\b\3\b\3\b\3\b\5\b\u00a7\n\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00c9\n\b\f\b\16\b\u00cc\13"+
		"\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00e8\n\r\f\r\16\r\u00eb\13"+
		"\r\5\r\u00ed\n\r\3\r\5\r\u00f0\n\r\3\16\3\16\3\16\3\16\3\16\2\3\16\17"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\2\b\3\2$%\3\2\t\n\3\2\30\32\3\2\26\27"+
		"\3\2\33\36\3\2\37 \u011e\2\37\3\2\2\2\4\"\3\2\2\2\6f\3\2\2\2\bh\3\2\2"+
		"\2\nk\3\2\2\2\fr\3\2\2\2\16\u00a6\3\2\2\2\20\u00cd\3\2\2\2\22\u00cf\3"+
		"\2\2\2\24\u00d5\3\2\2\2\26\u00d7\3\2\2\2\30\u00ef\3\2\2\2\32\u00f1\3\2"+
		"\2\2\34\36\5\4\3\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2"+
		" \3\3\2\2\2!\37\3\2\2\2\"$\5\6\4\2#%\7\24\2\2$#\3\2\2\2$%\3\2\2\2%\5\3"+
		"\2\2\2&\'\5\30\r\2\'*\5\20\t\2()\7\'\2\2)+\5\16\b\2*(\3\2\2\2*+\3\2\2"+
		"\2+g\3\2\2\2,-\5\20\t\2-.\5\f\7\2./\5\16\b\2/g\3\2\2\2\60\64\7\21\2\2"+
		"\61\63\5\4\3\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2"+
		"\65\67\3\2\2\2\66\64\3\2\2\2\67g\7\22\2\289\7\13\2\29:\7\r\2\2:;\5\16"+
		"\b\2;<\7\16\2\2<?\5\6\4\2=>\7\f\2\2>@\5\6\4\2?=\3\2\2\2?@\3\2\2\2@g\3"+
		"\2\2\2Ag\5\16\b\2BC\7,\2\2CD\5\20\t\2DM\7\r\2\2EJ\5\b\5\2FG\7\25\2\2G"+
		"I\5\b\5\2HF\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KN\3\2\2\2LJ\3\2\2\2"+
		"ME\3\2\2\2MN\3\2\2\2NO\3\2\2\2OR\7\16\2\2PQ\7\23\2\2QS\5\30\r\2RP\3\2"+
		"\2\2RS\3\2\2\2ST\3\2\2\2TU\5\n\6\2Ug\3\2\2\2VW\7/\2\2WX\7\r\2\2XY\5\16"+
		"\b\2YZ\7\16\2\2Z[\5\6\4\2[g\3\2\2\2\\]\7\60\2\2]^\7\r\2\2^_\5\16\b\2_"+
		"`\7\61\2\2`a\5\20\t\2ab\7\16\2\2bc\5\6\4\2cg\3\2\2\2de\7-\2\2eg\5\16\b"+
		"\2f&\3\2\2\2f,\3\2\2\2f\60\3\2\2\2f8\3\2\2\2fA\3\2\2\2fB\3\2\2\2fV\3\2"+
		"\2\2f\\\3\2\2\2fd\3\2\2\2g\7\3\2\2\2hi\5\30\r\2ij\5\20\t\2j\t\3\2\2\2"+
		"kl\5\6\4\2l\13\3\2\2\2ms\7\'\2\2ns\7(\2\2os\7)\2\2ps\7+\2\2qs\7*\2\2r"+
		"m\3\2\2\2rn\3\2\2\2ro\3\2\2\2rp\3\2\2\2rq\3\2\2\2s\r\3\2\2\2tu\b\b\1\2"+
		"uv\t\2\2\2v\u00a7\5\16\b\5w\u00a7\7\67\2\2x\u00a7\t\3\2\2y\u00a7\7\65"+
		"\2\2z\u0083\7\17\2\2{\u0080\5\16\b\2|}\7\25\2\2}\177\5\16\b\2~|\3\2\2"+
		"\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0084\3"+
		"\2\2\2\u0082\u0080\3\2\2\2\u0083{\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085"+
		"\3\2\2\2\u0085\u00a7\7\20\2\2\u0086\u008f\7\r\2\2\u0087\u008c\5\16\b\2"+
		"\u0088\u0089\7\25\2\2\u0089\u008b\5\16\b\2\u008a\u0088\3\2\2\2\u008b\u008e"+
		"\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u0090\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008f\u0087\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\u00a7\7\16\2\2\u0092\u0093\7\r\2\2\u0093\u0094\5\16\b\2\u0094"+
		"\u0095\7\16\2\2\u0095\u00a7\3\2\2\2\u0096\u0097\5\20\t\2\u0097\u00a0\7"+
		"\r\2\2\u0098\u009d\5\16\b\2\u0099\u009a\7\25\2\2\u009a\u009c\5\16\b\2"+
		"\u009b\u0099\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e"+
		"\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u0098\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7\16\2\2\u00a3\u00a7\3"+
		"\2\2\2\u00a4\u00a7\5\20\t\2\u00a5\u00a7\5\22\n\2\u00a6t\3\2\2\2\u00a6"+
		"w\3\2\2\2\u00a6x\3\2\2\2\u00a6y\3\2\2\2\u00a6z\3\2\2\2\u00a6\u0086\3\2"+
		"\2\2\u00a6\u0092\3\2\2\2\u00a6\u0096\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6"+
		"\u00a5\3\2\2\2\u00a7\u00ca\3\2\2\2\u00a8\u00a9\f\16\2\2\u00a9\u00aa\t"+
		"\4\2\2\u00aa\u00c9\5\16\b\17\u00ab\u00ac\f\r\2\2\u00ac\u00ad\t\5\2\2\u00ad"+
		"\u00c9\5\16\b\16\u00ae\u00af\f\f\2\2\u00af\u00b0\t\6\2\2\u00b0\u00c9\5"+
		"\16\b\r\u00b1\u00b2\f\13\2\2\u00b2\u00b3\t\7\2\2\u00b3\u00c9\5\16\b\f"+
		"\u00b4\u00b5\f\n\2\2\u00b5\u00b6\7!\2\2\u00b6\u00c9\5\16\b\13\u00b7\u00b8"+
		"\f\t\2\2\u00b8\u00b9\7\"\2\2\u00b9\u00c9\5\16\b\n\u00ba\u00bb\f\b\2\2"+
		"\u00bb\u00bc\7\62\2\2\u00bc\u00c9\5\16\b\t\u00bd\u00be\f\7\2\2\u00be\u00bf"+
		"\7#\2\2\u00bf\u00c9\5\16\b\b\u00c0\u00c1\f\6\2\2\u00c1\u00c2\7.\2\2\u00c2"+
		"\u00c9\7\66\2\2\u00c3\u00c4\f\4\2\2\u00c4\u00c5\7\17\2\2\u00c5\u00c6\5"+
		"\16\b\2\u00c6\u00c7\7\20\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00a8\3\2\2\2\u00c8"+
		"\u00ab\3\2\2\2\u00c8\u00ae\3\2\2\2\u00c8\u00b1\3\2\2\2\u00c8\u00b4\3\2"+
		"\2\2\u00c8\u00b7\3\2\2\2\u00c8\u00ba\3\2\2\2\u00c8\u00bd\3\2\2\2\u00c8"+
		"\u00c0\3\2\2\2\u00c8\u00c3\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2"+
		"\2\2\u00ca\u00cb\3\2\2\2\u00cb\17\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce"+
		"\7\66\2\2\u00ce\21\3\2\2\2\u00cf\u00d0\7\35\2\2\u00d0\u00d1\5\24\13\2"+
		"\u00d1\u00d2\7\23\2\2\u00d2\u00d3\5\26\f\2\u00d3\u00d4\7\33\2\2\u00d4"+
		"\23\3\2\2\2\u00d5\u00d6\7\66\2\2\u00d6\25\3\2\2\2\u00d7\u00d8\7\66\2\2"+
		"\u00d8\27\3\2\2\2\u00d9\u00f0\7\3\2\2\u00da\u00f0\7\4\2\2\u00db\u00f0"+
		"\7\5\2\2\u00dc\u00f0\7\6\2\2\u00dd\u00f0\7\7\2\2\u00de\u00f0\7\b\2\2\u00df"+
		"\u00e0\7\17\2\2\u00e0\u00e1\5\30\r\2\u00e1\u00e2\7\20\2\2\u00e2\u00f0"+
		"\3\2\2\2\u00e3\u00ec\7\r\2\2\u00e4\u00e9\5\30\r\2\u00e5\u00e6\7\25\2\2"+
		"\u00e6\u00e8\5\30\r\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec"+
		"\u00e4\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\7\16"+
		"\2\2\u00ef\u00d9\3\2\2\2\u00ef\u00da\3\2\2\2\u00ef\u00db\3\2\2\2\u00ef"+
		"\u00dc\3\2\2\2\u00ef\u00dd\3\2\2\2\u00ef\u00de\3\2\2\2\u00ef\u00df\3\2"+
		"\2\2\u00ef\u00e3\3\2\2\2\u00f0\31\3\2\2\2\u00f1\u00f2\5\30\r\2\u00f2\u00f3"+
		"\7\17\2\2\u00f3\u00f4\7\20\2\2\u00f4\33\3\2\2\2\30\37$*\64?JMRfr\u0080"+
		"\u0083\u008c\u008f\u009d\u00a0\u00a6\u00c8\u00ca\u00e9\u00ec\u00ef";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}