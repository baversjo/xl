package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import model.CurrentSlot;

class ClearMenuItem extends JMenuItem implements ActionListener {
	CurrentSlot currentSlot;
    public ClearMenuItem(CurrentSlot currentSlot) {
        super("Clear");
        this.currentSlot = currentSlot;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        currentSlot.setValue("");
    }
}