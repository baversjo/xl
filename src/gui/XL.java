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

import model.Sheet;
import model.SheetFactory;
import model.SlotFactory;

public class XL extends JFrame implements Printable {
    private static final int ROWS = 10, COLUMNS = 8;
    private XLCounter counter;
    private StatusLabel statusLabel = new StatusLabel();
    private XLList xlList;
	private Sheet sheet;
	private SheetFactory sheetFactory;

    public XL(XL oldXL) {
        this(oldXL.xlList, oldXL.counter, oldXL.sheetFactory);
    }

    public XL(XLList xlList, XLCounter counter, SheetFactory sheetFactory) {
        super("Untitled-" + counter);
        this.xlList = xlList;
        this.counter = counter;
        this.sheetFactory = sheetFactory;
        try {
			this.sheet = sheetFactory.buildEmpty();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(3); //TODO: error messages
		}
        xlList.add(this);
        counter.increment();
        JPanel statusPanel = new StatusPanel(statusLabel, sheet);
        JPanel sheetPanel = new SheetPanel(ROWS, COLUMNS, sheet);
        Editor editor = new Editor();
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