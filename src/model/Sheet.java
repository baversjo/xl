package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.Map.Entry;

import util.XLException;

import expr.Environment;
import expr.Expr;
import expr.ExprParser;

public class Sheet extends Observable implements Environment {
	private Map<String, Slot> slots;
	
	private ExprParser exprParser;
	
	private static Slot emptySlot = new Slot(){
	     
		public double value(){
	       throw new XLEmptySlotException("Must not refer to an empty slot.");
		}
		     
		public String toString(){
	       return "";
		}

		public String diplayValue() {
			return toString();
		}
	};
	
	public Sheet(ExprParser exprParser){
		reset();
		this.exprParser = exprParser;
		changed();
	}

	@Override
	public double value(String name) {
		double value = 0;
		value = getSlot(name).value();
		return value;
	}
	
	public void setValue(String location, String value, boolean batch){
		if(value.length() == 0){
			slots.remove(location);
		}else{
			Slot slot;
			if(value.charAt(0) == '#'){
				slot = new TextSlot(value.substring(1));
			}else{
				Expr expr;
				try{
					expr = exprParser.build(value);
				}catch(IOException ex){
					throw new XLException("Internal error #12");
				}
				ErrorSlot test = new ErrorSlot(expr, this);
				
				Slot old = slots.get(location);
				slots.put(location, test);
				try{
					test.check();
				}
				catch(XLEmptySlotException ex){
					if(!batch){
						throw ex;
					}
				}
				catch(XLException ex){
					slots.put(location, old);
					throw ex;
				}
				slot = new ExprSlot(expr, this);
				
			}
			slots.put(location, slot);
		}
		if(!batch){
			changed();
		}
	}
	
	public void setValue(String location, String value){
		setValue(location, value, false);
	}

	public String displayValue(String location){
		return getSlot(location).diplayValue();
	}
	
	public String representation(String location){
		return getSlot(location).toString();
	}
	
	
	public Set<Entry<String, Slot>> entrySet(){
		return slots.entrySet();
	}
	
	public void changed(){
		setChanged();
		notifyObservers();
	}
	
	public void reset(){
		this.slots = new HashMap<String, Slot>();

	}
	
	public void load(Set<Entry<String, Slot>> set) {
		for(Entry<String, Slot> entry: set){
			slots.put(entry.getKey(), entry.getValue());
		}
	}
		
	private Slot getSlot(String location){
		Slot slot = slots.get(location);
		if(slot == null){
			slot = emptySlot;
		}
		return slot;
	}

}
