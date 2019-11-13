package com.basics.array;

import java.util.Arrays;

public class MaximumSumRectangleInMatrix {
	
	public static void main(String[] args){
		int[][] arr = 
				{{1, 2, -1, -4, -20},  
				{-8, -3, 4, 2, 1},  
                {3, 8, 10, 1, 3},  
                {-4, -1, 1, 7, -6}};
		
		find(arr);
	}
	
	

	public static int[] kadene(int[] arr){
		int[] res = {Integer.MIN_VALUE, 0, -1};
		
		int maxSoFar = 0;
		int max = 0;
		for(int i=0; i<arr.length; i++){
			maxSoFar = maxSoFar + arr[i];
			if(maxSoFar > max){
				max = maxSoFar;
				res[0] = max;
				res[2] = i;
			}
			if(maxSoFar < 0){
				maxSoFar = 0;
				res[1] = i+1;
			}
		}
		
		System.out.println("array "+Arrays.toString(arr));
		System.out.println("kadens res "+Arrays.toString(res));
		return res;
	}
	
	
	public static void find(int[][] arr){
		
		int row = arr.length;
		int col = arr[0].length;
		int left = 0;
		int right = 0;
		int top = 0;
		int bottom = 0;
		int maxRes = 0;
		for(int leftCol = 0; leftCol < col; leftCol++){
			int[] temp = new int[row];
			for(int rightCol = leftCol;rightCol < col; rightCol++){
				
				for(int i=0; i<row; i++){
					temp[i] = temp[i] + arr[i][rightCol];
				}
				
				int[] res = kadene(temp);
				if(res[0] > maxRes){
					
					maxRes = res[0];
					left = leftCol;
					top = res[1];
					right = rightCol;
					bottom = res[2];
				}
			}
		}
		
		System.out.println("max sub array sum is"+maxRes);
		System.out.println("sub array top left"+top+""+left);
		System.out.println("sub array bottom right"+bottom+""+right);
	}
	
	
}
