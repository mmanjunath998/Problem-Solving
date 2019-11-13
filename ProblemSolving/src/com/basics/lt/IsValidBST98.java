package com.basics.lt;
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
import com.basics.tree.Node;

public class IsValidBST98 {
	
	public static void main(String[] args){
		Node tree = Node.getTree();
		System.out.println(isValid(tree, Long.MAX_VALUE, Long.MIN_VALUE));
	}

	public static boolean isValid(Node root, long max, long min){
		
		if(root == null){
			return true;
		}
		if(root.data < min || root.data > max){
			return false;
		}
		
		if(!isValid(root.left, root.data, min) || !isValid(root.right, max, root.data)){
			return false;
		}
		
		return true;
	}
	
	
}
