package com.basics.tree;
/*
 *            10
 *         /     \
 *        5       15
 *     /   \    /   \
 *    35   20   30     40
 *            /  \
 *           6    7
 *
 *
 */
public class LeftView {

	static int maxLevel = 0;
	public static void view(Node root, int level){
		if(root == null){
			return;
		}
		if(maxLevel < level){
			System.out.print(root.data+" ");
			maxLevel = level;
		}
		
		view(root.left, level+1);
		view(root.right, level+1);
		
	}
	
	static int k = 1;
	public static void printByLevel(Node root, int level){
		if(root == null){
			return ;
		}
		if(level == 1 && k == 1){
			System.out.print(root.data+" ");
			k++;
		}else if(level > 1){
			printByLevel(root.left, level-1);
			printByLevel(root.right, level-1);
		}
	}
	
	public static void leftView(Node root){
		int height = Node.height(root);
		
		for(int i = 1; i<= height; i++){
			printByLevel(root, i);
			k=1;
		}
	}
	
	public static void main(String[] args){
		Node tree = Node.getTree();
		leftView(tree);
		System.out.println(" ");
		view(tree, 1);
	}
}
