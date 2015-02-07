// Generated from MineIO.g4 by ANTLR 4.5

package com.besuikerd.mirandacraft.mineio.parser;

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
		RULE_program = 0, RULE_statement = 1, RULE_declaration = 2, RULE_assignment = 3, 
		RULE_block = 4, RULE_condition = 5, RULE_whileStatement = 6, RULE_foreachStatement = 7, 
		RULE_returnStatement = 8, RULE_functionDeclaration = 9, RULE_formalParameter = 10, 
		RULE_functionBody = 11, RULE_assignmentType = 12, RULE_exp = 13, RULE_itemDescriptor = 14, 
		RULE_itemModName = 15, RULE_itemName = 16, RULE_typeRef = 17, RULE_arrayRef = 18;
	public static final String[] ruleNames = {
		"program", "statement", "declaration", "assignment", "block", "condition", 
		"whileStatement", "foreachStatement", "returnStatement", "functionDeclaration", 
		"formalParameter", "functionBody", "assignmentType", "exp", "itemDescriptor", 
		"itemModName", "itemName", "typeRef", "arrayRef"
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_ITEM) | (1L << TYPE_CONTAINER) | (1L << TYPE_RECIPE) | (1L << TYPE_INT) | (1L << TYPE_STRING) | (1L << TYPE_BOOLEAN) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << LPAREN) | (1L << LBRACKET) | (1L << LCURLY) | (1L << LT) | (1L << NOT) | (1L << TILDE) | (1L << FUNCTION) | (1L << RETURN) | (1L << WHILE) | (1L << FOREACH) | (1L << StringLiteral) | (1L << Id) | (1L << Int))) != 0)) {
				{
				{
				setState(38);
				statement();
				}
				}
				setState(43);
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

	public static class StatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForeachStatementContext foreachStatement() {
			return getRuleContext(ForeachStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MineIOParser.SEMICOLON, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(44);
				declaration();
				}
				break;
			case 2:
				{
				setState(45);
				assignment();
				}
				break;
			case 3:
				{
				setState(46);
				block();
				}
				break;
			case 4:
				{
				setState(47);
				condition();
				}
				break;
			case 5:
				{
				setState(48);
				exp(0);
				}
				break;
			case 6:
				{
				setState(49);
				functionDeclaration();
				}
				break;
			case 7:
				{
				setState(50);
				whileStatement();
				}
				break;
			case 8:
				{
				setState(51);
				foreachStatement();
				}
				break;
			case 9:
				{
				setState(52);
				returnStatement();
				}
				break;
			}
			setState(56);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(55);
				match(SEMICOLON);
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

	public static class DeclarationContext extends ParserRuleContext {
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public TerminalNode Id() { return getToken(MineIOParser.Id, 0); }
		public TerminalNode BECOMES() { return getToken(MineIOParser.BECOMES, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			typeRef();
			setState(59);
			match(Id);
			setState(62);
			_la = _input.LA(1);
			if (_la==BECOMES) {
				{
				setState(60);
				match(BECOMES);
				setState(61);
				exp(0);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode Id() { return getToken(MineIOParser.Id, 0); }
		public AssignmentTypeContext assignmentType() {
			return getRuleContext(AssignmentTypeContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(Id);
			setState(65);
			assignmentType();
			setState(66);
			exp(0);
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(MineIOParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(MineIOParser.RCURLY, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(LCURLY);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_ITEM) | (1L << TYPE_CONTAINER) | (1L << TYPE_RECIPE) | (1L << TYPE_INT) | (1L << TYPE_STRING) | (1L << TYPE_BOOLEAN) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << LPAREN) | (1L << LBRACKET) | (1L << LCURLY) | (1L << LT) | (1L << NOT) | (1L << TILDE) | (1L << FUNCTION) | (1L << RETURN) | (1L << WHILE) | (1L << FOREACH) | (1L << StringLiteral) | (1L << Id) | (1L << Int))) != 0)) {
				{
				{
				setState(69);
				statement();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			match(RCURLY);
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
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(IF);
			setState(78);
			match(LPAREN);
			setState(79);
			exp(0);
			setState(80);
			match(RPAREN);
			setState(81);
			statement();
			setState(84);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(82);
				match(ELSE);
				setState(83);
				statement();
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

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MineIOParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(MineIOParser.LPAREN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MineIOParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(WHILE);
			setState(87);
			match(LPAREN);
			setState(88);
			exp(0);
			setState(89);
			match(RPAREN);
			setState(90);
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

	public static class ForeachStatementContext extends ParserRuleContext {
		public TerminalNode FOREACH() { return getToken(MineIOParser.FOREACH, 0); }
		public TerminalNode LPAREN() { return getToken(MineIOParser.LPAREN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode AS() { return getToken(MineIOParser.AS, 0); }
		public TerminalNode Id() { return getToken(MineIOParser.Id, 0); }
		public TerminalNode RPAREN() { return getToken(MineIOParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForeachStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreachStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitForeachStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForeachStatementContext foreachStatement() throws RecognitionException {
		ForeachStatementContext _localctx = new ForeachStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_foreachStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(FOREACH);
			setState(93);
			match(LPAREN);
			setState(94);
			exp(0);
			setState(95);
			match(AS);
			setState(96);
			match(Id);
			setState(97);
			match(RPAREN);
			setState(98);
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MineIOParser.RETURN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(RETURN);
			setState(101);
			exp(0);
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

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(MineIOParser.FUNCTION, 0); }
		public TerminalNode Id() { return getToken(MineIOParser.Id, 0); }
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
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(FUNCTION);
			setState(104);
			match(Id);
			setState(105);
			match(LPAREN);
			setState(114);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_ITEM) | (1L << TYPE_CONTAINER) | (1L << TYPE_RECIPE) | (1L << TYPE_INT) | (1L << TYPE_STRING) | (1L << TYPE_BOOLEAN) | (1L << LPAREN) | (1L << LBRACKET))) != 0)) {
				{
				setState(106);
				formalParameter();
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(107);
					match(COMMA);
					setState(108);
					formalParameter();
					}
					}
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(116);
			match(RPAREN);
			setState(119);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(117);
				match(COLON);
				setState(118);
				typeRef();
				}
			}

			setState(121);
			functionBody();
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
		public TerminalNode Id() { return getToken(MineIOParser.Id, 0); }
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
		enterRule(_localctx, 20, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			typeRef();
			setState(124);
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
		enterRule(_localctx, 22, RULE_functionBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
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
		public TerminalNode BECOMES() { return getToken(MineIOParser.BECOMES, 0); }
		public TerminalNode BECOMESADD() { return getToken(MineIOParser.BECOMESADD, 0); }
		public TerminalNode BECOMESSUB() { return getToken(MineIOParser.BECOMESSUB, 0); }
		public TerminalNode BECOMESMUL() { return getToken(MineIOParser.BECOMESMUL, 0); }
		public TerminalNode BECOMESDIV() { return getToken(MineIOParser.BECOMESDIV, 0); }
		public AssignmentTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MineIOVisitor ) return ((MineIOVisitor<? extends T>)visitor).visitAssignmentType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentTypeContext assignmentType() throws RecognitionException {
		AssignmentTypeContext _localctx = new AssignmentTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assignmentType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BECOMES) | (1L << BECOMESADD) | (1L << BECOMESSUB) | (1L << BECOMESDIV) | (1L << BECOMESMUL))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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
		public TerminalNode Id() { return getToken(MineIOParser.Id, 0); }
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
		public TerminalNode Id() { return getToken(MineIOParser.Id, 0); }
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new ExpUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(131);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==TILDE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(132);
				exp(3);
				}
				break;
			case 2:
				{
				_localctx = new ExpIntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				match(Int);
				}
				break;
			case 3:
				{
				_localctx = new ExpBooleanLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
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
				setState(135);
				match(StringLiteral);
				}
				break;
			case 5:
				{
				_localctx = new ExpArrayLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				match(LBRACKET);
				setState(145);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAREN) | (1L << LBRACKET) | (1L << LT) | (1L << NOT) | (1L << TILDE) | (1L << StringLiteral) | (1L << Id) | (1L << Int))) != 0)) {
					{
					setState(137);
					exp(0);
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(138);
						match(COMMA);
						setState(139);
						exp(0);
						}
						}
						setState(144);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(147);
				match(RBRACKET);
				}
				break;
			case 6:
				{
				_localctx = new ExpTupleLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				match(LPAREN);
				setState(157);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAREN) | (1L << LBRACKET) | (1L << LT) | (1L << NOT) | (1L << TILDE) | (1L << StringLiteral) | (1L << Id) | (1L << Int))) != 0)) {
					{
					setState(149);
					exp(0);
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(150);
						match(COMMA);
						setState(151);
						exp(0);
						}
						}
						setState(156);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(159);
				match(RPAREN);
				}
				break;
			case 7:
				{
				_localctx = new ExpParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				match(LPAREN);
				setState(161);
				exp(0);
				setState(162);
				match(RPAREN);
				}
				break;
			case 8:
				{
				_localctx = new ExpFunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				match(Id);
				setState(165);
				match(LPAREN);
				setState(174);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << LPAREN) | (1L << LBRACKET) | (1L << LT) | (1L << NOT) | (1L << TILDE) | (1L << StringLiteral) | (1L << Id) | (1L << Int))) != 0)) {
					{
					setState(166);
					exp(0);
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(167);
						match(COMMA);
						setState(168);
						exp(0);
						}
						}
						setState(173);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(176);
				match(RPAREN);
				}
				break;
			case 9:
				{
				_localctx = new ExpVarRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				match(Id);
				}
				break;
			case 10:
				{
				_localctx = new ExpItemDescriptorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				itemDescriptor();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(215);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(213);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ExpBinaryContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(181);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(182);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(183);
						exp(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpBinaryContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(184);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(185);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(186);
						exp(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpBinaryContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(187);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(188);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GTEQ) | (1L << LT) | (1L << LTEQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(189);
						exp(11);
						}
						break;
					case 4:
						{
						_localctx = new ExpBinaryContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(190);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(191);
						_la = _input.LA(1);
						if ( !(_la==EQUALS || _la==NOTEQUALS) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(192);
						exp(10);
						}
						break;
					case 5:
						{
						_localctx = new ExpBinaryContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(193);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(194);
						match(AND);
						setState(195);
						exp(9);
						}
						break;
					case 6:
						{
						_localctx = new ExpBinaryContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(196);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(197);
						match(OR);
						setState(198);
						exp(8);
						}
						break;
					case 7:
						{
						_localctx = new ExpTransferContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(199);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(200);
						match(ARROWRIGHT);
						setState(201);
						exp(7);
						}
						break;
					case 8:
						{
						_localctx = new ExpSelectContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(202);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(203);
						match(AT);
						setState(204);
						exp(6);
						}
						break;
					case 9:
						{
						_localctx = new ExpFieldContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(205);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(206);
						match(DOT);
						setState(207);
						match(Id);
						}
						break;
					case 10:
						{
						_localctx = new ExpIndexedContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(208);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(209);
						match(LBRACKET);
						setState(210);
						exp(0);
						setState(211);
						match(RBRACKET);
						}
						break;
					}
					} 
				}
				setState(217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		enterRule(_localctx, 28, RULE_itemDescriptor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(LT);
			setState(219);
			itemModName();
			setState(220);
			match(COLON);
			setState(221);
			itemName();
			setState(222);
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
		enterRule(_localctx, 30, RULE_itemModName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
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
		enterRule(_localctx, 32, RULE_itemName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
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
		enterRule(_localctx, 34, RULE_typeRef);
		int _la;
		try {
			setState(250);
			switch (_input.LA(1)) {
			case TYPE_ITEM:
				_localctx = new TypeItemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				match(TYPE_ITEM);
				}
				break;
			case TYPE_CONTAINER:
				_localctx = new TypeContainerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				match(TYPE_CONTAINER);
				}
				break;
			case TYPE_RECIPE:
				_localctx = new TypeRecipeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(230);
				match(TYPE_RECIPE);
				}
				break;
			case TYPE_INT:
				_localctx = new TypeIntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(231);
				match(TYPE_INT);
				}
				break;
			case TYPE_STRING:
				_localctx = new TypeStringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(232);
				match(TYPE_STRING);
				}
				break;
			case TYPE_BOOLEAN:
				_localctx = new TypeBooleanContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(233);
				match(TYPE_BOOLEAN);
				}
				break;
			case LBRACKET:
				_localctx = new TypeArrayContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(234);
				match(LBRACKET);
				setState(235);
				typeRef();
				setState(236);
				match(RBRACKET);
				}
				break;
			case LPAREN:
				_localctx = new TypeTupleContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(238);
				match(LPAREN);
				setState(247);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_ITEM) | (1L << TYPE_CONTAINER) | (1L << TYPE_RECIPE) | (1L << TYPE_INT) | (1L << TYPE_STRING) | (1L << TYPE_BOOLEAN) | (1L << LPAREN) | (1L << LBRACKET))) != 0)) {
					{
					setState(239);
					typeRef();
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(240);
						match(COMMA);
						setState(241);
						typeRef();
						}
						}
						setState(246);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(249);
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
		enterRule(_localctx, 36, RULE_arrayRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			typeRef();
			setState(253);
			match(LBRACKET);
			setState(254);
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
		case 13:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\67\u0103\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\7\2*\n\2\f\2\16\2-\13\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\5\38\n\3\3\3\5\3;\n\3\3\4\3\4\3\4\3\4\5\4A\n\4\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\7\6I\n\6\f\6\16\6L\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7W\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13p\n\13\f\13\16\13s\13"+
		"\13\5\13u\n\13\3\13\3\13\3\13\5\13z\n\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u008f"+
		"\n\17\f\17\16\17\u0092\13\17\5\17\u0094\n\17\3\17\3\17\3\17\3\17\3\17"+
		"\7\17\u009b\n\17\f\17\16\17\u009e\13\17\5\17\u00a0\n\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00ac\n\17\f\17\16\17\u00af\13"+
		"\17\5\17\u00b1\n\17\3\17\3\17\3\17\5\17\u00b6\n\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\7\17\u00d8\n\17\f\17\16\17\u00db\13\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\7\23\u00f5\n\23\f\23\16\23\u00f8\13\23\5\23\u00fa"+
		"\n\23\3\23\5\23\u00fd\n\23\3\24\3\24\3\24\3\24\3\24\2\3\34\25\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\t\3\2\'+\3\2$%\3\2\t\n\3\2\30\32"+
		"\3\2\26\27\3\2\33\36\3\2\37 \u0121\2+\3\2\2\2\4\67\3\2\2\2\6<\3\2\2\2"+
		"\bB\3\2\2\2\nF\3\2\2\2\fO\3\2\2\2\16X\3\2\2\2\20^\3\2\2\2\22f\3\2\2\2"+
		"\24i\3\2\2\2\26}\3\2\2\2\30\u0080\3\2\2\2\32\u0082\3\2\2\2\34\u00b5\3"+
		"\2\2\2\36\u00dc\3\2\2\2 \u00e2\3\2\2\2\"\u00e4\3\2\2\2$\u00fc\3\2\2\2"+
		"&\u00fe\3\2\2\2(*\5\4\3\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\3\3"+
		"\2\2\2-+\3\2\2\2.8\5\6\4\2/8\5\b\5\2\608\5\n\6\2\618\5\f\7\2\628\5\34"+
		"\17\2\638\5\24\13\2\648\5\16\b\2\658\5\20\t\2\668\5\22\n\2\67.\3\2\2\2"+
		"\67/\3\2\2\2\67\60\3\2\2\2\67\61\3\2\2\2\67\62\3\2\2\2\67\63\3\2\2\2\67"+
		"\64\3\2\2\2\67\65\3\2\2\2\67\66\3\2\2\28:\3\2\2\29;\7\24\2\2:9\3\2\2\2"+
		":;\3\2\2\2;\5\3\2\2\2<=\5$\23\2=@\7\66\2\2>?\7\'\2\2?A\5\34\17\2@>\3\2"+
		"\2\2@A\3\2\2\2A\7\3\2\2\2BC\7\66\2\2CD\5\32\16\2DE\5\34\17\2E\t\3\2\2"+
		"\2FJ\7\21\2\2GI\5\4\3\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2"+
		"\2\2LJ\3\2\2\2MN\7\22\2\2N\13\3\2\2\2OP\7\13\2\2PQ\7\r\2\2QR\5\34\17\2"+
		"RS\7\16\2\2SV\5\4\3\2TU\7\f\2\2UW\5\4\3\2VT\3\2\2\2VW\3\2\2\2W\r\3\2\2"+
		"\2XY\7/\2\2YZ\7\r\2\2Z[\5\34\17\2[\\\7\16\2\2\\]\5\4\3\2]\17\3\2\2\2^"+
		"_\7\60\2\2_`\7\r\2\2`a\5\34\17\2ab\7\61\2\2bc\7\66\2\2cd\7\16\2\2de\5"+
		"\4\3\2e\21\3\2\2\2fg\7-\2\2gh\5\34\17\2h\23\3\2\2\2ij\7,\2\2jk\7\66\2"+
		"\2kt\7\r\2\2lq\5\26\f\2mn\7\25\2\2np\5\26\f\2om\3\2\2\2ps\3\2\2\2qo\3"+
		"\2\2\2qr\3\2\2\2ru\3\2\2\2sq\3\2\2\2tl\3\2\2\2tu\3\2\2\2uv\3\2\2\2vy\7"+
		"\16\2\2wx\7\23\2\2xz\5$\23\2yw\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\5\30\r\2"+
		"|\25\3\2\2\2}~\5$\23\2~\177\7\66\2\2\177\27\3\2\2\2\u0080\u0081\5\4\3"+
		"\2\u0081\31\3\2\2\2\u0082\u0083\t\2\2\2\u0083\33\3\2\2\2\u0084\u0085\b"+
		"\17\1\2\u0085\u0086\t\3\2\2\u0086\u00b6\5\34\17\5\u0087\u00b6\7\67\2\2"+
		"\u0088\u00b6\t\4\2\2\u0089\u00b6\7\65\2\2\u008a\u0093\7\17\2\2\u008b\u0090"+
		"\5\34\17\2\u008c\u008d\7\25\2\2\u008d\u008f\5\34\17\2\u008e\u008c\3\2"+
		"\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u008b\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u00b6\7\20\2\2\u0096\u009f\7\r\2\2\u0097"+
		"\u009c\5\34\17\2\u0098\u0099\7\25\2\2\u0099\u009b\5\34\17\2\u009a\u0098"+
		"\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u0097\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00b6\7\16\2\2\u00a2\u00a3\7\r\2\2\u00a3"+
		"\u00a4\5\34\17\2\u00a4\u00a5\7\16\2\2\u00a5\u00b6\3\2\2\2\u00a6\u00a7"+
		"\7\66\2\2\u00a7\u00b0\7\r\2\2\u00a8\u00ad\5\34\17\2\u00a9\u00aa\7\25\2"+
		"\2\u00aa\u00ac\5\34\17\2\u00ab\u00a9\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00b0\u00a8\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b6\7\16\2\2\u00b3\u00b6\7\66\2\2\u00b4\u00b6\5\36\20\2\u00b5\u0084"+
		"\3\2\2\2\u00b5\u0087\3\2\2\2\u00b5\u0088\3\2\2\2\u00b5\u0089\3\2\2\2\u00b5"+
		"\u008a\3\2\2\2\u00b5\u0096\3\2\2\2\u00b5\u00a2\3\2\2\2\u00b5\u00a6\3\2"+
		"\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00d9\3\2\2\2\u00b7"+
		"\u00b8\f\16\2\2\u00b8\u00b9\t\5\2\2\u00b9\u00d8\5\34\17\17\u00ba\u00bb"+
		"\f\r\2\2\u00bb\u00bc\t\6\2\2\u00bc\u00d8\5\34\17\16\u00bd\u00be\f\f\2"+
		"\2\u00be\u00bf\t\7\2\2\u00bf\u00d8\5\34\17\r\u00c0\u00c1\f\13\2\2\u00c1"+
		"\u00c2\t\b\2\2\u00c2\u00d8\5\34\17\f\u00c3\u00c4\f\n\2\2\u00c4\u00c5\7"+
		"!\2\2\u00c5\u00d8\5\34\17\13\u00c6\u00c7\f\t\2\2\u00c7\u00c8\7\"\2\2\u00c8"+
		"\u00d8\5\34\17\n\u00c9\u00ca\f\b\2\2\u00ca\u00cb\7\62\2\2\u00cb\u00d8"+
		"\5\34\17\t\u00cc\u00cd\f\7\2\2\u00cd\u00ce\7#\2\2\u00ce\u00d8\5\34\17"+
		"\b\u00cf\u00d0\f\6\2\2\u00d0\u00d1\7.\2\2\u00d1\u00d8\7\66\2\2\u00d2\u00d3"+
		"\f\4\2\2\u00d3\u00d4\7\17\2\2\u00d4\u00d5\5\34\17\2\u00d5\u00d6\7\20\2"+
		"\2\u00d6\u00d8\3\2\2\2\u00d7\u00b7\3\2\2\2\u00d7\u00ba\3\2\2\2\u00d7\u00bd"+
		"\3\2\2\2\u00d7\u00c0\3\2\2\2\u00d7\u00c3\3\2\2\2\u00d7\u00c6\3\2\2\2\u00d7"+
		"\u00c9\3\2\2\2\u00d7\u00cc\3\2\2\2\u00d7\u00cf\3\2\2\2\u00d7\u00d2\3\2"+
		"\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\35\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\7\35\2\2\u00dd\u00de\5 \21"+
		"\2\u00de\u00df\7\23\2\2\u00df\u00e0\5\"\22\2\u00e0\u00e1\7\33\2\2\u00e1"+
		"\37\3\2\2\2\u00e2\u00e3\7\66\2\2\u00e3!\3\2\2\2\u00e4\u00e5\7\66\2\2\u00e5"+
		"#\3\2\2\2\u00e6\u00fd\7\3\2\2\u00e7\u00fd\7\4\2\2\u00e8\u00fd\7\5\2\2"+
		"\u00e9\u00fd\7\6\2\2\u00ea\u00fd\7\7\2\2\u00eb\u00fd\7\b\2\2\u00ec\u00ed"+
		"\7\17\2\2\u00ed\u00ee\5$\23\2\u00ee\u00ef\7\20\2\2\u00ef\u00fd\3\2\2\2"+
		"\u00f0\u00f9\7\r\2\2\u00f1\u00f6\5$\23\2\u00f2\u00f3\7\25\2\2\u00f3\u00f5"+
		"\5$\23\2\u00f4\u00f2\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00f1\3\2"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\7\16\2\2\u00fc"+
		"\u00e6\3\2\2\2\u00fc\u00e7\3\2\2\2\u00fc\u00e8\3\2\2\2\u00fc\u00e9\3\2"+
		"\2\2\u00fc\u00ea\3\2\2\2\u00fc\u00eb\3\2\2\2\u00fc\u00ec\3\2\2\2\u00fc"+
		"\u00f0\3\2\2\2\u00fd%\3\2\2\2\u00fe\u00ff\5$\23\2\u00ff\u0100\7\17\2\2"+
		"\u0100\u0101\7\20\2\2\u0101\'\3\2\2\2\27+\67:@JVqty\u0090\u0093\u009c"+
		"\u009f\u00ad\u00b0\u00b5\u00d7\u00d9\u00f6\u00f9\u00fc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}