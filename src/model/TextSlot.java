package model;

import expr.Environment;


public class TextSlot implements Slot {
	private String text;
	
	public TextSlot(String text){
		this.text = text;
	}
	
	public String toString(){
		return "#" + text.toString();
	}

	@Override
	public double value(Environment env){
		return 0.0;
	}

	@Override
	public String diplayValue(Environment env) {
		return text;
	}
}
