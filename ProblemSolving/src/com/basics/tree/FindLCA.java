package com.basics.tree;

public class FindLCA {

	
	public static Node find(Node root, int n1, int n2){
		if(root == null){
			return null;
		}
		if(root.data == n1 || root.data == n2){
			return root;
		}
		Node left = find(root.left, n1, n2);
		Node right = find(root.right, n1, n2);
		if(left != null && right != null){
			return root;
		}
		
		return left != null ? left : right;
	}
	
	
	public static void main(String[] args){
		Node tree = Node.getTree();
		System.out.print(find(tree, 6, 40).data);
	}
}
