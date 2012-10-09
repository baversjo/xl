package gui.menu;

import expr.ExprParser;
import gui.XL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import model.Sheet;

class NewMenuItem extends JMenuItem implements ActionListener {
    private XL xl;
	private ExprParser parser;

    public NewMenuItem(XL xl, ExprParser parser) {
        super("New");
        this.parser = parser;
        this.xl = xl;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
    	new XL(xl, new Sheet(parser));
    }
}