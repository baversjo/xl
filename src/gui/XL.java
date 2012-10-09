package gui;


import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import expr.ExprParser;
import gui.menu.XLMenuBar;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.EditorController;

import model.Sheet;
import model.Slot;
import model.SlotFactory;

public class XL extends JFrame implements Printable {
    private static final int ROWS = 10, COLUMNS = 8;
    private XLCounter counter;
    private StatusLabel statusLabel;
    private XLList xlList;
	private Sheet sheet;
	private SlotFactory slotFactory;

    public XL(XL oldXL, Sheet sheet) {
        this(oldXL.xlList, oldXL.counter, oldXL.slotFactory, sheet);
    }

    public XL(XLList xlList, XLCounter counter, SlotFactory slotfactory, Sheet sheet) {
        super("Untitled-" + counter);
        this.xlList = xlList;
        this.counter = counter;
        this.slotFactory = slotfactory;
        statusLabel = new StatusLabel();
        xlList.add(this);
        counter.increment();
        JPanel statusPanel = new StatusPanel(statusLabel, sheet);
        JPanel sheetPanel = new SheetPanel(ROWS, COLUMNS, sheet);
        Editor editor = new Editor(sheet);
        EditorController editorcontroller = new EditorController(editor, sheet);
        editor.addKeyListener(editorcontroller);
        add(NORTH, statusPanel);
        add(CENTER, editor);
        add(SOUTH, sheetPanel);
        setJMenuBar(new XLMenuBar(this, xlList, statusLabel, slotFactory, sheet));
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        sheet.changed();
    }

    public int print(Graphics g, PageFormat pageFormat, int page) {
        if (page > 0)
            return NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        printAll(g2d);
        return PAGE_EXISTS;
    }

    public void rename(String title) {
        setTitle(title);
        xlList.setChanged();
    }

    public static void main(String[] args) {
    	SlotFactory slotFactory = new SlotFactory(new ExprParser()); 
    	Sheet sheet = new Sheet(slotFactory);
        new XL(new XLList(), new XLCounter(), slotFactory, sheet);
    }
}