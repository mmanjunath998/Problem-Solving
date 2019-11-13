package com.basics.list;

class NodeF{
	int data;
	NodeF right;
	NodeF down;
	public NodeF(int data){
		this.data = data;
	}
}


public class FlatteningList {

	
	public static NodeF flatten(NodeF head){
		if(head == null || head.right == null){
			return head;
		}
		return merge(head, flatten(head.right));
	}
	
	public static NodeF merge(NodeF a, NodeF b){
		if(a == null){
			return b;
		}
		if(b == null){
			return a;
		}
		
		NodeF result = null;
		if(a.data < b.data){
			result = a;
			result.down = merge(a.down, b);
		}else{
			result = b;
			result.down = merge(a, b.down);
		}
		return result;
	}
	
	
	
	public static void main(String[] args){
		NodeF n1 = new NodeF(5);
		n1.down = new NodeF(10);
		n1.down.down = new NodeF(20);
		n1.down.down.down = new NodeF(30);
		
		NodeF n2 = new NodeF(7);
		n2.down = new NodeF(14);
		n2.down.down = new NodeF(21);
		n2.down.down.down = new NodeF(38);
		
		
		NodeF n3 = new NodeF(9);
		n3.down = new NodeF(18);
		n3.down.down = new NodeF(27);
		
		n1.right = n2;
		n2.right = n3;
		
		NodeF res = flatten(n1);
		
		while(res != null){
			System.out.print(res.data+"-->");
			res = res.down;
		}
		
		
	}
}
