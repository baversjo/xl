package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Slot;

public class SlotLabel extends ColoredLabel implements Observer  {
	private Slot slot;
	private String position;
    public SlotLabel(Slot slot, String position) {
        super(slot.toString(), Color.WHITE, RIGHT);
        this.slot = slot;
        this.position = position;
    }
	@Override
	public void update(Observable arg0, Object arg1) {
		setText(slot.toString());
	}
	public String position() {
		return position;
	}
    
}