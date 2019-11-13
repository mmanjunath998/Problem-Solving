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
public class LevelByLevelOrder {


	public static void printByLevel(Node root , int level){
		if(root == null){
			return;
		}
		if(level == 1){
			System.out.print(root.data+" ");
		}else if(level > 1){
			printByLevel(root.left, level-1);
			printByLevel(root.right, level-1);
		}
	}

	public static void print(Node root){

		int height = height(root);
		System.out.println("height "+height);
		for(int i=1; i<= height; i++){
			printByLevel(root, i);
			System.out.println(" ");
		}
	}



	public static int height(Node root){
		if(root == null){
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);

		if(left > right){
			return left +1 ;
		}else{
			return right +1;
		}
	}

	public static void main(String[] args){
		Node tree = Node.getTree();
		print(tree);
	}
}
