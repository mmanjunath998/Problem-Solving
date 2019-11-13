package com.basics.graph;

import java.util.LinkedList;
import java.util.List;

public class GraphDFSandBFS {
	
	static Graph graph;
	

	static class Graph{
		int v;
		LinkedList<Integer>[] adjList;
		public Graph(int v){
			adjList = new LinkedList[v];
			for(int i=0; i<v; i++){
				adjList[i] = new LinkedList<>();
			}
		}
	}
	
	public static void dfs(int v, List<Integer> visited){
		
		visited.add(v);
		System.out.println(v);

		LinkedList<Integer> list = graph.adjList[v];
		for(int i : list){
			if(!visited.contains(i)){
				dfs(i, visited);
			}
		}
		
		
	}
	
	
}
