package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.Map.Entry;

import util.XLException;

import expr.Environment;

public class Sheet extends Observable implements Environment {
	private Map<String, Slot> slots;
	private Slot emptySlot;
	private SlotFactory sf;
	
	public Sheet(Map<String, Slot> slots, SlotFactory sf){
		this.slots = slots;
		this.sf = sf;
		this.emptySlot = new EmptySlot();
		changed();
	}
	
	public Sheet(SlotFactory sf){
		this(new HashMap<String,Slot>(),sf);
	}

	@Override
	public double value(String name) {
		double value = 0;
		value = getSlot(name).value();
		return value;
	}
	
	public void setValue(String location, String value){
		Slot slot = sf.build(value, this);
		if(slot == null){
			slots.remove(location);
		}
		else{
			try{
				slot.value(); // try fetching value. Will cause stack overflow if curcular.
			}
			catch(StackOverflowError ex){
				throw new XLException("Circular error.");
			}
			slots.put(location, slot);
		}
		changed();
	}

	public String displayValue(String location){
		return getSlot(location).diplayValue();
	}
	
	public String representation(String location){
		return getSlot(location).representation();
	}
	
	
	public Set<Entry<String, Slot>> entrySet(){
		return slots.entrySet();
	}
	
	public void changed(){
		setChanged();
		notifyObservers();
	}
	
	public void changed(Map<String, Slot> slots){
		this.slots = slots;
		changed();
	}
		
	private Slot getSlot(String location){
		Slot slot = slots.get(location);
		if(slot == null){
			slot = emptySlot;
		}
		return slot;
	}
}
