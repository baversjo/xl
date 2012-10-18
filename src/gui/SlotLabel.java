package gui;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Observable;
import java.util.Observer;
import model.CurrentSlot;
import model.Sheet;

public class SlotLabel extends ColoredLabel implements Observer{
	private String position;
	
    public SlotLabel(String position) {
        super("                   ", Color.WHITE, RIGHT);
        this.position = position;
        this.setHorizontalAlignment(LEFT);
    }
    
	public void update(Observable o, Object arg) {
		try {
			 Method update = getClass().getMethod("update", o.getClass(), Object.class);
			update.invoke(this, o, arg);
		} catch (Exception e) { 
			e.printStackTrace();
			System.exit(15);
		}
	}
		
	public void update(Sheet sheet, Object arg){
		setText(sheet.displayValue(position));
	}
	
	public void update(CurrentSlot currentSlot, Object arg){
		updateLocation(currentSlot);
	}
	
	private void updateLocation(CurrentSlot currentSlot){
		Color c = Color.white;
		if(currentSlot.location().equals(position)){
			c = Color.yellow;
		}
		setBackground(c);
	}
	
	public String toString(){
		return position;
	}
	
}