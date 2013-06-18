package com.example.logginsession;

public class Util {
	public static boolean isAlphaNumeric(String s){
	    String pattern= "^[a-zA-Z0-9]*$";
	        if(s.matches(pattern)){
	            return false;
	        }
	        return true;   
	}
}
