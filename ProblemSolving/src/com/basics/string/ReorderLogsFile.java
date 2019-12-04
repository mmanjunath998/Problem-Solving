package com.basics.string;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogsFile {
	public static void main(String[] args) {
		String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
		reOrder(logs);
	}

	public static String[] reOrder(String[] logs){
		
		int high = logs.length-1;
		for(int i=logs.length-1; i>=0; i--){
			String log = logs[i];
			if(Character.isDigit(log.charAt(log.indexOf(" ")+1))){
				swap(logs, i, high);
				high--;
			}
		}
		
		System.out.println(Arrays.toString(logs));
		Arrays.sort(logs, 0, high+1, new Comparator<String>(){
			
			@Override
			public int compare(String s1, String s2){
				int index1 = s1.indexOf(" ");
				int index2 = s2.indexOf(" ");
				return s1.substring(index1).compareTo(s2.substring(index2));
			}
		});
		System.out.println(Arrays.toString(logs));
		
		return logs;
	}
	
	private static void swap(String[] logs, int i, int j){
		String temp = logs[i];
		logs[i] = logs[j];
		logs[j] = temp;
	}
}
