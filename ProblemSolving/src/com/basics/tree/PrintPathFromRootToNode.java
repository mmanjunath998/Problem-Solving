package com.basics.tree;

import java.util.ArrayList;
import java.util.List;

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

public class PrintPathFromRootToNode {

	
	public static boolean print(Node root, int number , List<Integer> path){
		
		path.add(root.data);
		
		if( root.data == number){
			return true;
		}
		if(root.left != null && print(root.left, number, path)){
			return true;
		}
		if(root.right != null && print(root.right, number, path)){
			return true;
		}
		
		path.remove(path.size()-1);
		
		return false;
	}
	
	public static void main(String[] args){
		Node tree = Node.getTree();
		List<Integer> path = new ArrayList<>();
		print(tree, 6, path);
		path.forEach(value -> System.out.print(value+" "));
	}
}
