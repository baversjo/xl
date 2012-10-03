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

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.EditorController;

import model.Sheet;
import model.SheetFactory;
import model.SlotFactory;
import model.CurrentSlot;

public class XL extends JFrame implements Printable {
    private static final int ROWS = 10, COLUMNS = 8;
    private XLCounter counter;
    private StatusLabel statusLabel = new StatusLabel();
    private XLList xlList;
	private SheetFactory sheetFactory;
	private Sheet sheet;
	private CurrentSlot currentslot;

    public XL(XL oldXL) {
        this(oldXL.xlList, oldXL.counter, oldXL.sheetFactory);
    }

    public XL(XLList xlList, XLCounter counter, SheetFactory sheetFactory) {
        super("Untitled-" + counter);
        this.xlList = xlList;
        this.counter = counter;
        this.sheetFactory = sheetFactory;
        xlList.add(this);
        counter.increment();
        try {
			sheet = sheetFactory.buildEmpty();
		} catch (IOException e) {
			e.printStackTrace(); //TODO: proper error handling
			System.exit(3);
		}
        JPanel statusPanel = new StatusPanel(statusLabel, sheet);
        JPanel sheetPanel = new SheetPanel(ROWS, COLUMNS, sheet);
        currentslot = new CurrentSlot();
        Editor editor = new Editor(currentslot);
        EditorController editorcontroller = new EditorController(editor, currentslot);
        editor.addKeyListener(editorcontroller);
        add(NORTH, statusPanel);
        add(CENTER, editor);
        add(SOUTH, sheetPanel);
        setJMenuBar(new XLMenuBar(this, xlList, statusLabel, sheetFactory));
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
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
    	SheetFactory sf = new SheetFactory(new SlotFactory(new ExprParser()));
        new XL(new XLList(), new XLCounter(), sf);
    }
}