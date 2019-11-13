package com.basics.graph;

import java.util.LinkedList;
import java.util.Queue;




public class GraphaTraversal {
	
	
	static class Graph{
		int v;
		LinkedList<Integer>[] adj;
		public Graph(int v){
			this.v = v;
			adj = new LinkedList[v];
			for(int i=0; i<v; i++){
				adj[i] = new LinkedList<>();
			}
		}
		
		public void addEdge(int src, int dest){
			adj[src].add(dest);
		}
		
		public void depthFirstSearch(int v, boolean[] visited){
			visited[v] = true;
			
			System.out.print(v+" ");
			
			LinkedList<Integer> childs = adj[v];
			
			for(int child : childs){
				if(!visited[child]){
					depthFirstSearch(child, visited);
				}
			}
		}
		
		public void dfs(){
			boolean[] visited = new boolean[v];
			
			for(int i=0; i<v; i++){
				if(!visited[i]){
					depthFirstSearch(i, visited);
				}
			}
			
		}
		
		public void breadthFirstSearch(int v, boolean[] visited){
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(v);
			visited[v] = true;
			while(!q.isEmpty()){
				int vertex = q.poll();
				System.out.print(vertex+" ");
				visited[vertex] = true;
				
				LinkedList<Integer> childs = adj[v];
				for(int child : childs){
					if(!visited[child]){
						visited[child] = true;
						q.add(child);	
					}
					
				}
			}
		}
		
		public void bfs(){
			boolean[] visited = new boolean[v];
			
			for(int i=0; i<v; i++){
				if(!visited[i]){
					breadthFirstSearch(i, visited);	
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(2, 3);
		graph.addEdge(2, 1);
		graph.addEdge(3, 4);
		graph.addEdge(4, 1);
		graph.addEdge(4, 2);
		graph.addEdge(2, 4);
		graph.addEdge(1, 4);
		graph.dfs();
		System.out.println(".......");
		graph.bfs();
		
	}

}
