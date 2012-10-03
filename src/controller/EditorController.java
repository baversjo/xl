package controller;

import gui.Editor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.CurrentSlot;

public class EditorController implements KeyListener{
	private Editor editor;
	private CurrentSlot currentslot;
	
	public EditorController(Editor editor, CurrentSlot currentslot){
		this.editor = editor;
		this.currentslot = currentslot;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == KeyEvent.VK_ENTER) { 
			String text = editor.getText();
			currentslot.setValue(text);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
