package com.basics.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxFromSubArrayOfSizeK {
	
	
	public static void heapify(int[] arr, int i, int n){
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		if(left<n && arr[left] > arr[largest]){
			largest = left;
		}
		if(right<n && arr[right] > arr[largest]){
			largest = right;
		}
		if(largest != i){
			swap(arr, i, largest);
			heapify(arr, largest, n);
		}
	}

	private static void swap(int[] arr, int i, int largest) {
		int temp = arr[largest];
		arr[largest] = arr[i];
		arr[i] = temp;
	}

	public static void find(int[] arr, int k){
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i=0; i<arr.length;){
			if(deque.isEmpty()){
				deque.addLast(i++);
				if(!deque.isEmpty() && i>=k){
					System.out.println(arr[deque.peekFirst()]);
				}
			}else if(arr[i] >= arr[deque.peekLast()]){
				deque.removeLast();
			}else{
				deque.addLast(i++);
				if(!deque.isEmpty() && i>=k){
					System.out.println(arr[deque.peekFirst()]);
				}
			}
			
			if(!deque.isEmpty() && i-deque.peekFirst()+1 == k){
				deque.removeFirst();
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr = {8 ,5 ,10 ,7 ,9 ,4 ,15 ,12 ,90 ,13};
		find(arr, 4);
	}
}
