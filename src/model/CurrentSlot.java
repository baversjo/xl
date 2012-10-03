package model;

import java.io.IOException;
import java.util.Observable;

public class CurrentSlot extends Observable{
	private String location;
	private Slot slot;
	private SlotFactory sf;
	private Sheet sheet;
	
	public CurrentSlot(SlotFactory sf, Sheet sheet){
		this.sf = sf;
		this.sheet = sheet;
		this.slot = EmptySlot.instance();
	}
	
	public void setValue(String value) throws IOException{
		slot = sf.build(value, sheet);
		changed();
	}
	
	public String value(){
		return this.slot.toString();
	}
	
	public String location(){
		return this.location;
	}
	
	public void changeTo(String location, Slot slot){
		this.slot = slot;
		this.location = location;
		changed();
	}
	
	private void changed(){
		setChanged();
		notifyObservers();
	}
	
	
}
