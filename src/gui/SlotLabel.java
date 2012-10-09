package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.CurrentSlot;
import model.Sheet;

public class SlotLabel extends ColoredLabel implements Observer{
	private String position;
	private Sheet sheet;
	private CurrentSlot currentSlot;
    public SlotLabel(String position, Sheet sheet, CurrentSlot currentSlot) {
        super("                   ", Color.WHITE, RIGHT);
        this.position = position;
        this.sheet = sheet;
        this.currentSlot = currentSlot;
        currentSlot.addObserver(this);
        this.setHorizontalAlignment(LEFT);
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		update();
		
	}
	
	public String toString(){
		return position;
	}
	
	private void update(){
		setText(sheet.displayValue(position));
		Color c = Color.white;
		if(currentSlot.location().equals(position)){
			c = Color.yellow;
		}
		setBackground(c);
	}
    
}