package com.basics.array;

import java.util.ArrayList;
import java.util.List;

public class LisisWorkBook {
	
	public static void main(String[] args) {
		int[] arr = {4 ,2 ,6 ,1 ,10};
		System.out.println(workbook(arr.length, 3, arr));
	}

	
	static int workbook(int n, int k, int[] arr) {
		int res = 0;
		int pageNumber = 0;
		for(int i=0; i<arr.length; i++){
			int chapter = arr[i];
			pageNumber++;
			List<Integer> page = getPage(1, chapter, k);
			if(page.contains(pageNumber)){
				res++;
			}
			while(page.get(page.size()-1) != chapter){
				pageNumber++;
				page = getPage(page.get(page.size()-1)+1, chapter, k);
				if(page.contains(pageNumber)){
					res++;
				}
			}
		}
		return res;
	}
	
	public static List<Integer> getPage(int start, int end, int perPage){
		List<Integer> page = new ArrayList<Integer>();
		int count = 0;
		while(count < perPage && start <= end){
			page.add(start++);
			count++;
		}
		return page;
	}
}
