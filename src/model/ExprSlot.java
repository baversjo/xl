package model;

import util.XLException;
import expr.Environment;
import expr.Expr;

public class ExprSlot implements Slot {
	public static int precision = 2;
	private Expr expr;
	private Environment env;
	
	public ExprSlot(Expr expr, Environment env){
		this.expr = expr;
		this.env = env;
	}
	
	public String representation(){
		return expr.toString(precision);
	}

	@Override
	public double value(){
		return expr.value(this.env);
	}

	@Override
	public String diplayValue() {
		return String.valueOf(value());
	}

}
