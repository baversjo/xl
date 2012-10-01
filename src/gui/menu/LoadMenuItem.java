package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import model.Sheet;
import model.SheetFactory;

class LoadMenuItem extends OpenMenuItem {
 
    private SheetFactory sheetFactory;

	public LoadMenuItem(XL xl, StatusLabel statusLabel, SheetFactory sheetFactory) {
        super(xl, statusLabel, "Load");
        this.sheetFactory = sheetFactory;
    }

    protected void action(String path) throws FileNotFoundException {
    	//ladda filen till stream. Felmeddelanden
    	File file = new File(path);
    	Scanner sc = new Scanner(file);
    	Sheet sheet;
        try {
			sheet = sheetFactory.build(sc);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(2);
		}
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}