package model;

public class TextValue extends SlotValue {
	private String text;
	
	public TextValue(String text){
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
