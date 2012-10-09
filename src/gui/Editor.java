package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;


import model.CurrentSlot;
import model.Sheet;

public class Editor extends JTextField implements Observer{
	private CurrentSlot currentSlot;
	
    public Editor(CurrentSlot currentSlot) {
        setBackground(Color.WHITE);
        this.currentSlot = currentSlot;
        currentSlot.addObserver(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		update();
	}
	
	private void update(){
		setText(currentSlot.representation());
	}
}