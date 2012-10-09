package model;

import util.XLException;
import expr.Environment;
import expr.Expr;

public class ErrorSlot implements Slot {
	private Expr expr;
	private Environment env;
	
	public ErrorSlot(Expr expr, Environment env){
		this.expr = expr;
		this.env = env;
	}
	
	@Override
	public double value() {
		throw new XLException("Circular Error");
	}

	@Override
	public String diplayValue() {
		throw new UnsupportedOperationException();
	}
	
	public void check(){
		expr.value(env);
	}

}
