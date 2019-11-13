package com.basics.lt;

import java.util.HashMap;
import java.util.Map;

public class UniqueuPaths62 {
	
	public static void main(String[] args){
		
		Map<String, Integer> map = new HashMap<>();
		int m = 9, n= 3;
		System.out.println(find(m, n));
		System.out.println(find(0, 0, m-1, n-1, map));
	}
	
	
	
	//Runtime: 0 ms, faster than 100.00% of Java online submissions
	public static int find(int m, int n){
		
		int[][] dp = new int[m][n];
		for(int i=0; i<m; i++){
			dp[i][0] = 1;
		}
		for(int i=0; i<n; i++){
			dp[0][i] = 1;
		}
		
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		return dp[m-1][n-1];
	}

	
	//Runtime: 3 ms, faster than 7.63% of Java online submissions
	public static int find(int i, int j, int m, int n, Map<String, Integer> map){
		
		String key = i+"|"+j;
		if(map.containsKey(key)){
			return map.get(key);
		}
		
		if(i == m && j == n){
			return 1;
		}
		
		if(i < 0 || i> m || j<0 || j> n){
			return 0;
		}
		
		int right = find(i, j+1, m, n, map);
		int down = find(i+1, j, m, n, map);
		
		map.put(key, right+down);
		return map.get(key);
	}
}
