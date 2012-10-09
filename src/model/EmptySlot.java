package model;

import util.XLException;

public class EmptySlot implements Slot{
	     
	@Override
	public double value(){
        throw new XLException("Must not refer to an empty slot.");
	}
	     
	public String representation(){
        return "";
	}
	@Override
	public String diplayValue() {
		return representation();
	}
}