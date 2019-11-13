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
import java.util.ArrayList;
import java.util.List;

import com.basics.tree.Node;

public class PathSumII113 {
	
	public static void main(String[] args){
		Node root = Node.getTree();
		System.out.println(paths(root, 61));
	}

	public static List<List<Integer>> paths(Node root, int sum){
		List<List<Integer>> paths = new ArrayList<>();
		if(root == null){
			return paths;
		}
		
		findPaths(root, sum, new ArrayList<Integer>(), paths);
		return paths;
	}
	
	public static void findPaths(Node root, int sum, List<Integer> current, List<List<Integer>> paths){
		if(root == null){
			return;
		}
		
		current.add(root.data);
		if(root.data == sum && root.left == null && root.right == null){
			paths.add(new ArrayList<>(current));
		}
		
		findPaths(root.left, sum-root.data, current, paths);
		findPaths(root.right, sum-root.data, current, paths);
		
		current.remove(current.size()-1);
		
	}
}
