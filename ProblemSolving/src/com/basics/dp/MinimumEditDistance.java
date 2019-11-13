package com.basics.dp;

import java.util.ArrayList;
import java.util.List;

public class MinimumEditDistance {
	//4 2 42 3 5 1
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(2);
		list.add(42);
		list.add(3);
		list.add(5);
		list.add(1);
		List<Integer> list2 = new ArrayList<>();
		list2.add(43);
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		System.out.println(solve(list, list2));
		
		
	}

	static int solve(List<Integer> list1, List<Integer> list2) {
        int row = list1.size()+1;
        int col = list2.size()+1;
        int[][] arr = new int[row][col];
        for(int i=0; i<arr.length; i++){
            arr[0][i] = i;
        }
        for(int j=0; j<arr[0].length; j++){
            arr[j][0] = j;
        }
        
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
    
                if(list1.get(i-1) == list2.get(j-1)){

                    arr[i][j] = arr[i-1][j-1];
                }else{
                    arr[i][j] = Math.min(arr[i][j-1],Math.min(arr[i-1][j-1], arr[i-1][j]))+1;
                }
                
            }
        }
        return arr[row-1][col-1];
    

    }
}
