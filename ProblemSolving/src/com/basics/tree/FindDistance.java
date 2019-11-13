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

public class FindDistance {
	
	public static void main(String[] args) {
		Node tree = Node.getTree();
		System.out.println(find(tree, 5, 30));
		System.out.println(find(tree, 35, 6));
	}
	
	
	public static int find(Node root, int a, int b){
		if(root == null){
			return 0;
		}
		if(!isNodePresent(root, a) || !isNodePresent(root, b)){
			return 0;
		}

		Node lca = lca(root, a, b);
		
		return findLevel(lca, a, 0)+findLevel(lca, b, 0);
		
	}
	
	
	public static boolean isNodePresent(Node root, int a){
		if(root == null){
			return false;
		}
		if(root.data == a){
			return true;
		}
		boolean left = isNodePresent(root.left, a);
		boolean right = isNodePresent(root.right, a);
		
		return left || right;
	}
	
	
	
	public static Node lca(Node root, int a, int b){
		if(root == null){
			return null;
		}
		if(root.data == a || root.data == b){
			return root;
		}
		Node left = lca(root.left, a, b);
		Node right = lca(root.right, a, b);
		
		if(left != null && right != null){
			return root;
		}
		return left != null ? left : right;
	}
	
	public static int findLevel(Node root, int data, int level){
		if(root == null){
			return 0;
			
		}
		if(root.data == data){
			return level;
		}
		int downLevel = findLevel(root.left, data, level+1);
		if(downLevel != 0){
			return downLevel;
		}
		downLevel = findLevel(root.right, data, level+1);
		
		return downLevel;
	}
}
