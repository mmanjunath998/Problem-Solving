package com.basics.array;

public class MaxSumSubMatrix {

	
	public static void main(String[] args){
		int[][] arr = 
				{{1, 2, -1, -4, -20},  
				{-8, -3, 4, 2, 1},  
                {3, 8, 10, 1, 3},  
                {-4, -1, 1, 7, -6}};
		
		find(arr);
	}
	
	
	public static int[] kadene(int[] arr){
		int[] res = {Integer.MIN_VALUE, -1, -1};
		int max = 0 , maxTill = 0;
		for(int i=0; i<arr.length; i++){
			maxTill = maxTill + arr[i];
			if(maxTill > max){
				max = maxTill;
				res[2] = i;
				res[0] = max;
			}
			if(maxTill < 0){
				maxTill = 0;
				res[1] = i+1;
			}
		}
		return res;
	}
	
	public static void find(int[][] arr){
		
		int row = arr.length;
		int col = arr[0].length;
		int top = 0;
		int left = 0;
		int bottom = 0;
		int right = 0;
		int max = 0;
		for(int leftCol = 0; leftCol < col; leftCol++){
			int[] temp = new int[row];
			for(int rightCol = leftCol; rightCol<col; rightCol++){
				
				for(int i =0; i<row; i++){
					temp[i] = temp[i] + arr[i][rightCol];
				}
				int[] res = kadene(temp);
				if(res[0] > max){
					max = res[0];
					left = leftCol;
					top = res[1];
					right = rightCol;
					bottom = res[2];
				}
			}
		}
		
		System.out.println("max "+max+"top left:"+top+" : "+left+"bottom right"+bottom+" : "+right);
	}
	
}
