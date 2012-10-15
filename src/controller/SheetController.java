package controller;

import gui.SlotLabel;
import gui.SlotLabels;
import gui.StatusLabel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.CurrentSlot;

public class SheetController implements MouseListener{
	private CurrentSlot currentSlot;
	private StatusLabel statusLabel;

	public SheetController(SlotLabels view, CurrentSlot currentSlot, StatusLabel statusLabel){
		this.currentSlot = currentSlot;
		this.statusLabel = statusLabel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		SlotLabel label = (SlotLabel)e.getSource();
		currentSlot.set(label.toString());
		statusLabel.setText("");
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
