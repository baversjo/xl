package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SheetFactory {
	private SlotFactory slotFactory;
	public SheetFactory(SlotFactory slotFactory){
		this.slotFactory = slotFactory;
	}
	public Sheet build(Scanner sc) throws IOException{
		HashMap<String, SlotValue> slotValues = new HashMap<String,SlotValue>();
		Sheet sheet = new Sheet(slotValues);
		while(sc.hasNext()){
			String line = sc.nextLine();
			String[] matches = line.split("=",2);
			if(matches.length == 2){
				slotValues.put(matches[0],slotFactory.build(matches[1],sheet));
			}
		}
		System.out.println(slotValues);
		return sheet;
	}
	public Sheet buildEmpty() throws IOException {
		return build(new Scanner(""));
	}
}