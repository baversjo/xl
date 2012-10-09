package model;

import util.XLException;

public class EmptySlot implements Slot{
	     
	@Override
	public double value(){
        throw new XLException("Must not refer to an empty slot.");
	}
	     
	public String toString(){
        return "";
	}
	@Override
	public String diplayValue() {
		return toString();
	}
}