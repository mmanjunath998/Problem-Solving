package com.basics.graph;

import java.util.LinkedList;
import java.util.Stack;

public class AlienDictionaryTopologicalSort {

	public static void main(String[] args) {
		String[] words = {"caa", "aaa", "aab"};
		find(words);
	}



	public static void find(String[] words){
		Graph graph = new Graph(words.length);

		for(int i=0; i<words.length-1; i++){

			String word1 = words[i];
			String word2 = words[i+1];

			for(int j=0; j<Math.min(word1.length(), word2.length()); j++){

				if(word1.charAt(j) != word2.charAt(j)){
					graph.addEdge(word1.charAt(j)-'a', word2.charAt(j)-'a');
				}
			}
		}

		topologicalSort(graph);
	}

	public static void topologicalSort(Graph graph){
		Stack<Integer> sk = new Stack<>();
		boolean[] visited = new boolean[graph.adjList.length];

		int nodes = graph.adjList.length;

		for(int i=0; i<nodes; i++){

			if(!visited[i]){
				topologicalSortUtil(i, sk, visited, graph.adjList);
			}
		}
		
		while(!sk.isEmpty()){
			int val = sk.pop();
			System.out.print((char)(val+'a')+" ");
		}
	}
	
	public static void topologicalSortUtil(int currVertex, Stack<Integer> sk, boolean[] visited, LinkedList[] adjList){
		
		visited[currVertex] = true;
		LinkedList<Integer> list = adjList[currVertex];
		for(int neighbour : list){
			if(!visited[neighbour]){
				topologicalSortUtil(neighbour, sk, visited, adjList);
			}
		}
		sk.add(currVertex);
		
	}




	static class Graph{
		LinkedList<Integer>[] adjList;
		public Graph(int v){
			adjList = new LinkedList[v];

			for(int i=0; i<v; i++){
				adjList[i] = new LinkedList<>();
			}
		}

		public void addEdge(int src, int dest){
			adjList[src].add(dest);
		}
	}
}
