package com.basics.tree;

public class SubtreeOfAnotherTree {
	
	public static void main(String[] args){
		
		Node node = Node.getTree2();
		Node node2 = Node.getTree2();
		System.out.println(isSub(node, node2));
	}
	
	public static boolean isSub(Node s, Node t){
		
		if(s == null){
			return false;
		}
		boolean check =  isCopy(s, t);
		boolean left  = isSub(s.left, t);
		boolean right = isSub(s.right, t);
		
		return check || left || right;
	}
	

	
	public static boolean isCopy(Node r1, Node r2){
		
		if(r1 != null && r2 != null){
			return r1.data == r2.data && isCopy(r1.left, r2.left) && isCopy(r1.right, r2.right);
		}else{
			return r1 == null && r2 == null;
		}
	}
}
