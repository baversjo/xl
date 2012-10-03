package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Slot;

public class SlotLabel extends ColoredLabel implements Observer  {
	private Slot slot;
    public SlotLabel(Slot slot) {
        super("", Color.WHITE, RIGHT);
        update();
    }
	@Override
	public void update(Observable arg0, Object arg1) {
		update();
	}

	private void update(){
		setText(slot.value());
	}
    
}