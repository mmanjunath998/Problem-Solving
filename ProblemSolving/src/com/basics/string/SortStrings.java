package com.basics.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortStrings {

	
	public static void main(String[] args) {
	
		String[] arr = {"manju","ayush","john","pratyush","shashi"};
		
		String[] arr2 = {"1", "34", "3", "98", "9", "76", "45", "4"};
		
		sort(arr);
		sort(arr2);
		sortn(arr2);
		int[] n = {1, 34, 3, 98, 9, 76, 45, 4};
		sort(n);
	}
	
	public static void sort(int[] arr){
		System.out.println(Arrays.toString(arr));
		
		for(int i=0; i<arr.length; i++){
			for(int j=i; j<arr.length; j++){
				int xy = arr[i]+arr[j];
				int yx = arr[j]+arr[i];
				if(xy>yx){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	
	public static void sortn(String[] arr){
		List<String> list = new ArrayList<>();
		for(String s : arr){
			list.add(s);
		}
		System.out.println(list);
		Collections.sort(list, new Comparator<String>() {
			
			@Override
			public int compare(String s1, String s2){
				String xy = s1+s2;
				String yx = s2+s1;
				return xy.compareTo(yx)> 0  ? -1 : 1;
			}
		});
		
		System.out.println(list);
	}
	
	
	public static void sort(String[] arr){
		System.out.println(Arrays.toString(arr));
		 int n = arr.length;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(arr[i].compareTo(arr[j]) > 0){
					String temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
