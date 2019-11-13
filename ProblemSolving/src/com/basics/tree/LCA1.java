package com.basics.tree;

import java.util.ArrayList;
import java.util.Iterator;
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
public class LCA1 {

	public static boolean findPath(Node root, int number, List<Integer> path){
		path.add(root.data);

		if(root.data == number){
			return true;
		}
		if(root.left != null && findPath(root.left, number, path)){
			return true;
		}
		if(root.right != null && findPath(root.right, number, path)){
			return true;
		}
		
		path.remove(path.size()-1);

		return false;
	}
	
	
	public static int findLCA(Node root, int n1, int n2){
		List<Integer> path1 = new ArrayList<>();
		List<Integer> path2 = new ArrayList<>();
				findPath(root, n1, path1);
				findPath(root, n2, path2);
		Iterator<Integer> iterator = path1.iterator();
		Iterator<Integer> iterator2 = path2.iterator();
		int ans = -1;
		while(iterator.next() == iterator2.next()){
			ans = iterator.next();
			iterator2.next();
		}
		return ans;
		
	}
	
	public static void main(String[] args){
		Node tree = Node.getTree();
		System.out.println(findLCA(tree, 6, 40));
	}
}

