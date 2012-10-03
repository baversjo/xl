package controller;

import gui.Editor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import model.Sheet;

public class EditorController implements KeyListener{
	private Editor editor;
	private Sheet sheet;
	
	public EditorController(Editor editor, Sheet sheet){
		this.editor = editor;
		this.sheet = sheet;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == KeyEvent.VK_ENTER) { 
			String text = editor.getText();
			try {
				sheet.setValue(text);
			} catch (IOException e1) {
				System.exit(4);
				e1.printStackTrace();
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
