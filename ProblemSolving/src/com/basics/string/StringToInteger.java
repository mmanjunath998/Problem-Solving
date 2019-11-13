package com.basics.string;

public class StringToInteger {

	public static void main(String[] args){
		String s = "+-2";
		System.out.println(myAtoi(s));
	
	}
	
	 public static int myAtoi(String str) {
	        if(str == null || str.isEmpty()){
	            return 0;
	        }
	        str = str.trim();
	        String[] arr = str.split(" ");
	        boolean isNegetive = false;
	        try{
	            String temp = "";
	            char[] cr = arr[0].toCharArray();
	            isNegetive  = cr[0] == '-' ? true : false;
	            
	            for(char c : cr){
	    
	                if(Character.isDigit(c)){
	                 temp = temp+String.valueOf(c);
	                }else if(c == '-' || c == '+'){
	                	temp = temp+String.valueOf(c);
	                }else{
	                	break;
	                }
	            }
	            if(temp == "" || temp.equals("+")|| temp.equals("-") || temp.substring(0, 2).equals("+-") || temp.substring(0, 2).equals("-+")){
	            	return 0;
	            }
	            long l = Long.parseLong(temp);
	            if(l > Integer.MAX_VALUE){
	                return Integer.MAX_VALUE;
	            }
	            if(l < Integer.MIN_VALUE){
	                return Integer.MIN_VALUE;
	            }
	            int i = Integer.parseInt(temp);
	            return i;
	            
	        }catch(NumberFormatException e){
	           if(isNegetive){
	        	   return Integer.MIN_VALUE;
	           }else{
	        	   return Integer.MAX_VALUE;
	           }
	        }
	    }
}
