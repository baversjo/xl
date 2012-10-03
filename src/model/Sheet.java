package model;

import java.util.Map;
import java.util.Observable;

import expr.Environment;

public class Sheet extends Observable implements Environment {
	private Map<Slot, SlotValue> slotValues;
	
	public Sheet(Map<Slot, SlotValue> slotValues){
		this.slotValues = slotValues;
	}

	@Override
	public double value(String name) {
		double value = 0;
		try {
			value = slotValues.get(name).value();
		} catch (Exception e) {
			e.printStackTrace(); //TODO: correct error handling.
			System.exit(1);
		}
		return value;
	}	
}
