package model;

import java.io.IOException;

import util.XLException;

import expr.Environment;
import expr.ExprParser;

public class SlotFactory {
	private ExprParser exprParser;
	
	public SlotFactory(ExprParser exprParser){
		this.exprParser = exprParser;
	}

	public Slot build(String slotString, Environment env) throws XLException {
		Slot slot;
		if(slotString.charAt(0) == '#'){
			slot = new TextSlot(slotString.substring(1));
		}else{
			try{
				slot = new ExprSlot(exprParser.build(slotString), env);
			}catch(IOException ex){
				throw new XLException("Invalid expression.");
			}
		}
		return slot;
	}
}