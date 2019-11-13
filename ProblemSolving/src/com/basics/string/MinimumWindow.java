package com.basics.string;

public class MinimumWindow {
	
	public static void main(String[] args){
		String val = "ADOBECODEBANC";
		String pat = "ABC";
		System.out.println(find(val, pat));
	}

	public static String find(String val, String pat){
		
		int[] patCount  = new int[256];
		int[] valCount = new int[256];
		
		for(int i=0; i<pat.length(); i++){
			patCount[pat.charAt(i)]++;
		}
		String res = "";
		int min = Integer.MAX_VALUE;
		int start = 0;
		int count = 0;
		for(int i=0; i<val.length(); i++){
			
			char c = val.charAt(i);
			valCount[c]++;
			
			if(patCount[c] != 0 && valCount[c] <= patCount[c]){
				count++;
			}
			
			if(count >= pat.length()){
				while(patCount[val.charAt(start)] == 0 || valCount[val.charAt(start)] > patCount[val.charAt(start)]){
					if(valCount[val.charAt(start)] > patCount[val.charAt(start)]){
						valCount[val.charAt(start)]--;
					}
					start++;
				}
				int localMin = i-start+1;
				if(localMin < min){
					localMin = min;
					res = val.substring(start, i+1);
				}
			}
		}
		return res;
	}
}
