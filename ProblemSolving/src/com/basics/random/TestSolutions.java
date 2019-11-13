package com.basics.random;
import java.util.ArrayList;
import java.util.List;

public class TestSolutions {

	public static void main(String[] args) {
		int[] arr = {0};
		
		String s = "BAOOLLNNOLOLGBAX";
		//System.out.println(solution(s));
		System.out.println(solution(arr));
	}
	
	public static int solution(String S){
		
		int count = 0;
		String balloon  = "BALLOON";
		
		if(S.length() < balloon.length()){
			return count;
		}
		
		int m = balloon.length();
		char[] countS = new char[256];
		
		for(int i=0; i<S.length(); i++){
			countS[S.charAt(i)]++;
		}
		while(count(balloon, m, countS)){
			count++;
		}
		return count;
	}

	private static boolean count(String balloon, int m, char[] countS) {
		for(int i = 0; i<m; i++){
			if(countS[balloon.charAt(i)]-- <= 0){
				return false;
			}
		}
		return true;
	}
	
	
	
	public static int solution(int[] A){
		
		int len = 0;
		int i = 0;
		int n = A.length;
		List<Integer> visited = new ArrayList<>();
		while( i< n && i != -1){
			int val = A[i];
			if(visited.contains(val)){
				return len;
			}else{
				len++;
				i = val;
				visited.add(val);
			}
		}
		
		return len;
	}
}
