package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenuItem;

import model.Sheet;
import model.Slot;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
    private Sheet sheet;

	public ClearAllMenuItem(Sheet sheet) {
        super("Clear all");
        this.sheet = sheet;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	Map<String, Slot> slots = new HashMap<String, Slot>();
        sheet.changed(slots);
    }
}