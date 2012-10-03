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
		Sheet sheet = new Sheet(slots);
		while(sc.hasNext()){
			String line = sc.nextLine();
			String[] matches = line.split("=",2);
			if(matches.length == 2){
				slots.put(matches[0],slotFactory.build(matches[1],sheet));
			}
		}
		System.out.println(slots);
		return sheet;
	}
	public Sheet buildEmpty() throws IOException {
		return build(new Scanner(""));
	}
}