package model;

import java.io.IOException;
import java.util.Map;
import java.util.Observable;

import expr.Environment;

public class Sheet extends Observable implements Environment {
	private Map<String, Slot> slots;
	private String location;
	private Slot slot;
	private SlotFactory sf;
	
	public Sheet(Map<String, Slot> slots, SlotFactory sf){
		this.slots = slots;
		this.sf = sf;
		updateSlot();
		changed();
	}

	@Override
	public double value(String name) {
		double value = 0;
		try {
			value = getSlot(location).value();
		} catch (Exception e) {
			e.printStackTrace(); //TODO: correct error handling.
			System.exit(1);
		}
		return value;
	}
	
	public void setValue(String value) throws IOException{
		slot = sf.build(value, this);
		changed();
	}
	
	public String currentValue(){
		return this.slot.toString();
	}
	
	public String currentLocation(){
		return this.location;
	}
	
	public void changeTo(String location){
		this.location = location;
		updateSlot();
		changed();
	}
	
	private void changed(){
		setChanged();
		notifyObservers();
	}
	
	private void updateSlot(){
		slot = getSlot(location);
	}
	
	private Slot getSlot(String location){
		Slot slot = slots.get(location);
		if(slot == null){
			slot = EmptySlot.instance();
		}
		return slot;
	}
}
