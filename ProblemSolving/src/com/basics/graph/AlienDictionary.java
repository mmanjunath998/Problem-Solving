package com.basics.graph;

import java.util.LinkedList;
import java.util.Stack;

public class AlienDictionary {

	static class Graph{
		LinkedList<Integer>[] adjList;
		public Graph(int v){
			adjList = new LinkedList[v];
			for(int i=0; i<v; i++){
				adjList[i] = new LinkedList<Integer>();
			}
		}
		
		public void addEdger(int start , int end){
			adjList[start].add(end);
		}
		
		public void topologicalSortUtil(int currentVertex, boolean[] visited, Stack<Integer> sk){
			
			visited[currentVertex] = true;
			LinkedList<Integer> linkedList = adjList[currentVertex];
			
			for(int neighbour : linkedList){
				if(!visited[neighbour]){
					topologicalSortUtil(neighbour, visited, sk);
				}
			}
			sk.add(currentVertex);
		}
		
		public void topologicalSort(){
			boolean[] visited = new boolean[adjList.length];
			Stack<Integer> sk = new Stack<Integer>();
			for(int i=0; i<adjList.length; i++){
				if(!visited[i]){
					topologicalSortUtil(i, visited, sk);	
				}
				
			}
			
			while(!sk.isEmpty()){
				int val = sk.pop();
				int c = (char)'a'+val;
				System.out.print((char)c+" ");
			}
		}
	}
	
	
	public static void find(String[] arr){
		Graph graph = new Graph(arr.length);
		
		for(int i=0; i<arr.length-1; i++){
			String s1 = arr[i];
			String s2 = arr[i+1];
			
			for(int j=0; j<Math.min(s1.length(), s2.length()); j++){
				
				if(s1.charAt(j) != s2.charAt(j)){
					graph.addEdger((int)s1.charAt(j)-'a', (int)s2.charAt(j)-'a');
				}
				
			}
		}
		
		graph.topologicalSort();
	}
	
	
	public static void main(String[] args) {
		String[] words = {"caa", "aaa", "aab"};
		find(words);
	}
}
