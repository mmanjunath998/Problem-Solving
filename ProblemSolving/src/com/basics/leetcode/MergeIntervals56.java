package com.basics.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {

	
	public static void main(String[] args){
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		
		int[][] res = merge(intervals);
		
		for(int[] interval : res){
			System.out.print(Arrays.toString(interval));
		}
	}
	
	//Runtime: 37 ms, faster than 45.92% of Java online submissions
	public static int[][] merge(int[][] intervals){

		if(intervals == null || intervals.length == 0){
			return new int[0][0];
		}

		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
		List<int[]> result = new ArrayList<>();

		int[] prevInterval = intervals[0];
		for(int i=1; i<intervals.length; i++){

			int[] currInterval = intervals[i];
			if(prevInterval[1] >= currInterval[0]){
				prevInterval[1] = Math.max(prevInterval[1], currInterval[1]);
			}else{
				result.add(prevInterval);
				prevInterval = currInterval;
			}
		}
		
		if(!result.contains(prevInterval)){
			result.add(prevInterval);
		}
		return result.toArray(new int[result.size()][]);
	}
}
