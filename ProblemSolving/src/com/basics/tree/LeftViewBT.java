package com.basics.tree;

public class LeftViewBT {

	static int maxLevel = -1;
	public static void print(Node root, int level){
		
		if(root == null){
			return;
		}
		if(maxLevel < level){
			System.out.print(root.data+" ");
			maxLevel = level;
		}
		print(root.left, level+1);
		print(root.right, level+1);
	}
	
	public static void main(String[] args){
		Node root = Node.getTree();
		print(root, 0);
	}
}
