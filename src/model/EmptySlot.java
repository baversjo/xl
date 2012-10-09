package model;

public class EmptySlot implements Slot{
	     
	@Override
	public double value() throws Exception {
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