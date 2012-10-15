package model;


public class TextSlot implements Slot {
	private String text;
	
	public TextSlot(String text){
		this.text = text;
	}
	
	public String toString(){
		return "#" + text.toString();
	}

	@Override
	public double value(){
		return 0.0;
	}

	@Override
	public String diplayValue() {
		return text;
	}
}
