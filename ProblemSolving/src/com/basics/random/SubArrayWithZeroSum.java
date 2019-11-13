package com.basics.random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArrayWithZeroSum {

	public static void main(String[] args) {
		int[] arr = {6, 3, -1, -3, 4, -2, 2,4, 6, -12, -7};
		
		System.out.println(find3(arr));
		System.out.println("..................");
		System.out.println(find2(arr));
		
	}
	
	public static int find3(int[] arr){
		int res = 0;
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> first = new ArrayList<>();
		first.add(-1);
		map.put(0, first);
		int sum = arr[0];
		for(int i=1; i<arr.length; i++){
			sum = sum+arr[i];
			if(map.containsKey(sum)){
				List<Integer> list = map.get(sum);
				for(int val : list){
					System.out.println("found subarray at "+(val+1)+" to "+i);	
				}
				list.add(i);
				map.put(sum, list);
			}else{
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(sum, list);
			}
		}
		
		return res;
	}
	
	
	public static int find2(int[] arr){
		int res = 0;
		
		for(int i=0; i<arr.length; i++){
			int sum = arr[i];
			for(int j=i+1; j<arr.length; j++){
				sum = sum + arr[j];
				if(sum == 0){
					System.out.println("found sub array "+i+" to "+j);
					res++;
				}
			}
		}
		
		return res;
		
	}
	
	
	
	public static int find(int[] arr){
		int res = 0;
		
		for(int i=0; i<arr.length; i++){
			
			for(int j=i+1; j<arr.length; j++){
				if(sum(arr, i, j+1) == 0){
					System.out.println("found subarray from "+i+" to "+(j));
					res++;
				}
			}
		}
		return res;
	}
	
	public static int sum(int[] arr, int start, int end){
		int sum = 0;
		for(int i = start; i<end; i++){
			sum += arr[i];
		}
		return sum;
	}
}
