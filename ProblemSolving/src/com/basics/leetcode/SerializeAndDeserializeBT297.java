package com.basics.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.basics.tree.Node;

public class SerializeAndDeserializeBT297 {
	
	public static void main(String[] args){
		Node tree = Node.getBST();
		Node.print(tree);
		String data = serialize(tree);
		System.out.println(data);
		Node r = deserialize(data);
		Node.print(r);
		
	}

	public static String serialize(Node root){
		
		if(root == null){
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		
		serialize(root, sb);
		
		return sb.toString();
	}
	
	public static void serialize(Node root, StringBuilder sb){
		if(root == null){
			sb.append("null").append("#");
			return ;
		}
		
		sb.append(String.valueOf(root.data)).append("#");
		
		serialize(root.left, sb);
		serialize(root.right, sb);
	}
	
	public static Node deserialize(String data){
		
		Queue<String> queue = new LinkedList<>(Arrays.asList(data.split("#")));
		
		return deserialize(queue);
	}
	
	public static Node deserialize(Queue<String> queue){
		
		String curr = queue.poll();
		if(curr.equals("null")){
			return null;
		}
		
		Node node = new Node(Integer.valueOf(curr));
		node.left = deserialize(queue);
		node.right = deserialize(queue);
		
		return node;
	}
	
}
