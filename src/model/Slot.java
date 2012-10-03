package model;

public class Slot {
	private String loc;
	private SlotValue value;
	
	public Slot(char ch, int num, SlotValue value){
		loc = String.valueOf(ch) + String.valueOf(num);
		this.value = value;
	}
	public Slot(char ch, int num){
		new Slot(ch,num,EmptyValue.instance());
	}
	
	public int hashCode(){
		return loc.hashCode();
	}
	public boolean equals(Object other){
		return loc.equals(other);
	}
	
	public void setValue(SlotValue value){
		this.value = value;
	}
	public String value() {
		return value.toString();
	}
	public String location() {
		return loc;
	}
	public String toString(){
		return location() + ":" + value();
	}
}
