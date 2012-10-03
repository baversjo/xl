package controller;

import gui.SlotLabel;
import gui.SlotLabels;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import model.Sheet;

public class SheetController implements MouseListener{
	private Sheet sheet;
	private SlotLabels view;

	public SheetController(Sheet sheet, SlotLabels view){
		this.sheet = sheet;
		this.view = view;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		SlotLabel label = (SlotLabel) e.getSource();
		sheet.setCurrent(view.position(label));
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
