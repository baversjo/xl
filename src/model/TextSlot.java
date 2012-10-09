package model;

public class TextSlot implements Slot {
	private String text;
	
	public TextSlot(String text){
		this.text = text;
	}
	
	public String representation(){
		return "#" + text.toString();
	}

	@Override
	public double value() throws Exception {
		throw new Exception("Impossible");
	}

	@Override
	public String diplayValue() {
		return text;
	}
}
