package model;

public class EmptyValue extends SlotValue{
	private static EmptyValue singleton;
	
	protected static EmptyValue instance(){
		if(singleton == null){
			return singleton;
		}
		else{
			return (singleton = new EmptyValue());
		}
	}
	@Override
	public double value() throws Exception {
		return 0;
	}
	
	public String toString(){
		return "";
	}
	
}
