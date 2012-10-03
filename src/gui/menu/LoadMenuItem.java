package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFileChooser;

import model.Sheet;
import model.Slot;
import model.SlotFactory;
import model.XLBufferedReader;

class LoadMenuItem extends OpenMenuItem {
 
    private SlotFactory slotFactory;
    private Sheet sheet;

	public LoadMenuItem(XL xl, StatusLabel statusLabel, SlotFactory slotFactory, Sheet sheet) {
        super(xl, statusLabel, "Load");
        this.sheet = sheet;
        this.slotFactory = slotFactory;
    }

    protected void action(String path) throws FileNotFoundException {
    	XLBufferedReader br = new XLBufferedReader(path);
    	HashMap<String, Slot> slots = new HashMap<String,Slot>();
    	Sheet sheet = new Sheet(slots, slotFactory);
    	br.load(slots, slotFactory, sheet);
    	new XL(xl, sheet);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}