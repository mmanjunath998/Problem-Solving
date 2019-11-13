package com.basics.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class QData{
	Node node;
	int hd;
	public QData(Node node , int hd){
		this.hd = hd;
		this.node = node;
	}
}

public class TopViewBT {

	public static void topview(Node root){
		Queue<QData> q = new LinkedList<QData>();
		q.add(new QData(root, 0));
		Map<Integer, Integer> map = new TreeMap<>();
		
		while(!q.isEmpty()){
			QData qdata = q.poll();
			if(!map.containsKey(qdata.hd)){
				map.put(qdata.hd, qdata.node.data);
			}
			
			if(qdata.node.left != null){
				q.add(new QData(qdata.node.left, qdata.hd-1));
			}
			if(qdata.node.right != null){
				q.add(new QData(qdata.node.right, qdata.hd+1));
			}
		}
		
		System.out.println(map);
	}
	
	public static void main(String[] args) {
		Node root = Node.getTree();
		topview(root);
	}
}
