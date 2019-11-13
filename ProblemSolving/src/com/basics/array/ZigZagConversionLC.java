package com.basics.array;
/*
 * P   A   H   N
   A P L S I I G
   Y   I   R
 */
public class ZigZagConversionLC {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		find("PAYPALHOLDS", 3);
	}
	
	
	public static void find(String s, int rows){
		int len = s.length();
		String[][] arr = new String[rows][len];
		int offset1 = 0;
		int offset2 = 0;
		int k = 0;
		while(k < len){
			
			for(int j=0; j<rows && k<len; j++){
				arr[offset1++][offset2] = String.valueOf(s.charAt(k++));
			}
			
			if(k == len){
				break;
			}
			offset1--;
			for(int j=0; j<rows-2 && k<len; j++){
				arr[--offset1][++offset2] = String.valueOf(s.charAt(k++));
			}
			offset1--;
			offset2++;
		}
		String res = "";
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[0].length; j++){
				String c = arr[i][j];
				if(c != null){
					res = res +""+ arr[i][j];
				}
			}
		}
		
		System.out.println(res);
		
	}
}
