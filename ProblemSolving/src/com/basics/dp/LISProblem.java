package com.basics.dp;

public class LISProblem {
	
	public static void main(String[] args) {
		int[] arr = {1,3,6,7,9,4,10,5,6};
		find(arr);
	}

	public static void find(int[] arr){
		int n = arr.length;
		int[] T = new int[n];
		int[] seq = new int[n];
		int size = 0;
		int start = 0;
		for(int i = 0; i<n; i++){
			T[i] = 1;
		}
		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				
				if(arr[j] < arr[i]){
					
					if(T[j]+1 > T[i]){
						T[i] = T[j]+1;
						seq[i] = j;
						
						if(T[i] > size){
							size = T[i];
							start = i;
						}
					}
				}
			}
		}
		
		System.out.println("LIS size is"+size);
		
		while(start >= 0){
			System.out.print(arr[start]+" ");
			if(start == 0){
				break;
			}
			start = seq[start];
			
		}
	}
}
