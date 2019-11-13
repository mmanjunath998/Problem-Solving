package com.basics.leetcode;

import com.basics.tree.Node;

public class SubTreeOfAnotherTree572 {
	
	public static void main(String[] args){
		Node n1 = Node.getTree();
		Node n2 = Node.getTree();
		System.out.println(isSub(n1, n2));
	}
	
	public static boolean isSub(Node s, Node t){
		if(s == null){
			return false;
		}
		
		boolean root = isCopy(s, t);
		boolean left = isSub(s.left, t);
		boolean right = isSub(s.right, t);
		
		return root || left || right;
	}
	
	public static boolean isCopy(Node r1, Node r2){
		
		if(r1 == null && r2 == null){
			return true;
		}
		
		if((r1 != null && r2 == null) || (r1== null && r2 != null) || (r1.data != r2.data)){
			return false;
		}
		
		return isCopy(r1.left, r2.left) && isCopy(r1.right, r2.right);
	}
}
