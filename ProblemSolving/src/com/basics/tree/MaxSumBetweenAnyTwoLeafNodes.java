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

public class MaxSumBetweenAnyTwoLeafNodes {
	static int maxSum = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Node tree = Node.getTree();
		System.out.println(find(tree));
		System.out.println(maxSum);
	}
	
	
	public static int find(Node root){
		
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return root.data;
		}
		
		int ls = find(root.left);
		int rs = find(root.right);
		
		if(root.left != null && root.right != null){
			maxSum = Math.max(maxSum, ls+rs+root.data);
			return Math.max(ls+root.data, rs+root.data);
		}

		return root.left == null ? rs+root.data : ls+root.data;
	}
}
