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
public class HasPathSum {
	
	public static void main(String[] args){
		Node root = Node.getTree();
		System.out.println(hasPathSum(root, 65));
	}

	public static boolean hasPathSum(Node root, int sum){
		if(root == null){
			return false;
		}
		
		if(root.data == sum){
			return true;
		}
		boolean left = hasPathSum(root.left, sum-root.data);
		boolean right = hasPathSum(root.right, sum-root.data);
		
		return left || right;
	}
}
