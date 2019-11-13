package com.basics.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MergeIntervals {
	
	public static void main(String[] args){
		int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
		int[][] res = merge2(arr);
		for(int[] ar : res){
			System.out.println(Arrays.toString(ar));
		}
	}
	
	
	public static int[][] merge2(int[][] arr){
		
		if(arr == null || arr.length == 0){
			return new int[0][0];
		}
		
		Arrays.sort(arr, (i1,i2) -> Integer.compare(i1[0], i2[0]));
		
		List<int[]> list =new ArrayList<>();
		
		int[] old = arr[0];
		
		for(int i=1; i<arr.length; i++){
			int[] curr = arr[i];
			if(old[1] >= curr[0]){
				old[1] = Math.max(old[1], curr[1]);
			}else{
				list.add(old);
				old = curr;
				
			}
		}
		if(!list.contains(old)){
			list.add(old);
		}
		
		return list.toArray(new int[list.size()][]);
	}

	public static List<List<Integer>> merge(int[][] arr){
		List<List<Integer>> result = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		for(int i=0; i<arr.length; i++){
			int[] possible = arr[i];
			
			for(int j=i+1; j<arr.length; j++){
				int[] test = arr[j];
				if((possible[1] >= test[0] &&   possible[1] <= test[1])){
					possible[1] = test[1] > possible[1] ? test[1] : possible[1];
					visited.add(j);
				}
                
                if((possible[0] >= test[0] &&   possible[0] <= test[1])){
					possible[0] = test[0] < possible[0] ? test[0] : possible[0];
					visited.add(j);
				}
			}
			if(!visited.contains(i)){
				result.add(Arrays.asList(possible[0], possible[1]));	
			}
			visited.add(i);
			
		}
		
		return result;
	}
}
