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

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.EditorController;

import model.CurrentSlot;
import model.Sheet;

public class XL extends JFrame implements Printable {
    private static final int ROWS = 10, COLUMNS = 8;
    private XLCounter counter;
    private StatusLabel statusLabel;
    private XLList xlList;
	private Sheet sheet;
	private ExprParser parser;

    public XL(XL oldXL, Sheet sheet) {
        this(oldXL.xlList, oldXL.counter, oldXL.parser, sheet);
    }

    public XL(XLList xlList, XLCounter counter, ExprParser parser, Sheet sheet) {
        super("Untitled-" + counter);
        this.xlList = xlList;
        this.counter = counter;
        this.parser = parser;
        statusLabel = new StatusLabel();
        CurrentSlot currentSlot = new CurrentSlot(sheet);
        xlList.add(this);
        counter.increment();
        JPanel statusPanel = new StatusPanel(statusLabel, currentSlot);
        JPanel sheetPanel = new SheetPanel(ROWS, COLUMNS, sheet, currentSlot, statusLabel);
        Editor editor = new Editor(currentSlot);
        EditorController editorcontroller = new EditorController(editor, currentSlot, statusLabel);
        editor.addKeyListener(editorcontroller);
        add(NORTH, statusPanel);
        add(CENTER, editor);
        add(SOUTH, sheetPanel);
        setJMenuBar(new XLMenuBar(this, xlList, statusLabel, sheet, currentSlot, parser));
        pack();
        setDefaultCloseOperation(XL.DISPOSE_ON_CLOSE);
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
    	ExprParser parser = new ExprParser(); 
    	Sheet sheet = new Sheet(parser);
        new XL(new XLList(), new XLCounter(), parser, sheet);
    }
}