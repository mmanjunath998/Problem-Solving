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

public class HeightOfBT {


	public static int height(Node root){
		if(root == null){
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);

		if(left > right){
			return left + 1;
		}else{
			return right + 1;
		}
	}

	public static void main(String[] args){
		Node tree = Node.getTree();
		System.out.print("height of a binary tree is "+height(tree));
	}
}
