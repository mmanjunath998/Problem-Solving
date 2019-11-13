package com.basics.array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	
	
	public static List<Integer> pascalRow(int rowNum){
		List<Integer> triangleRow = new ArrayList<Integer>();
		int[] res = new int[rowNum+1];
		if(rowNum == 0){
			triangleRow.add(1);
			return triangleRow;
		}
		res[0] = 1;
		
		for(int i=1; i<=rowNum; i++){
			int prev = res[0];
			int j=1;
			for(; j<i; j++){
				int curr = res[j];
				res[j] = prev+res[j];
				prev = curr;
			}
			res[j] = 1;
		}
		
		for(int a : res){
			triangleRow.add(a);
		}
		return triangleRow;
	}
	

	public static List<List<Integer>> solve(int rowNum){
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		if(rowNum == 0){
			return triangle;
		}
		List<Integer> firstRow = new ArrayList<Integer>();
		firstRow.add(1);
		triangle.add(firstRow);

		for(int i=1; i<rowNum; i++){
			List<Integer> prevRow = triangle.get(i-1);
			List<Integer> nextRow = new ArrayList<>();
			nextRow.add(1);
			for(int j=1; j<i; j++){
				nextRow.add(prevRow.get(j-1)+prevRow.get(j));
			}
			nextRow.add(1);
			triangle.add(nextRow);
		}
		
		return triangle;
	}
	
	public static void main(String[] args){
		List<List<Integer>> triangle = solve(10);
		for(List<Integer> list : triangle){
			System.out.println(list);
		}
		
		System.out.println(pascalRow(4));
		
	}
}
