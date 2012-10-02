package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;

public class CurrentLabel extends ColoredLabel implements Observer {
	private Sheet sheet;

    public CurrentLabel(Sheet sheet) {
        super("", Color.WHITE);
     }


	@Override
	public void update(Observable arg0, Object arg1) {
		setText(sheet.currentLocation());
	}
}
