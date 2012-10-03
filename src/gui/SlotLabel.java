package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;

public class SlotLabel extends ColoredLabel implements Observer{
	private String position;
	private Sheet sheet;
    public SlotLabel(String position, Sheet sheet) {
        super("                   ", Color.WHITE, RIGHT);
        this.position = position;
        this.sheet = sheet;
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
	}
    
}