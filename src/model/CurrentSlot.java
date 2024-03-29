package model;

import java.util.Observable;

import util.XLException;

public class CurrentSlot extends Observable{
	private String location;
	private Sheet sheet;
	
	public CurrentSlot(Sheet sheet){
		reset();
		this.sheet = sheet;
	}
	
	public void reset(){
		set("A1");
	}
	
	public String displayValue(){
		return sheet.displayValue(location);
	}
	public String representation(){
		return sheet.representation(location);
	}
	
	public String location(){
		return this.location;
	}
	
	public void set(String location){
		this.location = location;
		changed();
	}
	
	public void setValue(String value){
		try{
			sheet.setValue(location, value);
			
		}catch(XLException ex){
			throw ex;
		}
		finally{
			changed();
		}
	}
	
	
	private void changed(){
		setChanged();
		notifyObservers();
	}
}
