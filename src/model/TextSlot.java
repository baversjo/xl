package model;

import util.XLException;

public class TextSlot implements Slot {
	private String text;
	
	public TextSlot(String text){
		this.text = text;
	}
	
	public String representation(){
		return "#" + text.toString();
	}

	@Override
	public double value() {
		throw new XLException("Trying to reference value of text slot.");
	}

	@Override
	public String diplayValue() {
		return text;
	}
}
