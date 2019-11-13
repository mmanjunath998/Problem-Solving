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
public class RightView {

	static int maxLevel = 0;
	public static void view(Node root, int level){
		if(root == null){
			return;
		}
		if(maxLevel < level){
			System.out.print(root.data+" ");
			maxLevel = level;
		}
		view(root.right, level+1);
		view(root.left, level+1);
	}
	
	public static void main(String[] args){
		Node tree = Node.getTree();
		view(tree, 1);
	}
}
