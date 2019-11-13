package com.basics.tree;

import java.util.Map;
import java.util.TreeMap;

/*
 * 
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
class DLL{
	int data;
	DLL next, prev;
	
	public DLL(int data){
		this.data = data;
	}
	
}

public class VeriticleSum {

	
	public static void find(Node root, DLL dll){
		
		dll.data = dll.data+root.data;
		if(root.left != null){
			
			if(dll.prev == null){
				dll.prev = new DLL(0);
				dll.prev.next = dll;
			}
			find(root.left, dll.prev);
		}
		
		if(root.right != null){
			
			if(dll.next == null){
				dll.next = new DLL(0);
				dll.next.prev = dll;
			}
			find(root.right, dll.next);
		}
	}
	
	public static void verticleSum(Node root){
		DLL dll = new DLL(0);
		find(root, dll);
		
		while(dll.prev != null){
			dll = dll.prev;
		}
		while(dll != null){
			System.out.print(dll.data+" ");
			dll = dll.next;
		}
	}
	
	
	public static void verticleSumByMap(Node root){
		
		Map<Integer, Integer> map = new TreeMap<>();
		
		find(root,0,map);
		System.out.println(map);
	}
	
	public static void find(Node root,int hd, Map<Integer, Integer> map){
		
		if(root == null){
			return;
		}
		
		if(map.containsKey(hd)){
			map.put(hd, map.get(hd)+root.data);
		}else{
			map.put(hd, root.data);
		}
		
		find(root.left,hd-1, map);
		find(root.right, hd+1, map);
	}
	
	public static void main(String[] args){
		Node tree = Node.getTree();
		verticleSum(tree);
		System.out.println("  ");
		verticleSumByMap(tree);
	}
}
