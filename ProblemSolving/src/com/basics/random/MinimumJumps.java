package com.basics.random;

public class MinimumJumps {

	public static void main(String[] args){
		int[] arr = {0 ,0, 0, 1, 0, 0};
		System.out.println(find(arr));
	}
	
	public static int find(int[] c){
		int res = 0;
		
		int j = 0;
		while(j<= c.length-1){
				
			if(j == c.length-1){
				return res;
			}
			//check for step two
			if( j< c.length-2 && c[j+2] == 0){
				j = j+2;
			}else if(j< c.length-1 && c[j+1] == 0){
				j = j+1;
			}else{
				return -1;
			}
			res++;
		}
		return res;
	}
}
