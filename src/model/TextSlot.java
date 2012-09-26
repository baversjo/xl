package model;

public class TextSlot implements Slot {
	private String text;
	
	public TextSlot(String text){
		this.text = text;
	}
	
	public String toString(){
		return text.toString();
	}
}
