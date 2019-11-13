package com.basics.backtrack;

import java.util.ArrayList;
import java.util.List;

public class ConstructWordUsingDice {
	
	public static void main(String[] args){
		char[][] arrays = {
							{'a','l','c','d','e','f'},
							{'a','b','c','d','e','f'},
							{'a','b','c','h','e','f'},
							{'a','b','c','d','o','f'},
							{'a','b','c','l','e','f'},};
		char[] pat = {'h','e','l','l','o'};
		
		char[][] arr2 = {{'a', 'b', 'c', 'd', 'e', 'f'},
				{'a', 'b', 'c', 'd', 'e', 'f'},
				{'a', 'b', 'c', 'd', 'e', 'f'},
				{'a', 'b', 'c', 'd', 'e', 'f'},
				{'a', 'b', 'c', 'd', 'e', 'f'}};
		
		
		List<Path> results = new ArrayList<Path>();
		List<Integer> visited = new ArrayList<>();
		System.out.println(find(arrays, pat, results, 0, visited));
	}

	
	public static boolean find(char[][] arrays, char[] pat, List<Path> result, int seqCount, List<Integer> visited){
		
		if(seqCount == pat.length){  //goal
			System.out.println(result);
			return true;
		}
		
		//choices
		for(int i=0; i<arrays.length; i++){
			
			char[] seq = arrays[i];
			
			for(int j=0; j<seq.length; j++){
				if(seq[j] == pat[seqCount] && !visited.contains(i)){  //constraints
						result.add(new Path(i, j));
						visited.add(i);
						if(find(arrays, pat, result, seqCount+1, visited)){
							return true;
						}
						//back track
						result.remove(result.size()-1);
						visited.remove(visited.size()-1);
				}
			}
		}
		
		return false;
	}
}
