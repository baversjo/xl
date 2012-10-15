package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import model.CurrentSlot;
import model.Sheet;

public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, Sheet sheet, CurrentSlot currentSlot, StatusLabel statusLabel) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, sheet, currentSlot, statusLabel));
    }
}