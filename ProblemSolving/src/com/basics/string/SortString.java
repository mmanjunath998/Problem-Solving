package com.basics.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortString {

	public static void main(String[] args) {
		String[] arr  = {"manju","ayush","pratyush","shashi","george"};
		String[] arr2  = {"8","4","3","9","80","98"};
		Arrays.sort(arr2, Collections.reverseOrder());
		//sort(arr);
		System.out.println(Arrays.toString(arr2));
		//sortB(arr2);
	}
	
	
	public static void sortB(String[] arr){
		List<String> list = new ArrayList<>(Arrays.asList(arr));
		
		System.out.println(list);
			
		Comparator<String> comp = new Comparator<String>(){
			@Override
			public int compare(String s1, String s2){
				String xy = s1+s2;
				String yx = s2+s1;
				return xy.compareTo(yx) > 0  ? -1 : 1;
			}
			
		};
		Collections.sort(list, comp);
		System.out.println(list);
	}
	
	public static void sort(String[] arr){
		
		System.out.println(Arrays.toString(arr));
		for(int i=0; i<arr.length; i++){
			for(int j=i+1; j<arr.length; j++){
				String xy = arr[i]+arr[j];
				String yx = arr[j]+arr[i];
				if(xy.compareTo(yx) < 0){
					String temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
