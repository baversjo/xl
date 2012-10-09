package gui.menu;

import gui.XL;
import gui.XLCounter;
import gui.XLList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import model.Sheet;
import model.SlotFactory;

class NewMenuItem extends JMenuItem implements ActionListener {
    private XL xl;
	private SlotFactory slotFactory;

    public NewMenuItem(XL xl, SlotFactory slotfactory) {
        super("New");
        this.slotFactory = slotfactory;
        this.xl = xl;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
    	new XL(xl, new Sheet(slotFactory));
    }
}