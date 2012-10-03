package model;

import java.io.IOException;

import expr.Environment;
import expr.ExprParser;

public class SlotFactory {
	private ExprParser exprParser;
	
	public SlotFactory(ExprParser exprParser){
		this.exprParser = exprParser;
	}

	public Slot build(String slotString, Environment env) throws IOException {
		Slot slot;
		if(slotString.charAt(0) == '#'){
			slot = new TextSlot(slotString.substring(1));
		}else{
			slot = new ExprSlot(exprParser.build(slotString), env);
		}
		return slot;
	}
}