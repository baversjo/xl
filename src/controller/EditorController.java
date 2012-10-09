package controller;

import gui.Editor;
import gui.StatusLabel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import util.XLException;

import model.CurrentSlot;
import model.Sheet;

public class EditorController implements KeyListener{
	private Editor editor;
	private CurrentSlot currentSlot;
	private StatusLabel statusLabel;
	
	public EditorController(Editor editor, CurrentSlot currentSlot, StatusLabel statusLabel){
		this.editor = editor;
		this.currentSlot = currentSlot;
		this.statusLabel = statusLabel;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == KeyEvent.VK_ENTER) { 
			try {
				currentSlot.setValue(editor.getText());
			} catch (XLException ex) {
				statusLabel.update(ex.getMessage());
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
