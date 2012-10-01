package model;

public class TextSlot extends Slot {
	private String text;
	
	public TextSlot(String text){
		this.text = text;
	}
	
	public String toString(){
		return text.toString();
	}

	@Override
	public double value() throws Exception {
		throw new Exception("Du kan inte göra så");
	}
}
