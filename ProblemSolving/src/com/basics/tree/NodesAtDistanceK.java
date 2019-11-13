package com.basics.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
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

//here the idea is we need to do the BFS (Level order traversal) of binary tree but we should start it from the 
//start node rather than given node
//this is nothing but the undirected grap we need to do BFS but how to convert bt to graph actually we do't have to convert
//we can have the parent mapping with hash table

public class NodesAtDistanceK {
	
	public static void main(String[] args){
		Node node = Node.getTree();
		find(node, 15, 3);
	}
	

	
	public static void find(Node root, int start, int k){
		Map<Node , Node> parent = new HashMap<>();
		Set<Node> seen = new HashSet<>();
		Queue<Node> q = new LinkedList<>();
		int level = 0;
		inorder(root, parent,null,q,start);
		q.add(null);
		seen.add(q.peek());
		while(!q.isEmpty()){
			Node node = q.poll();
			if(node == null){
				level++;
				q.add(null);
			}else{
				if(node.left != null && !seen.contains(node.left)){
					q.add(node.left);
					seen.add(node.left);
				}
				if(node.right != null && !seen.contains(node.right)){
					q.add(node.right);
					seen.add(node.right);
				}
				Node parentNode =  parent.get(node);
				if(parentNode != null && !seen.contains(parentNode)){
					q.add(parentNode);
					seen.add(parentNode);
				}
			}
				
			if(level == k){
				for(Node n : q){
					if(n != null)
					System.out.println(n.data);
				}
				break;
			}
		}
		
		
	}
	static Node prev = null;
	public static void inorder(Node root, Map<Node , Node> parent, Node prev,Queue<Node> q, int start){
		if(root == null){
			return;
		}
		if(root.data == start){
			q.add(root);
		}
		parent.put(root, prev);
		prev = root;
		inorder(root.left, parent, prev,q,start);
		inorder(root.right, parent,prev,q, start);
	}
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
}
