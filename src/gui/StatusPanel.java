package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import model.CurrentSlot;
import model.Sheet;

public class StatusPanel extends BorderPanel {
    protected StatusPanel(StatusLabel statusLabel, CurrentSlot currentSlot) {
        add(WEST, new CurrentLabel(currentSlot));
        add(CENTER, statusLabel);
    }
}