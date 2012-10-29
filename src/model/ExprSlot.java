package model;

import java.io.IOException;

import util.XLException;

import expr.Environment;
import expr.Expr;
import expr.ExprParser;

public class ExprSlot implements Slot {
	public static int precision = 2;
	private Expr expr;
	
	public ExprSlot(String expression, ExprParser exprParser){
		try {
			this.expr =  exprParser.build(expression);
		} catch (IOException e) {
			throw new XLException(e.getMessage());
		}
	}
	
	public String toString(){
		return expr.toString(precision);
	}

	@Override
	public double value(Environment env){
		return expr.value(env);
	}

	@Override
	public String diplayValue(Environment env) {
		return String.valueOf(value(env));
	}
	
}
