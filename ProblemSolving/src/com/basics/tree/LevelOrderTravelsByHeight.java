package com.basics.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTravelsByHeight {

	
	public static void print(Node root){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(true){
			int h = q.size();
			if(h == 0){
				break;
			}
			while(h > 0){
				Node temp = q.poll();
				System.out.print(temp.data+" ");
				if(temp.left != null){
					q.add(temp.left);
				}
				if(temp.right != null){
					q.add(temp.right);
				}
				h--;
			}
			System.out.println(" ");
		}
	}
	
	public static void main(String[] args){
		Node tree = Node.getTree();
		print(tree);
	}
}
