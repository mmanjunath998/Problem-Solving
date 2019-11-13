package com.basics.graph;

import java.util.LinkedList;
import java.util.Stack;

import com.basics.graph.GraphaTraversal.Graph;

public class TopologicalSorting {

	static class Graph{
		int v;
		LinkedList<Integer>[] adj ;
		public Graph(int v){
			this.v = v;
			adj = new LinkedList[v];
			for(int i=0; i<v; i++){
				adj[i] = new LinkedList<Integer>();
			}
		}
		
		public void addEdge(int src, int dest){
			if(src >= v){
				System.out.println("invalid vertex");
				return;
			}
			adj[src].add(dest);
		}
		
		
		public void topologicalSort(int v, boolean[] visited, Stack<Integer> sk){
			
			visited[v] = true;
			LinkedList<Integer> childs = adj[v];
			for(int child : childs){
				if(!visited[child]){
					topologicalSort(child, visited, sk);
				}
			}
			sk.push(v);
		}
		
		
		public void tps(){
			boolean[] visited = new boolean[v];
			Stack<Integer> sk = new Stack<Integer>();
			for(int i=0; i<v; i++){
				if(!visited[i]){
					topologicalSort(i, visited, sk);
				}
			}
			
			while(!sk.isEmpty()){
				System.out.print(sk.pop()+" ");
			}
		}
		
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(5, 2); 
	    g.addEdge(5, 0); 
	    g.addEdge(4, 0); 
	    g.addEdge(4, 1); 
	    g.addEdge(2, 3); 
	    g.addEdge(3, 1); 
		g.tps();
		
	}
}
