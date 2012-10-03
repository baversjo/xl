package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Slot;

public class SlotLabel extends ColoredLabel {
    public SlotLabel(Slot slot, String position) {
        super("", Color.WHITE, RIGHT);
        update(slot);
    }
	
	public void update(Slot slot){
		setText(slot.toString());
	}
    
}