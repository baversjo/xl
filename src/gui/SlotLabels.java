package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;

import model.Sheet;

import controller.SheetController;

public class SlotLabels extends GridPanel implements Observer{
    private List<SlotLabel> labelList;
    private Sheet sheet;
    private int cols;

    public SlotLabels(int rows, int cols, Sheet sheet) {
        super(rows + 1, cols);
        this.cols = cols;
        this.sheet = sheet;
        labelList = new LinkedList<SlotLabel>();
        sheet.addObserver(this);
        
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        SheetController sheetcont = new SheetController(sheet,this);
        for (int row = 1; row <= rows; row++) {
            for (int col = 0; col < cols; col++) {
            	String position = locationString(row,col);
                SlotLabel label = new SlotLabel(sheet.get(position),position);
                label.addMouseListener(sheetcont);
                add(label);
                labelList.add(label);
            }
        }
        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
        
    }

	@Override
	public void update(Observable o, Object arg) {
		Iterator<SlotLabel> itr = labelList.iterator();
		int i=0;
		while(itr.hasNext()){
			SlotLabel label = itr.next();
			label.update(sheet.get(locationString(i/cols,i%cols)));
			i++;
		}
	}

	public String position(SlotLabel label){
		int index = labelList.indexOf(label);
		return locationString(index/cols,index%cols);
	}
	
	
	private String locationString(int row, int col){
		return String.valueOf('A' + col) +  String.valueOf(col);
	}
}
