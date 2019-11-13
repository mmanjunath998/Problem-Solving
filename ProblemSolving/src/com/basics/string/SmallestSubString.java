package com.basics.string;

public class SmallestSubString {

	public static void main(String[] args){
		String str = "xyyyxxzxxyxyyzxyxyxyxxxyz";
		char[] arr = {'x','y','z'};
		System.out.println(find(str, arr));
	}
	
	public static String find(String str, char[] arr){
		
		String res = "";
		int n = str.length();
		int len = Integer.MAX_VALUE;
		int k = arr.length-1;
		for(int i=0; i<n-k; i++){
			for(int j=i+k; j<n; j++){
				String sub = str.substring(i,j+1);
				if(contains(sub, arr) && (j-i) < len){
					res = sub;
					len = (j-i);
				}
			}
		}
		return res;
	}
	
	
	
	public static boolean contains(String sub , char[] arr){
		int[] count = new int[256];
		for(char c : sub.toCharArray()){
			count[c]++;
		}
		for(char c : arr){
			if((count[c]--) <= 0){
				return false;
			}
		}
		return true;
	}
}
