package model;

import util.XLException;
import expr.Environment;

public class ErrorSlot implements Slot {
	
	@Override
	public double value(Environment env) {
		throw new XLException("Circular Error");
	}

	@Override
	public String diplayValue(Environment env) {
		throw new UnsupportedOperationException();
	}

}