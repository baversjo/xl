package model;

import java.util.Observable;

public class CurrentSlot extends Observable{
	private Slot slot;
	
	public CurrentSlot(Slot slot){
		this.slot = slot;
	}

	public void set(Slot slot){
		this.slot = slot;
		setChanged();
		notifyObservers();

	}
	
	public String value(){
		return slot.value();
	}
	public String location(){
		return slot.location();
	}
}
