package com.basics.list;

import java.util.HashMap;
import java.util.Map;

class NodeT{
	int val;
	NodeT next;
	NodeT random;
	
	public NodeT(int val){
		this.val = val;
	}
}

public class CopyWithRandomPointer {
	
	
	public static void main(String[] args){
		NodeT head3 = new NodeT(3);
		NodeT head2 = new NodeT(2);
		NodeT head5 = new NodeT(5);
		NodeT head7 = new NodeT(7);
		
		head3.next = head2;
		head3.random = head7;
		head2.next = head5;
		head2.random = head3;
		head5.next = head7;
		head5.random = head2;
		
		NodeT res = copy(head3);
		NodeT r = copyUsingMap(head3);
		NodeT rs = copyNoSpace(head3);
		print(res);
		print(r);
		print(rs);
	}
	
	public static void print(NodeT head){
		NodeT curr = head;
		while(curr != null){
			System.out.print(curr.val);
			if(curr.next != null){
				System.out.print("next -->"+curr.next.val);	
			}
			
			if(curr.random != null){
				System.out.print("random -->"+curr.random.val);	
			}
			
			curr = curr.next;
			System.out.println("...");
		}
	}
	
	
	//copy in O(n) with O(1) space
	
	public static NodeT copyNoSpace(NodeT head){
		
		NodeT copy1 = new NodeT(-1);
		
		NodeT copy2 = copy1;
		NodeT curr = head;
		
		while(curr != null){
			
			copy2.next = new NodeT(curr.val);
			copy2 = copy2.next;
			curr = curr.next;
		}
		curr = head;
		copy2 = copy1.next;
		
		while(curr != null && copy2 != null){
			curr.next = copy2;
			copy2.random = curr;
			curr = curr.next;
			copy2 = copy2.next;
		}
		
		curr = head;
		copy2 = copy1.next;
		
		while(copy2 != null && curr != null){
			
			if(copy2.random != null && copy2.random.random != null){
				copy2.random = copy2.random.random.next;	
			}
			
			copy2 = copy2.next;
			curr = curr.next;
		}
		return copy1.next;
	}
	
	public static NodeT copyUsingMap(NodeT head){
		
		Map<NodeT, NodeT> map =  new HashMap<>();
		
		NodeT copy1 = new NodeT(-1);
		NodeT copy2 = copy1;
		
		NodeT curr = head;
		while(curr != null){
			copy2.next = new NodeT(curr.val);
			map.put(curr, copy2.next);
			copy2 = copy2.next;
			curr = curr.next;
		}
		
		curr = head;
		copy2 = copy1.next;
		
		while(curr != null && copy2 != null){
			NodeT random = curr.random;
			NodeT copyRandom = map.get(random);
			copy2.random = copyRandom;
			
			curr = curr.next;
			copy2 = copy2.next;
		}
		return copy1.next;
	}
	
	
	
//takes O(n^2)
	public static NodeT copy(NodeT head){
		NodeT copy1 = new NodeT(-1);
		NodeT copy2 = copy1;
		
		NodeT curr = head;
		while(curr != null){
			copy2.next = new NodeT(curr.val);
			copy2 = copy2.next;
			curr = curr.next;
		}
		
		curr = head;
		NodeT copyForRandom = copy1.next;
		
		while(curr != null && copyForRandom != null){
			
			NodeT random = curr.random;
			copyForRandom.random = getRandom(random != null ? random.val: -2, copy1);
			curr = curr.next;
			copyForRandom = copyForRandom.next;
		}
		
		return copy1.next;
	}
	
	public static NodeT getRandom(int val, NodeT head){
		NodeT curr = head;
		while(curr != null){
			if(curr.val == val){
				return curr;
			}
			curr = curr.next;
		}
		return null;
	}
	
}
