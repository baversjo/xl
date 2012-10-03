package controller;

import gui.SlotLabel;
import gui.SlotLabels;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import model.Sheet;

public class SheetController implements MouseListener{
	private Sheet sheet;

	public SheetController(Sheet sheet, SlotLabels view){
		this.sheet = sheet;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		SlotLabel label = (SlotLabel)e.getSource();
		sheet.changeTo(label.toString());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
