package com.basics.string;

public class RoundOff {

	
	public static void main(String[] args) {
		int[] arr = {8,5,21,36,55,27,38,11};
		find(arr, 10);
	}
	public static void find(int[] arr, int num){
		if(num == 0){
			System.out.println("invalid input");
			return;
		}
		for(int i=0; i<arr.length; i++){
			
			int a = (arr[i]/num) * num;
			int b = a+num;
			int res = b-arr[i] <= arr[i]-a ? b : a;
			
			System.out.print(res+" ");
		}
	}
}
