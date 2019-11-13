package com.basics.string;

public class SmallestWindow {
	
	public static void main(String[] args){
		String str = "his is a test string";
		char[] pat = {'t','i','s','t'};
		System.out.println(find(str, pat));
	}
	
	public static String find(String str, char[] pat){
		
		String res = "";
		
		int[] strCount = new int[256];
		int[] ptrCount = new int[256];
		
		for(char c : pat){
			ptrCount[c]++;
		}
		
		int start = 0, min = Integer.MAX_VALUE;
		int count = 0;
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			strCount[c]++;
			
			if(ptrCount[c] != 0 && strCount[c] <= ptrCount[c]){
				count++;
			}
			
			if(count >= pat.length){
				
				while(ptrCount[str.charAt(start)] == 0 ||
						strCount[str.charAt(start)] > ptrCount[str.charAt(start)]){
					
					if(strCount[str.charAt(start)] > ptrCount[str.charAt(start)]){
						strCount[str.charAt(start)]--;
					}
					start++;
				}
				int minLocal = i-start+1;
				if(minLocal < min){
					min = minLocal;
					res = str.substring(start,min+start);
				}
			}
		}
		return res;
	}
	
}
