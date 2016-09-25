package services;

public class Validator {
static String reg="^[-+]?\\d+(\\.\\d+)?$";
static String reqInt="^[0-9]*[1-9][0-9]*$";
	public static  boolean validateNumber(String str){
		if(!str.matches(reg) || str.equals("")){
			return false;
		}
		return true;
	}
	
	
	public static  boolean validateInteger(String str){
		if(!str.matches(reqInt)|| str.equals("")){
			return false;
		}
		return true;
	}
	
	
}
