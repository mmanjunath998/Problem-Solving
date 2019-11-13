package com.basics.array;

import java.util.Arrays;

public class MergerTwoSortedArray {

	public static void find(int[] a, int[] b){
		int res[] = new int[a.length+b.length];
		
		int i = 0, j=0, k=0;
		
		while(i< a.length && j < b.length){
			if(a[i] < b[j] ){
				res[k++] = a[i++];
			}else{
				res[k++] = b[j++];
			}
		}
		
		while(i < a.length){
			res[k++] = a[i++];
		}
		
		while(j < b.length){
			res[k++] = b[j++];
		}
		
		
		System.out.println(Arrays.toString(res));
	}
	
	public static void main(String[] args){
		int[] a = {1,3,5};
		int[] b = {2,4,6,8,10};
		find(a, b);
	}
}
