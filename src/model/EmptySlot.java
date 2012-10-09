package model;

public class EmptySlot implements Slot{
	     
	@Override
	public double value() {
        return 0;
	}
	     
	public String representation(){
        return "";
	}
	@Override
	public String diplayValue() {
		return representation();
	}
}