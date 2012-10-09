package model;


public class EmptySlot implements Slot{
	     
	@Override
	public double value(){
        throw new XLEmptySlotException("Must not refer to an empty slot.");
	}
	     
	public String toString(){
        return "";
	}
	@Override
	public String diplayValue() {
		return toString();
	}
}