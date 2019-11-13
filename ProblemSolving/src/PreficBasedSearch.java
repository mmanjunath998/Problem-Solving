import java.util.HashMap;
import java.util.Map;

class TrieNode{
	
	 boolean isLast;
	 Map<Character, TrieNode> child;
	 
	 public TrieNode(){
		 child = new HashMap<Character, TrieNode>();
		 for(char i='a'; i<='z'; i++){
			 child.put(i, null);
		 }
	 }
}


public class PreficBasedSearch {

	TrieNode root;
	
	
	public void search(String query){
		String prefix = "";
		TrieNode curr = root;
		for(int i=0; i<query.length(); i++){
			char c = query.charAt(i);
			prefix = prefix+c;
			TrieNode res = curr.child.get(c);
			if(res == null){
				System.out.println("No results found...");
				return;
			}
			System.out.println("searching for : "+prefix);
			searchUtil(prefix, res);
			curr = res;
		}
	}
	
	public void searchUtil(String prefix, TrieNode currNode){
		
		if(currNode.isLast){
			System.out.println(prefix);
		}
		for(char i = 'a'; i<='z'; i++){
			TrieNode next = currNode.child.get(i);
			if(next != null){
				searchUtil(prefix+i, next);
			}
		}
	}
	
	
	public void insert(String[] names){
		root = new TrieNode();
		for(String name : names){
			insertUtil(name);
		}
	}
	
	public void insertUtil(String s){
		TrieNode itr = root;
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			TrieNode curr = itr.child.get(c);
			if(curr == null){
				curr = new TrieNode();
				itr.child.put(c, curr);
			}
			itr = curr;
			if(i == s.length()-1){
				itr.isLast = true;
			}
		}
	}
	
	public static void main(String[] args){
		PreficBasedSearch search = new PreficBasedSearch();
		String[] names = {"cat", "car","mat","math","camel","catch","manday"};
		search.insert(names);
		search.search("mat");
	}
	
}
