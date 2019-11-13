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
public class LCA {

	public static Node find(Node root, int n1, int n2){

		if(root == null){
			return null;
		}
		if(root.data == n1 || root.data == n2){
			return root;
		}

		Node left = find(root.left, n1,  n2);
		Node right = find(root.right , n1, n2);
		if(left != null && right != null){
			return root;
		}
		if(left != null){
			return left;
		}else{
			return right;
		}
	}

	public static void main(String[] args){
		Node tree = Node.getTree();
		System.out.println(find(tree, 6, 20).data);
	}
}
