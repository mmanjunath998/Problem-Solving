package com.basics.array;

public class MedianOfSortedArrayLC {

	public static void main(String[] args) {
		int[] a = {1,3,5,7,9};
		int[] b = {2,4,6,8,10};
		System.out.println(find(a, b));
		System.out.println(find(a, b,0,a.length-1, 0,b.length-1));
	}
	
	public static double find(int[] arr1, int[] arr2 , int start1, int end1, int start2, int end2){
		int len = (end1-start1 + end2-start2)/2+1;
		if(len == 1){
			return (double)(arr1[start1]+arr2[start2])/2;
		}
		if(len == 2){
			return (double)(Math.max(arr1[start1], arr2[start2])+Math.min(arr1[end1], arr2[end2]))/2;
		}
		int m1 = getMedian(arr1,start1, end1,len);
		int m2 = getMedian(arr2, start2, end2,len);
		if(m1 == m2){
			return m1;
		}
		if(m1>m2){
			return find(arr1, arr2, start1, (start1+end1)/2, (start2+end2)/2+1, end2);
		}else{
			return find(arr1, arr2, (start1+end1)/2+1, end1, start2, (start2+end2)/2);
		}
		
	}
	
	public static int getMedian(int[] arr, int start, int end, int len){
		if(len % 2 == 0){
			return (arr[(start+end)/2+1]+arr[(start+end)/2])/2;
		}
		return arr[(start+end)/2];
	}
	
	 
	
	
	//O(n) solution
	public static double find(int[] a, int[] b){
		int i = 0, j = 0;
		int m1 = 0, m2 = 0;
		int size = (a.length + b.length)/2;
		int temp = (a.length + b.length);
		
		while(size >= 0 ){
			if(i<a.length && j< b.length && a[i] < b[j]){
				m2 = m1;
				m1 = a[i];
				i++;
			}else if(j< b.length){
				m2 = m1;
				m1 = b[j];
				j++;
			}
			size--;
		}
		if(temp%2 == 0){
			return (double)(m1+m2)/2;
		}else{
			return (double)m1;
		}
	}
	
	
}
