package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFileChooser;

import model.CurrentSlot;
import model.Sheet;
import model.Slot;
import model.SlotFactory;
import model.XLBufferedReader;

class LoadMenuItem extends OpenMenuItem {
 
    private SlotFactory slotFactory;
    private Sheet sheet;
	private CurrentSlot currentSlot;

	public LoadMenuItem(XL xl, StatusLabel statusLabel, SlotFactory slotFactory, Sheet sheet, CurrentSlot currentSlot) {
        super(xl, statusLabel, "Load");
        this.sheet = sheet;
        this.slotFactory = slotFactory;
        this.currentSlot = currentSlot;
    }

    protected void action(String path) throws FileNotFoundException {
    	XLBufferedReader br = null;
    	try{
    	br = new XLBufferedReader(path);
    	}catch (Exception e){
    		super.statusLabel.setText("Could not load file! (" + e.getMessage() + ")");
    	}
    	HashMap<String, Slot> slots = new HashMap<String,Slot>();
    	br.load(slots, slotFactory, sheet);
    	sheet.changed(slots);
    	currentSlot.reset();

    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}