package model;

import java.util.Map;
import java.util.Observable;

import expr.Environment;

public class Sheet extends Observable implements Environment {
	private Map<String, Slot> slots;
	private Slot current;
	private String location;
	
	public Sheet(Map<String, Slot> slots){
		this.slots = slots;
	}

	@Override
	public double value(String name) {
		double value = 0;
		try {
			value = slots.get(name).value();
		} catch (Exception e) {
			e.printStackTrace(); //TODO: correct error handling.
			System.exit(1);
		}
		return value;
	}

	public void setCurrent(String name) {
		current = slots.get(name);	
	}

	public Slot getCurrent() {
		return current;
	}

	public Slot get(String position) {
		return slots.get(position);	
	}

	public String currentLocation() {
		return location;
	}
		

	
}
