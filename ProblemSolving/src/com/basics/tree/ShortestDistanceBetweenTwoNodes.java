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
public class ShortestDistanceBetweenTwoNodes {
	
	public static void main(String[] args){
		Node root = Node.getTree();
		System.out.println(shortestDistance(root, 35, 6));
	}
	
	
	public static int shortestDistance(Node root, int a, int b){
		
		if(root == null){
			return 0;
		}
		Node lca = LCA(root, a, b);
		
		return findLevel(lca, a)+findLevel(lca,b);
	}
	
	
	public static Node LCA(Node root, int a, int b){
		
		if(root == null){
			return null;
		}
		if(root.data == a || root.data == b){
			return root;
		}
		Node left = LCA(root.left, a, b);
		Node right = LCA(root.right, a, b);
		
		if(left != null && right != null){
			return root;
		}
		
		return left != null ? left : right;
	}

	
	public static int findLevel(Node root, int node){
		
		if(root == null){
			return -1;
		}
		
		if(root.data == node){
			return 0;
		}
		
		int left = findLevel(root.left, node);
		int right = findLevel(root.right, node);
		
		if(left == -1 && right == -1){
			return -1;
		}
		if(left == -1){
			return right+1;
		}else{
			return left+1;
		}
	}
}
