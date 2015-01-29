package com.besuikerd.mirandacraft.lib.classifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassifierParser {
	
	private StringBuilder input;
	private StringBuilder tokenBuilder;
	private Token current;
	private int currentChar;
	
	public ClassifierRule parse(String input) throws ParseException{
		this.input = new StringBuilder(input);
		this.tokenBuilder = new StringBuilder();
		this.current = peek();
		this.currentChar = 0;
		
		
		ClassifierRule rule = parseAndRule();
		expect(TokenType.EOF);
		return rule;
	}
	
	private ClassifierRule parseAndRule() throws ParseException{
		ClassifierRule lhs = parseOrRule();
		if(current.type == TokenType.AND){
			accept(TokenType.AND);
			return new ClassifierAndRule(lhs, parseAndRule());
		}
		return lhs;
	}
	
	private ClassifierRule parseOrRule() throws ParseException{
		ClassifierRule lhs = parseRule();
		if(current.type == TokenType.OR){
			accept(TokenType.OR);
			return new ClassifierOrRule(lhs, parseOrRule());
		}
		return lhs;
	}
	
	private ClassifierActualRule parseRule() throws ParseException{		
		accept(TokenType.AT);
		String name = accept(TokenType.IDENTIFIER).value;
		Map<String, ClassifierArgument> args = new HashMap<String, ClassifierArgument>();
		
		if(current.type == TokenType.LBRACKET){
			accept(TokenType.LBRACKET);
			if(current.type != TokenType.RBRACKET){
				String key = accept(TokenType.IDENTIFIER).value;
				Token token = current.type == TokenType.NEQ ? accept(TokenType.NEQ) : accept(TokenType.EQ);
				boolean equals = token.type == TokenType.EQ;
				args.put(key, parseArgument(key, equals));
				while(current.type == TokenType.COMMA){
					consume();
					key = accept(TokenType.IDENTIFIER).value;
					token = current.type == TokenType.NEQ ? accept(TokenType.NEQ) : accept(TokenType.EQ);
					equals = token.type == TokenType.EQ;
					args.put(key, parseArgument(key, equals));
				}
			}
			accept(TokenType.RBRACKET);
		}
		
		return new ClassifierActualRule(name, args);
	}
	
	private ClassifierArgument parseArgument(String name, boolean equals) throws ParseException{
		switch(current.type){
		case NUMBER:
			String num = consume().value;
			if(current.type == TokenType.DOT){
				consume();
				String doubleVal = num + "." + accept(TokenType.NUMBER).value;
				try{
					return new ClassifierArgumentDouble(name, Double.parseDouble(doubleVal), equals);
				} catch(NumberFormatException e){
					throw fail("Invalid number: %s", doubleVal);
				}
			} else{
				try{
					return new ClassifierArgumentInt(name, Integer.parseInt(num), equals);
				} catch(NumberFormatException e){
					throw fail("Invalid number: %s", num);
				}
			}
		case LBRACKET:
			consume();
			List<ClassifierArgument> list = new LinkedList<ClassifierArgument>();
			if(current.type != TokenType.RBRACKET){
				list.add(parseArgument(name, equals));
				while(current.type == TokenType.COMMA){
					consume();
					list.add(parseArgument(name, equals));
				}
			}
			accept(TokenType.RBRACKET);
			return new ClassifierArgumentList(name, list, equals);
		case IDENTIFIER:
			return new ClassifierArgumentString(name, consume().value, equals);
		case STRING:
			String s = consume().value;
			
			return new ClassifierArgumentString(name, s.substring(1, s.length() - 1), equals);
		case LPAREN:
			consume();
			List<ClassifierArgument> tuple = new ArrayList<ClassifierArgument>();
			if(current.type != TokenType.RPAREN){
				tuple.add(parseArgument(name, equals));
				while(current.type == TokenType.COMMA){
					consume();
					tuple.add(parseArgument(name, equals));
				}
				accept(TokenType.RPAREN);
				ClassifierArgument[] array = new ClassifierArgument[tuple.size()];
				return new ClassifierArgumentTuple(name, tuple.toArray(array), equals);
			}
		default:
			throw fail();
		}
	}
	
	public Token peek() throws ParseException{
		if(input.length() == 0){
			return new Token(TokenType.EOF, "", 0);
		}
		
		int space = 0;
		while(space < input.length() && Character.isWhitespace(input.charAt(space))){
			space++;
		}
		if(space == input.length()){
			return new Token(TokenType.EOF, "", space);
		}
		
		char first = input.charAt(space);
		
		
		switch(first){
		case '@': return new Token(TokenType.AT, "" + first, 1 + space);
		case '[': return new Token(TokenType.LBRACKET, "" + first, 1 + space);
		case ']': return new Token(TokenType.RBRACKET, "" + first, 1 + space);
		case '(' : return new Token(TokenType.LPAREN, "" + first, 1 + space);
		case ')' : return new Token(TokenType.RPAREN, "" + first, 1 + space);
		case '<': return new Token(TokenType.LT, "" + first, 1 + space);
		case '>': return new Token(TokenType.GT, "" + first, 1 + space);
		case ',': return new Token(TokenType.COMMA, "" + first, 1 + space);
		case '.': return new Token(TokenType.DOT, "" + first, 1 + space);
		case ';': return new Token(TokenType.SEMICOLON, "" + first, 1 + space);
		case '=': return new Token(TokenType.EQ, "" + first, 1 + space);
		case '!':
			if(input.length() - space > 1 && input.charAt(space + 1) == '='){
				return new Token(TokenType.NEQ, "!=", space + 2);
			}
		case '&':
			if(input.length() - space > 1 && input.charAt(space + 1) == '&'){
				return new Token(TokenType.AND, "&&", space + 2);
			}
		case '|':
			if(input.length() - space > 1 && input.charAt(space + 1) == '|'){
				return new Token(TokenType.OR, "||", space + 2);
			}
		default: 
			tokenBuilder.setLength(0);
			int current = space;
			if(Character.isDigit(first)){
				tokenBuilder.append(first);
				while(++current < input.length() && Character.isDigit(input.charAt(current))){
					tokenBuilder.append(input.charAt(current));
				}
				return new Token(TokenType.NUMBER, tokenBuilder.toString(), space + tokenBuilder.length());
			} else if(Character.isJavaIdentifierStart(first)){
				tokenBuilder.append(first);
				while(++current < input.length() && (Character.isJavaIdentifierPart(input.charAt(current)))){
					tokenBuilder.append(input.charAt(current));
				}
				return new Token(TokenType.IDENTIFIER, tokenBuilder.toString(), space + tokenBuilder.length());
			} else if(first == '\"'){
				tokenBuilder.append(first);
				while(++current < input.length() && input.charAt(current) != '\"'){
					tokenBuilder.append(input.charAt(current));
				}
				if(current == input.length()){
					throw fail("Expected character: %s, got end of file", "\"");
				}
				tokenBuilder.append(input.charAt(current - 1));
				return new Token(TokenType.STRING, tokenBuilder.toString(), space + tokenBuilder.length());
			} else{
				throw fail("Unexpected character: " + first);
			}
		}
	}
	
	private Token accept(TokenType type) throws ParseException{
		expect(type);
		return consume();
	}
	
	private Token consume() throws ParseException{
		Token result = current;
		input.delete(0, current.consumed);
		currentChar += current.consumed;
		current = peek();
		return result;
	}
	
	private void expect(TokenType type) throws ParseException{
		if(current.type != type){
			throw new ParseException(currentChar, "Expected: %s, got: %s", type, current.type);
		}
	}
	
	private ParseException fail(){
		return new ParseException(currentChar, "Unexpected token: %s", current.type);
	}
	
	private ParseException fail(String msg, Object... args){
		return new ParseException(currentChar, msg, args);
	}
	
	enum TokenType{
		AT("@"),
		LBRACKET("["),
		RBRACKET("]"),
		LPAREN("("),
		RPAREN(")"),
		LT("<"),
		GT(">"),
		EQ("="),
		NEQ("!="),
		COMMA(","),
		SEMICOLON(";"),
		AND("&&"),
		OR("||"),
		DOT("."),
		IDENTIFIER("identifier"),
		NUMBER("number"),
		STRING("string"),
		EOF("eof")
		;
		
		private String description;
		private TokenType(String description){
			this.description = description;
		}
		
		public String toString() {
			return description;
		};
	}
	
	private class Token{
		private TokenType type;
		private String value;
		private int consumed;
		public Token(TokenType type, String value, int consumed) {
			this.type = type;
			this.value = value;
			this.consumed = consumed;
		}
		@Override
		public String toString() {
			return "Token [type=" + type + ", value=" + value + ", consumed="
					+ consumed + "]";
		}
	}
	
	
}
