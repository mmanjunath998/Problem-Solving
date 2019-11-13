package com.basics.array;

import java.util.Arrays;

public class NumberOfPlatformsNeededForTrain {
	
	public static void main(String[] args) {
		int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
	    System.out.println(find(arr, dep));
	    
	    
	}

	public static int find(int[] arrival , int[] departure){
		
		Arrays.sort(arrival);
		Arrays.sort(departure);
		
		int i=0, j= 0;
		int platformsNeeded = 0;
		int res = 0;
		while(i<arrival.length && j<departure.length){
			if(arrival[i] < departure[j]){
				platformsNeeded++;
				i++;
				if(platformsNeeded > res){
					res = platformsNeeded;
				}
			}else{
				platformsNeeded--;
				j++;
			}
		}
		
		return res;
	}
}
