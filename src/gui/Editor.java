package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;


import model.Sheet;

public class Editor extends JTextField implements Observer{
	private Sheet sheet;
	
    public Editor(Sheet sheet) {
        setBackground(Color.WHITE);
        this.sheet = sheet;
        sheet.addObserver(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		setText(sheet.currentValue());
	}
}