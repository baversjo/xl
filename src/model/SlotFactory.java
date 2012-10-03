package model;

import java.io.IOException;

import expr.Environment;
import expr.ExprParser;

public class SlotFactory {
	private ExprParser exprParser;
	
	public SlotFactory(ExprParser exprParser){
		this.exprParser = exprParser;
	}

	public SlotValue build(String slotString, Environment env) throws IOException {
		SlotValue slotValue;
		if(slotString.charAt(0) == '#'){
			slotValue = new TextValue(slotString.substring(1));
		}else{
			slotValue = new ExprValue(exprParser.build(slotString), env);
		}
		System.out.println(slotString + ": " + slotValue);
		return slotValue;
	}
}