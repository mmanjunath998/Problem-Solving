package com.basics.backtrack;

import java.util.ArrayList;
import java.util.List;

public class DiceCombination {
	
	public static void main(String[] args){
		List<Integer> res = new ArrayList<Integer>();
		solve(6, 6, 2, res, 1);
	}

	
	public static void solve(int faces, int sum, int throwChances, List<Integer> res, int value){
		
		res.add(value);
		if(sum == 0 && throwChances == 0){
			System.out.println(res);
			res.remove(res.size()-1);
			return;
		}
		if((sum == 0 && throwChances>0) || (sum>0 && throwChances ==0)){
			return;
		}
		
		for(int i=value; i<=faces; i++){
			solve(faces, sum-i, throwChances-1, res, i+1);
			res.remove(res.size()-1);
			
		}
		return;
	}
}
