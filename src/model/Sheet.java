package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.Map.Entry;

import expr.Environment;

public class Sheet extends Observable implements Environment {
	private Map<String, Slot> slots;
	private String location;
	private Slot slot;
	private SlotFactory sf;
	
	public Sheet(Map<String, Slot> slots, SlotFactory sf){
		this.slots = slots;
		this.sf = sf;
		this.location = "A1";
		updateSlot();
		changed();
	}
	
	public Sheet(SlotFactory sf){
		this(new HashMap<String,Slot>(),sf);
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
		slots.put(location, slot);
		changed();
	}
	
	public String currentValue(){
		return this.slot.toString();
	}
	
	public String currentLocation(){
		return this.location;
	}
	
	
	public String displayValue(String location){
		return getSlot(location).diplayValue();
	}
	
	public void changeTo(String location){
		this.location = location;
		updateSlot();
		changed();
	}
	
	public Set<Entry<String, Slot>> entrySet(){
		return slots.entrySet();
	}
	
	public void changed(){
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
