package controller;

import gui.SlotLabel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import model.Sheet;

public class SheetController implements MouseListener{
	private Sheet sheet;

	public SheetController(Sheet sheet){
		this.sheet = sheet;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		SlotLabel label = (SlotLabel) e.getSource();
		sheet.setCurrent(label.position());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
