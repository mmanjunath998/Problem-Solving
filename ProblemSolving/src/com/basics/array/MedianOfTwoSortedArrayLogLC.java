package com.basics.array;

public class MedianOfTwoSortedArrayLogLC {

	public static double find(int[] a, int[] b){
		
		if(a.length > b.length){
		 return find(b, a);
		}
		
		int low = 0;
		int high = a.length;
		int x = a.length;
		int y = b.length;
		while(low <= high){
			int partitionX = (low+high)/2;
			int partitionY = (a.length+b.length+1)/2-partitionX;
			
			int xMin = partitionX == 0 ? Integer.MIN_VALUE : a[partitionX-1];
			int xMax = partitionX == x ? Integer.MAX_VALUE : a[partitionX];
			
			int yMin = partitionY == 0  ? Integer.MIN_VALUE : b[partitionY-1];
			int yMax = partitionY == y ? Integer.MAX_VALUE : b[partitionY];

			if(xMin <= yMax && yMin <= xMax){
				if((x+y)%2 == 0){
					return (double)(Math.max(xMin, yMin) + Math.min(xMax, yMax))/2;
				}else{
					return (double)Math.max(xMin, yMin);
				}
			}else if(xMin < yMax){
				low = partitionX+1;
			}else{
				high = partitionX-1;
			}
		}
		throw new IllegalArgumentException();
	}
	
	public static void main(String[] args) {
		int[] a = {2};
		int[] b = {};
		System.out.println(find(a, b));
	}
}
