package model;

import java.util.Map;

import expr.Environment;

public class Sheet implements Environment{
	private Map<String, Slot> slots;
	
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
	
	
}
