package com.basics.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewBT {

	public static void bottomView(Node root){
		Queue<QData> q = new LinkedList<QData>();
		Map<Integer, Integer> map = new TreeMap<>();
		q.add(new QData(root, 0));

		while(!q.isEmpty())
		{
			QData qdata = q.poll();
			map.put(qdata.hd, qdata.node.data);
			if(qdata.node.left != null){
				q.add(new QData(qdata.node.left, qdata.hd-1));
			}
			if(qdata.node.right != null){
				q.add(new QData(qdata.node.right, qdata.hd+1));
			}
		}
		
		System.out.println(map);
	}
	
	public static void main(String[] args){
		Node node = Node.getTree();
		bottomView(node);
	}
}
