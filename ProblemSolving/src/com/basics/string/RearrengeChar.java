package com.basics.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class RearrengeChar {

	public static void main(String[] args){

		String str = "aabaaaaa";
		System.out.println(str);
		//find1(str);
		String s = find3(str);
		System.out.println(s);

	}
	
	
	public static String find3(String str){
		
		int n = str.length();
		Map<Character, Integer> map = new HashMap<>();
		for(char c : str.toCharArray()){
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}
		
		PriorityQueue<Qdata> q = new PriorityQueue<Qdata>(Collections.reverseOrder());
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			q.add(new Qdata(entry.getValue(), entry.getKey()));
		}
		
		Qdata prev = new Qdata(-1, '#');
		String res = "";
		while(!q.isEmpty()){
			
			Qdata data = q.poll();
			res = res + data.c;
			
			if(prev.freq > 0){
				q.add(prev);
			}
			
			data.freq--;
			prev = data;
		}
		if(n  != res.length()){
			System.out.println("not possible");
			return "";
		}
		
		System.out.println(res);
		return res;
	}
	
	
	

	public static void find2(String str){

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for(char c : str.toCharArray()){
			
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}

		Queue<Qdata> q = new LinkedList<>();
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			int freq = entry.getValue();
			char c = entry.getKey();
			q.add(new Qdata(freq, c));	
		}

		String res = "";
		while(!q.isEmpty()){
			Qdata data = q.poll();
			res = res + data.c;
			data.freq = data.freq-1;
			if(data.freq > 0){
				q.add(new Qdata(data.freq, data.c));
			}
			if(!q.isEmpty() && q.peek().c == data.c){
				System.out.println("not possible");
				return;
			}
		}
		System.out.println(res);
	}

	static class Qdata implements Comparable<Qdata>{
		int freq;
		char c;
		public Qdata(int freq,  char c){
			this.freq = freq;
			this.c = c;
		}
		
		public int compareTo(Qdata d1){
			
			if(d1.freq == this.freq){
				return 0;
			}
			else if(d1.freq > this.freq){
				return -1;
			}else{
				return 1;
			}
		}
	}





	public static void find(String str){
		char[] arr = str.toCharArray();
		for(int i=0; i<str.length()-1; i++){
			if(arr[i] == arr[i+1]){
				int j = arr.length-1;
				
				while(j != i+1){
					if(arr[j] != arr[i+1]){
						break;
					}
					j--;
				}
				if(arr[j] == arr[i+1]){
					System.out.println("not possible");
					return;
				}
				char temp = arr[i+1];
				arr[i+1] = arr[j];
				arr[j] = temp;
			}	
		}
		System.out.println(String.valueOf(arr));
	}

	public static void find1(String str){
		Stack<Character> sk = new Stack<Character>();
		String res = "";
		for(int i=0; i<str.length(); i++){

			if(sk.isEmpty()){
				sk.push(str.charAt(i));
			}else if(sk.peek() == str.charAt(i)){
				sk.push(str.charAt(i));
			}else{
				char c = sk.pop();
				res  = res + c+""+str.charAt(i);
			}
		}

		if(sk.size() > 1){
			System.out.println("not possible");
		}else if(!sk.isEmpty()){
			res = res + sk.peek();
		}
		System.out.println(res);
	}


}
