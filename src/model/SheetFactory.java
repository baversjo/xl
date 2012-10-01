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
		HashMap<String, Slot> slots = new HashMap<String,Slot>();
		while(sc.hasNext()){
			String line = sc.nextLine();
			String[] matches = line.split("=",1);
			if(matches.length == 2){
				slots.put(matches[0],slotFactory.build(matches[1]));
			}
		}
		return new Sheet(slots);
	}
}