package com.basics.random;
import java.util.Arrays;

public class GetMoneySpent {

	
	public static void main(String[] args){
		 int[] keyboard = {5};
		 int[] drives = {4};
		 System.out.println(find(keyboard, drives, 5));
	}
	
	public static int find(int[] keyboard, int[] drives, int b){
		int res = 0;
		Arrays.sort(keyboard);
		Arrays.sort(drives);
		int i = keyboard.length-1;
		int j = drives.length-1;
		while(i>=0 && j>=0){
			res = keyboard[i] + drives[j];
			if(res <= b){
				return res;
			}else if(res > b && i>0 && j> 0){
				i--;
				res = keyboard[i] + drives[j];
				if(res > b){
					j--;
				}
			}else{
				return -1;
			}
			
		}
		return res;
	}
}
