package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.CurrentSlot;
import model.Sheet;

public class CurrentLabel extends ColoredLabel implements Observer {
	private CurrentSlot current;

    public CurrentLabel(CurrentSlot current) {
        super("", Color.WHITE);
        this.current = current;
        update();
        current.addObserver(this);
     }


	@Override
	public void update(Observable arg0, Object arg1) {
		update();
	}
	
	private void update(){
		setText(current.location());
	}
}
