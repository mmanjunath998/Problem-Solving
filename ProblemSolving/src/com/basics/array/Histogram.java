package com.basics.array;

import java.util.Stack;

public class Histogram {


	public static int histo(int[] arr){
		int maxArea = -1;
		Stack<Integer> sk = new Stack<>();
		int i = 0;
		while(i<arr.length){

			if(sk.isEmpty() || arr[i] >= arr[sk.peek()]){
				sk.push(i++);
			}else{
				int top = sk.pop();
				int area = arr[top] * (sk.empty() ? i : i-sk.peek()-1);
				maxArea = Math.max(maxArea, area);
			}
		}

		while(!sk.isEmpty()){
			int top = sk.pop();
			int area = arr[top] * (sk.empty() ? i : i-sk.peek()-1);
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

	public static int find(int[] arr){
		int maxArea = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++){
			maxArea = Math.max(maxArea, arr[i]);
			int min = arr[i];
			for(int j=i+1; j<arr.length; j++){
				if(arr[j] < min){
					min = arr[j];
				}
				int area = min*(j+1-i);
				maxArea = Math.max(maxArea, area);
			}
		}
		return maxArea;
	}


	public static void main(String[] args){
		int[] arr = {6,2,5,4,5,1,6};
		System.out.println(find(arr));
		System.out.println(histo(arr));
	}

}
