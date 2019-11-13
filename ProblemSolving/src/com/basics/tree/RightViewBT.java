package com.basics.tree;

public class RightViewBT {

	static int maxLevel = -1;
	public static void print(Node root, int level){
		if(root == null){
			return;
		}
		
		if(maxLevel < level){
			maxLevel = level;
			System.out.print(root.data+" ");
		}
		print(root.right, level+1);
		print(root.left, level+1);
	}
	
	public static void main(String[] args) {
		Node node = Node.getTree();
		print(node, 0);
		
	}
}
