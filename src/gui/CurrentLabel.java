package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.CurrentSlot;

public class CurrentLabel extends ColoredLabel implements Observer {
	private CurrentSlot currentSlot;

    public CurrentLabel(CurrentSlot currentSlot) {
        super("", Color.WHITE);
        currentSlot.addObserver(this);
        this.currentSlot = currentSlot;
        update();
     }


	@Override
	public void update(Observable arg0, Object arg1) {
		update();
	}
	
	private void update(){
		setText(currentSlot.location());
	}
}
