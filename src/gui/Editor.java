package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.CurrentSlot;

public class Editor extends JTextField implements Observer{
	private CurrentSlot currentslot;
	
    public Editor(CurrentSlot currentslot) {
        setBackground(Color.WHITE);
        this.currentslot = currentslot;
        currentslot.addObserver(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}