package com.basics.lt;

import java.util.ArrayList;
import java.util.List;

import com.basics.tree.Node;

/*
 * Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
//Given a binary tree, return all root-to-leaf paths.
public class BinaryTreePaths257 {


	public static void main(String[] args){
		Node root = Node.getTree();
		System.out.println(paths(root));
	}
	public static List<String> paths(Node root){
		List<String> paths = new ArrayList<>();
		
		findPaths(root, "", paths);
		return paths;
	}
	
	public static void findPaths(Node root, String current, List<String> paths){
		if(root == null){
			return;
		}
		
		if(root.left ==  null && root.right == null){
			current = current+root.data;
			paths.add(current);
		}
		
		findPaths(root.left, current+root.data+"->", paths);
		findPaths(root.right, current+root.data+"->", paths);
	}
}
