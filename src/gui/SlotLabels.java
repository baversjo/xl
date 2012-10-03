package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;

import model.Sheet;

import controller.SheetController;

public class SlotLabels extends GridPanel {
    private List<SlotLabel> labelList;

    public SlotLabels(int rows, int cols, Sheet sheet) {
        super(rows + 1, cols);
        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        SheetController sheetcont = new SheetController(sheet);
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
            	Location loc = new Location(ch,row);
                SlotLabel label = new SlotLabel(sheet.get(position),position);
                label.addMouseListener(sheetcont);
                add(label);
                labelList.add(label);
            }
        }
        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
        
    }


}
