package com.basics.string;

public class StringPermute {
	
	public static void main(String[] args) {
		String string = "ABCD";
		permute(string.toCharArray(), 0,string.length()-1);
	}

	
	public static void permute(char[] s, int i, int n){
		if(i == n){
			System.out.println(s);
		}
		for(int j=i; j<=n; j++){
			swap(s, i, j);
			permute(s, i+1, n);
			swap(s, i, j);
		}
	}

	private static void swap(char[] arr, int i, int j) {
		
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
