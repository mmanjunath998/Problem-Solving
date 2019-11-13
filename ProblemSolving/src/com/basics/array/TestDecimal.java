package com.basics.array;

public class TestDecimal {

	public static void main(String[] args) {
		
		
		convert("12:45:54PM");
	}
	
	public static void convert(String s){
		int n = s.length();
		String res = s.substring(0, n-2);
		String amOrpm = s.substring(n-2, n);
		System.out.println(res);
		System.out.println(amOrpm);
		
		if(amOrpm.equals("PM")){
			String[] split = res.split(":");
			String r = "";
			for( int i=0; i<split.length; i++){
				if(i == 0){
					int values = Integer.parseInt(split[i])+12;
					r = String.valueOf(values == 24 ? 12: values);
				}else{
					r = r+":"+split[i];	
				}
				
			}
			System.out.println(r);
		}else{
			
			String[] split = res.split(":");
			String r = "";
			for( int i=0; i<split.length; i++){
				if(i == 0 && split[i].equals("12")){
					int values = Integer.parseInt(split[i])-12;
					r = String.valueOf(values);
					r = r.equals("0") ? "00":"00";
				}else{
					r = r+":"+split[i];	
				}
				
			}
			System.out.println(r);
		}
		
		
	}
}