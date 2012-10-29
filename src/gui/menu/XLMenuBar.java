package gui.menu;

import expr.ExprParser;
import gui.StatusLabel;
import gui.XL;
import gui.XLList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import model.CurrentSlot;
import model.Sheet;

public class XLMenuBar extends JMenuBar {
    public XLMenuBar(XL xl, XLList xlList, StatusLabel statusLabel, Sheet sheet, CurrentSlot currentSlot) {
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        file.add(new PrintMenuItem(xl, statusLabel));
        file.add(new SaveMenuItem(xl, statusLabel, sheet));
        file.add(new LoadMenuItem(xl, statusLabel, sheet, currentSlot));
        file.add(new NewMenuItem(xl));
        file.add(new CloseMenuItem(xl, xlList));
        edit.add(new ClearMenuItem(currentSlot, statusLabel));
        edit.add(new ClearAllMenuItem(sheet));
        add(file);
        add(edit);
        add(new WindowMenu(xlList));
    }
}