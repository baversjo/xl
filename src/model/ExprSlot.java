package model;

import expr.Expr;

public class ExprSlot implements Slot {
	public static int precision = 2;
	private Expr expr;
	
	public ExprSlot(Expr expr){
		this.expr = expr;
	}
	
	public String toString(){
		return expr.toString(precision);
	}

}
