package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import model.Sheet;

public class StatusPanel extends BorderPanel {
    protected StatusPanel(StatusLabel statusLabel, Sheet sheet) {
        add(WEST, new CurrentLabel(sheet));
        add(CENTER, statusLabel);
    }
}