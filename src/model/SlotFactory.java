package model;

import expr.ExprParser;

public class SlotFactory {
	
	private static ExprParser exprParser = new ExprParser();
	
	public Slot build(String expr){
		if(expr.length() == 0){
			return null;
			
		}
		if(expr.charAt(0) == '#'){
			return new TextSlot(expr.substring(1));
		}else{
			return new ExprSlot(expr, exprParser);
		}
		
		
	}
}
