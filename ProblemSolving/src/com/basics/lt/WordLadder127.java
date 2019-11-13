package com.basics.lt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder127 {

	static class Node{
		String word;
		int dist;
		public Node(String word, int dist){
			this.word = word;
			this.dist = dist;

		}
	}


	public static void main(String[] args){
		String[] words = {"hot","dot","dog","lot","log","cog"};
		String begin = "hit";
		String end = "cog";
		System.out.println(ladderLength(begin, end, words));


	}
	
	
	
public static int ladderLength(String beginWord, String endWord, String[] wordList) {
        
        Queue<Node> q = new LinkedList<>();
        List<String> visited = new ArrayList<>();
        q.add(new Node(beginWord, 1));
        
        while(!q.isEmpty()){
            
            Node node = q.poll();
            if(node.word.equals(endWord)){
                return node.dist;
            }
            
            List<String> oneAways = getOneAway(wordList, node.word, visited);
            
            for(String oneAway : oneAways){
                q.add(new Node(oneAway, node.dist+1));
            }
            
        }
        
        return 0;
    }
    
    public static  List<String> getOneAway(String[] words, String start, List<String> visited){
        
        List<String> result = new ArrayList<>();
       
        
        for(String word : words){
        	 int i = 0, j = 0;
             int count = 0;
            while(i<word.length() && j<start.length()){
                if(word.charAt(i) != start.charAt(j)){
                    count++;
                }
                i++;
                j++;
            }
            
            if(count == 1 && !visited.contains(word)){
                visited.add(word);
                result.add(word);
            }
        }
        
        return result;
    }

	public static int find(String[] words, String beginWord, String endWord){

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(beginWord, 1));
		List<String> visited = new ArrayList<>();
		while(!q.isEmpty()){

			Node node = q.poll();

			if(node.word.equals(endWord)){
				return node.dist;
			}

			List<String> oneAways = getOneCharAway(words, node.word, visited);

			for(String oneAway : oneAways){
				q.add(new Node(oneAway, node.dist+1));	
			}

		}
		return 0;
	}

	private static List<String> getOneCharAway(String[] words, String start, List<String> visited) {
		List<String> result = new ArrayList<>();
		for(String word : words){
			int count = 0;
			int i = 0, j=0;
			while(i < word.length() && j< start.length()){
				if(word.charAt(i) != start.charAt(j)){
					count++;
				}
				i++;
				j++;
			}
			if(count == 1 && !visited.contains(word)){
				visited.add(word);
				result.add(word);
			}

		}
		return result;
	}


}
