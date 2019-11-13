package com.basics.tree;

public class LevelOrderRecusive {
	
	public static void main(String[] args){
		Node root = Node.getTree();
		levelOrder(root);
	}

	
	public static void printLevel(Node root, int level){
		if(root == null){
			return;
		}
		if(level == 0){
			System.out.print(root.data+" ");
		}
		
		printLevel(root.left, level-1);
		printLevel(root.right, level-1);
	}
	
	public static void levelOrder(Node root){
		int height = height(root);
		
		for(int i=0; i<height; i++){
			printLevel(root, i);
			System.out.println();
		}
	}
	
	public static int height(Node root){
		if(root == null){
			return 0;
		}
		
		int left = height(root.left);
		int right = height(root.right);
		return left > right? left+1 : right+1;
	}
}
