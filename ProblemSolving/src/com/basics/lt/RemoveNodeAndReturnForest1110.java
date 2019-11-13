package com.basics.lt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.basics.tree.Node;

public class RemoveNodeAndReturnForest1110 {

	public static List<Node> delete(Node root, int[] to_delete){
		List<Node> remaining = new ArrayList<>();
		
		Set<Integer> toDelete = new HashSet<>();
		for(int i : to_delete){
			toDelete.add(i);
		}
		
		delete(root, remaining, toDelete);
		
		if(!toDelete.contains(root.data)){
			remaining.add(root);
		}
		
		return remaining;
	}
	
	public static Node delete(Node root, List<Node> remaining, Set<Integer> toDelete){
		
		if(root == null){
			return null;
		}
		root.left = delete(root.left, remaining, toDelete);
		root.right = delete(root.right, remaining, toDelete);
		
		if(toDelete.contains(root.data)){
			
			if(root.right != null){
				remaining.add(root.right);
			}
			
			if(root.left != null){
				remaining.add(root.left);
			}
			return null;
		}
		
		return root;
	}
}
