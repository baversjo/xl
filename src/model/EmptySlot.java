package model;

public class EmptySlot extends Slot{
	 private static EmptySlot singleton;
	     
	 protected static EmptySlot instance(){
		 if(singleton == null){
			 return (singleton = new EmptySlot());
		 }
		 else{
			 return singleton;
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