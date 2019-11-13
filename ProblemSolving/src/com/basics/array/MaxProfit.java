package com.basics.array;

import java.util.Arrays;

public class MaxProfit {
	
	public static void main(String[] args) {
		Interval[] in = {new Interval(0, 0), new Interval(1, 3), new Interval(2, 3), new Interval(3, 5)};
		int[]p = {0,2,10,5};
		find(in, p);
	}
	static class Interval{
		int s;
		int e;
		public Interval(int s, int e){
			this.s = s;
			this.e = e;
		}
	}
	
	public static void find(Interval[] intervals, int[] profit){
		int[] memo = new int[profit.length];
		memo[0] = profit[0];
		for(int i=1; i<profit.length; i++){
			
			for(int j=i-1; j>=0; j--){
				
				if(intersect(intervals[i], intervals[j])){
					memo[i] = Math.max(memo[i], profit[i]);
				}else{
					memo[i] = Math.max(memo[i], memo[j]+profit[i]);
				}
				
			}
		}
		
		System.out.println(Arrays.toString(memo));
	}

	private static boolean intersect(Interval interval, Interval interval2) {
		return interval2.s >= interval.s && interval2.e <= interval.e;
	}
	
}
