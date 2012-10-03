package model;

import expr.Environment;
import expr.Expr;

public class ExprValue extends SlotValue {
	public static int precision = 2;
	private Expr expr;
	private Environment env;
	
	public ExprValue(Expr expr, Environment env){
		this.expr = expr;
		this.env = env;
	}
	
	public String toString(){
		return expr.toString(precision);
	}

	@Override
	public double value() {
		return expr.value(this.env);
	}

}