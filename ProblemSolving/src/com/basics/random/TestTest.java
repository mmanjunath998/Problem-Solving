package com.basics.random;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TestTest {

	public static void main(String[] args) {
		
		System.out.println(find("((()))()()(()))"));
		int[] ar = {12, 2, 6, 7, 11};
		System.out.println(get(ar));
	}
	
	public static String find(String str){
		
		Stack<Character> sk = new Stack<>();
		char[] arr = str.toCharArray();
		for(char c : arr){
			if(c == '('){
				sk.push(c);
			}else if(c == ')' && !sk.isEmpty()  && sk.peek() == '('){
				sk.pop();
			}else{
				sk.push(c);
			}
		}
		return String.valueOf(sk.size());
	}
	
	
	public static int get(int[] arr){
		int n = arr[0];
		
		int[][] arrInput = new int[n/2][2];
	       List<Integer> list = new ArrayList<Integer>();
	       for(int i=1; i<arr.length; i++){
	    	   list.add(arr[i]);
	       }
	       int odd = 1;
	       int even = 2;
	       for(int i=0; i<arrInput.length; i++){
	           arrInput[i][0] = odd;
	           arrInput[i][1] = even;
	           odd = odd+2;
	            even = even+2;    
	       }
	       
	       return dfs(arrInput, list);
	}
	
	
	public static int dfs(int[][] arr, List<Integer> visited){
		List<Pairs> pairs = new ArrayList<>();
		for(int i = 0; i<arr.length; i++){
			for(int j=0; j<arr[0].length; j++){
				if(!visited.contains(arr[i][j])){
					
					if(isValid(arr, i,j+1) && !visited.contains((arr[i][j+1]))){
						Pairs e = new Pairs(arr[i][j], arr[i][j+1]);
						if(isNotInPairs(pairs,e)){
							pairs.add(e);	
						}
					}
					if(isValid(arr, i,j-1) && !visited.contains((arr[i][j-1]))){
						Pairs e = new Pairs(arr[i][j], arr[i][j-1]);
						if(isNotInPairs(pairs,e)){
							pairs.add(e);	
						}
					}
					if(isValid(arr, i-1,j) && !visited.contains((arr[i-1][j]))){
						Pairs e = new Pairs(arr[i][j], arr[i-1][j]);
						if(isNotInPairs(pairs,e)){
							pairs.add(e);	
						}
					}
					if(isValid(arr, i+1,j) && !visited.contains((arr[i+1][j]))){
						Pairs e = new Pairs(arr[i][j], arr[i+1][j]);
						if(isNotInPairs(pairs,e)){
							pairs.add(e);	
						}
					}
					
				}
			}
		}
		return pairs.size();
	}

	private static boolean isNotInPairs(List<Pairs> pairs, Pairs newPair) {
	for(Pairs p : pairs){
		if(p.x == newPair.x && p.y == newPair.y ||
				p.x == newPair.y && p.y == newPair.x){
			return false;
		}
	}
		return true;
	}

	private static boolean isValid(int[][] arr, int i, int j) {
		
		return i>=0 && i<arr.length && j>=0 && j<arr[0].length;
	}
}

class Pairs{
	int x;
	int y;
	Pairs(int x, int y){
		this.x= x;
		this.y = y;
	}
}
