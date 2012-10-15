package gui;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import javax.swing.SwingConstants;

import model.CurrentSlot;
import model.Sheet;

import controller.SheetController;

public class SlotLabels extends GridPanel{
    private List<SlotLabel> labelList;
    private int cols;
	private StatusLabel statusLabel;

    public SlotLabels(int rows, int cols, Sheet sheet, CurrentSlot currentSlot, StatusLabel statusLabel) {
        super(rows + 1, cols);
        this.cols = cols;
        this.statusLabel = statusLabel;
        labelList = new LinkedList<SlotLabel>();
        
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        SheetController sheetcont = new SheetController(sheet,this, currentSlot, statusLabel);
        for (int row = 1; row <= rows; row++) {
            for (int col = 0; col < cols; col++) {
            	String position = locationString(row,col);
                SlotLabel label = new SlotLabel(position, sheet , currentSlot);
                label.addMouseListener(sheetcont);
                sheet.addObserver(label);
                add(label);
                labelList.add(label);
            }
        }
        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
        
    }

	public String position(SlotLabel label){
		int index = labelList.indexOf(label);
		return locationString(index/cols,index%cols);
	}
	
	
	private String locationString(int row, int col){
		return Character.toString((char) ('A' + col)) + String.valueOf(row);
	}
}
