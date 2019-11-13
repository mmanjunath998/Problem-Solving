package com.basics.array;

public class MedianSortedArray {

	public static void main(String[] args){
		int[] num1 = {0,0};
		int[] num2 = {0,0};
		System.out.println(find(num1, num2));
	}
	
	public static double find(int[] num1,int[] num2){
		

		if(num1.length > num2.length){
			return find(num2,num1);
		}
		
		int x = num1.length;
		int y = num2.length;
		int low = 0;
		int high = x;
		while(low <= high){
			
			int partitionX = (low+high)/2;
			int partitionY = (x+y+1)/2-partitionX;
			
			int xMax = partitionX == x ? Integer.MAX_VALUE : num1[partitionX];
			int xMin = partitionX == 0 ? Integer.MIN_VALUE : num1[partitionX-1];
			
			int yMax = partitionY == y ? Integer.MAX_VALUE  : num2[partitionY];
			int yMin = partitionY == 0 ? Integer.MIN_VALUE : num2[partitionY-1];
			
			if(xMin <= yMax && yMin <= xMax){
				if((x+y)%2 == 0){
					return ((double) Math.max(xMin, yMin) + Math.min(xMax, yMax))/2;
				}else{
					return (double) Math.max(yMin, xMin);
				}
			}
			
			if(xMin > yMax){
				high = partitionX-1;
			}else{
				low = partitionX+1;
			}
		}
		throw new IllegalArgumentException();
	}
}
