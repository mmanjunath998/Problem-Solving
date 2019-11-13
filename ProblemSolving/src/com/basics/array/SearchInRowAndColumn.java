package com.basics.array;

//Time complexity O(m+n);


public class SearchInRowAndColumn {

	public static void main(String[] args) {
	int[][] arr  = 	{
			{10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}};
	
	find(arr, 15);
	}
	public static int find(int[][] arr, int num){
		int res = 0;
		
		int row = arr.length-1;
		int col = 0;
		
		while(row >= 0 && col<arr[0].length){
			if(arr[row][col] == num){
				System.out.println("element found at "+row+" : "+col);
				res++;
				break;
			}else if(arr[row][col] > num){
				row--;
			}else{
				col++;
			}
		}
		if(res == 0){
			System.out.println("element not found");
		}
		return res;
	}
}
