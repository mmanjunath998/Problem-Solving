package com.basics.array;

import java.util.PriorityQueue;

//4 2 7 6 9
public class MinimumCostRope {
	
	public static void main(String[] args) {
		int[] arr = {4 ,3 ,2 ,6};
		System.out.println(find(arr));
	}

	public static int find(int[] nums){
		
		int res = 0;
		PriorityQueue<Integer> pq  = new PriorityQueue<>();
		
		for(int num : nums){
			pq.add(num);
		}
		
		while(!pq.isEmpty() && pq.size() >= 2){
			int num1 = pq.poll();
			int num2 = pq.poll();
			
			int sum = num1+num2;
			res += sum;
			pq.add(sum);
		}
		
		return res;
	}
}
