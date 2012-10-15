package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.FileNotFoundException;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JFileChooser;

import util.XLException;

import model.CurrentSlot;
import model.Sheet;
import model.Slot;
import model.XLBufferedReader;

class LoadMenuItem extends OpenMenuItem {

    private Sheet sheet;
	private CurrentSlot currentSlot;

	public LoadMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet, CurrentSlot currentSlot) {
        super(xl, statusLabel, "Load");
        this.sheet = sheet;
        this.currentSlot = currentSlot;
    }

    protected void action(String path) throws FileNotFoundException {
    	XLBufferedReader br = null;
    	try{
    		br = new XLBufferedReader(path);
    	}catch (FileNotFoundException ex){
    		super.statusLabel.setText(ex.getMessage());
    		return;
    	}
    	Set<Entry<String, Slot>> set = sheet.entrySet();
    	sheet.reset();
    	try{
    		br.load(sheet);
    		sheet.changed();
    		currentSlot.reset();
    		super.statusLabel.setText("File loaded.");
    	}catch(XLException ex){
    		super.statusLabel.setText("Could not load file: " + ex.getMessage());
    		sheet.reset();
    		sheet.load(set);
    		sheet.changed();
    	}
    	

    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}