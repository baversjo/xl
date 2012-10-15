package gui.menu;

import gui.StatusLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import model.CurrentSlot;

class ClearMenuItem extends JMenuItem implements ActionListener {
	private CurrentSlot currentSlot;
	private StatusLabel statusLabel;
    public ClearMenuItem(CurrentSlot currentSlot, StatusLabel statusLabel) {
        super("Clear");
        this.currentSlot = currentSlot;
        this.statusLabel = statusLabel;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	try{
    		currentSlot.setValue("");
    	}catch(Exception ex){
    		statusLabel.setText(ex.getMessage());
    	}
    }
}