package com.basics.array;

public class StockBuyAndSell {

	public static void main(String[] args){
		int[] arr = {100, 180, 260, 310, 40, 535, 695,10,20,30,40};
		int[] arr1 = {100,90,60,40,30};
		System.out.println(find(arr));
		find1(arr);
		find1(arr1);
	}
	
	public static int find(int[] arr){
		int lowIndex = -1;
		int highIndex = -1;

		int diff = 0;
		for(int i=0, j=1; j<arr.length;){
			if(arr[i] < arr[j]){
				int temp = arr[j]-arr[i];
				if(temp > diff){
					lowIndex = i;
					highIndex = j;
					diff = temp;
				}
				j++;
			}else{
				i = j;
				j++;
			}
		}
		System.out.println(arr[lowIndex]+": "+arr[highIndex]);
		return diff;
	}
	
	public static void find1(int[] arr){
		int i = 0, j = 1;
		int diff = 0;
		for(; j<arr.length;){
			
			if(arr[j] < arr[i]){
				if(i != j-1){
					diff  = arr[j-1]-arr[i];
					System.out.print("buying at "+arr[i]);
					System.out.print(" selling at "+arr[j-1]);
					System.out.println(" ==>profit "+diff);	
				}
				i=j;
				j++;
			}else{
				j++;
			}
		}
		
		if(i != arr.length-1){
			System.out.print("buying at "+arr[i]);
			System.out.print(" selling at "+arr[j-1]);
		}
	}
}
