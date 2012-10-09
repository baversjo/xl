package gui.menu;

import gui.StatusLabel;
import gui.XL;
import gui.XLList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import model.CurrentSlot;
import model.Sheet;
import model.SlotFactory;

public class XLMenuBar extends JMenuBar {
    public XLMenuBar(XL xl, XLList xlList, StatusLabel statusLabel, SlotFactory sf, Sheet sheet, CurrentSlot currentSlot) {
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        file.add(new PrintMenuItem(xl, statusLabel));
        file.add(new SaveMenuItem(xl, statusLabel, sheet));
        file.add(new LoadMenuItem(xl, statusLabel, sf, sheet, currentSlot));
        file.add(new NewMenuItem(xl,sf));
        file.add(new CloseMenuItem(xl, xlList));
        edit.add(new ClearMenuItem(currentSlot));
        edit.add(new ClearAllMenuItem());
        add(file);
        add(edit);
        add(new WindowMenu(xlList));
    }
}