import java.util.HashMap;
import java.util.Map;

class Node{
	int key;
	int value;
	Node next;
	Node prev;
	
	public Node(int key, int value){
		this.key = key;
		this.value = value;
	}
}

public class LRUCache {

	private int capacity;
	private Node head;
	private Node end;
	Map<Integer , Node> map;

	public LRUCache(int capacity){
		this.capacity = capacity;
		map = new HashMap<Integer, Node>();
	}
	
	
	public void addFront(Node node){
		
		if(head == null){
			head = node;
		}else{
			node.prev = null;
			head.prev = node;
			node.next = head;
			head = node;
		}
		
		if(end == null){
			end = head;
		}
	}
	
	public void remove(Node node){
		
		if(node.prev == null)  //first node
		{
			head = node.next;
		}else{
			node.prev.next = node.next;
		}
		
		if(node.next == null){
			end = node.prev;
		}else{
			node.next.prev = node.prev;
		}
	}
	
	public int get(int key){
		if(map.containsKey(key)){
			Node node = map.get(key);
			remove(node);
			addFront(node);
			return node.value;
		}
		return -1;
	}
	
	public void put(int key, int value){
		if(map.containsKey(key)){
			Node node = map.get(key);
			node.value = value;
			remove(node);
			addFront(node);
		}else{
			Node newNode = new Node(key, value);
			if(map.size() == capacity){
				map.remove(end.key);
				remove(end);
				addFront(newNode);
			}else{
				addFront(newNode);
			}
			map.put(key, newNode);
		}
	}
	
	public void print(){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.key+"->"+temp.value+" -->");
			temp = temp.next;
		}
		System.out.println(" ");
	}
	
	public static void main(String[] args){
		LRUCache cache = new LRUCache(4);
		cache.put(20, 2000);
		cache.print();
		cache.put(10, 1000);
		cache.print();
		cache.put(40, 4000);
		cache.print();
		System.out.println("getting : "+cache.get(10));
		cache.print();
		cache.put(50, 5000);
		cache.print();
		cache.put(30, 3000);
		cache.print();
		System.out.println("getting : "+cache.get(20));
		cache.print();
		cache.put(60, 6000);
		cache.print();
		
	}
	
}
