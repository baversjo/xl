package model;

import java.io.IOException;

import expr.Environment;
import expr.ExprParser;

public class SlotFactory {
	private ExprParser exprParser;
	private Environment env;
	
	public SlotFactory(ExprParser parser, Environment env){
		this.exprParser = exprParser;
		this.env = env;
	}

	public Slot build(String slot) throws IOException {
		if(slot.charAt(0) == '#'){
			return new TextSlot(slot);
		}else{
			return new ExprSlot(exprParser.build(slot.substring(1)), env);
		}
	}
}