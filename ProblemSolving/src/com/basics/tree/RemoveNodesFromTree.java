package com.basics.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

public class RemoveNodesFromTree {

	public static void main(String[] args){

		Node root = Node.getTree();
		int[] arr = {30,5};
		Node.print(root);
		List<Node> list = deleteNodes(root, arr);

		System.out.println("....");
		for(Node node : list){
			System.out.print(node.data+" ");
		}


	}

	public static List<Node> deleteNodes(Node root, int[] toDelete){

		List<Node> remaining = new ArrayList<>();

		Set<Integer> toDeleted = new HashSet<>();

		for(int i : toDelete){
			toDeleted.add(i);
		}
		delete(root, remaining, toDeleted);

		if(!toDeleted.contains(root.data)){
			remaining.add(root);
		}
		return remaining;
	}

	public static Node delete(Node root, List<Node> remaining, Set<Integer> toDeleted){

		if(root == null){
			return null;
		}

		root.left = delete(root.left, remaining, toDeleted);
		root.right = delete(root.right, remaining, toDeleted);

		if(toDeleted.contains(root.data)){

			if(root.left != null){
				remaining.add(root.left);
			}
			if(root.right != null){
				remaining.add(root.right);
			}
			return null;

		}
		return root;

	}
}
