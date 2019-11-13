package com.basics.lt;

import com.basics.tree.Node;

public class SymmetricTree101 {

	public static boolean isSymmetric(Node root){
		if(root == null){
			return true;
		}
		
		return isSymmetric(root.left, root.right);
	}
	
	public static boolean isSymmetric(Node r1, Node r2){
		
		if(r1 != null && r2 != null){
			return true;
		}
		
		if(r1 == null || r2 == null){
			return false;
		}
		
		boolean left =  isSymmetric(r1.left, r2.right);
		boolean right = isSymmetric(r1.right, r2.left);
		
		return left && right;
	}
	
}
