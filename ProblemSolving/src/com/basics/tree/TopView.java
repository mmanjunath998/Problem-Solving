package com.basics.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;
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

class QueObj{
	int hd;
	Node root;
	public QueObj(int hd, Node root){
		this.hd = hd;
		this.root = root;
	}
}
public class TopView {

	
	public static void print(Node root){
		
		Queue<QueObj> q = new LinkedList<>();
		Map<Integer, Node> map = new TreeMap<>();
		
		q.add(new QueObj(0, root));
		
		while(!q.isEmpty()){
			QueObj qNode = q.poll();
			if(!map.containsKey(qNode.hd)){
				map.put(qNode.hd, qNode.root);
			}
			if(qNode.root.left != null){
				q.add(new QueObj(qNode.hd-1, qNode.root.left));
			}
			if(qNode.root.right != null){
				q.add(new QueObj(qNode.hd+1, qNode.root.right));
			}
		}
		
		Iterator<Entry<Integer, Node>> iterator = map.entrySet().iterator();
		System.out.println();
		iterator.forEachRemaining(value -> System.out.println(value.getValue().data));
		Iterator<Entry<Integer, Node>> iterator2 = map.entrySet().iterator();
		while(iterator2.hasNext()){
			System.out.println(iterator2.next().getValue().data);
		}
		
	}
	
	public static void main(String[] args){
		Node tree = Node.getTree();
		print(tree);
	}
}
