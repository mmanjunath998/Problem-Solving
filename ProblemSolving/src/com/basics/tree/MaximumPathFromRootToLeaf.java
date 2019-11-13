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
public class MaximumPathFromRootToLeaf {
	
	
	static int maxSum = Integer.MIN_VALUE;
	static Node targetNode = null;
	
	public static void main(String[] args) {
		Node tree = Node.getTree();
		findPath(tree, 0);
		System.out.println(maxSum);
		System.out.println("..................");
		printPath(targetNode, tree);
	}
	
	public static void findPath(Node root, int currSum){
		
		if(root == null){
			return;
		}
		currSum  = currSum+root.data;
		
		if(root.left == null && root.right == null){
			if(maxSum < currSum){
				maxSum = currSum;
				targetNode = root;
			}
		}
		findPath(root.left, currSum);
		findPath(root.right, currSum);
	}

	public static boolean printPath(Node targetNode, Node root){
		if(root == null){
			return false;
		}
		
		if(root == targetNode || 
			printPath(targetNode, root.left) || 
			printPath(targetNode, root.right) ){
			
			System.out.println(root.data);
			return true;
		}
		
		return false;
	}
}
