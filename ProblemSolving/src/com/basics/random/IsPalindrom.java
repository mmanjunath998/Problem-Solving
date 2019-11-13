package com.basics.random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;


public class IsPalindrom {

	public static void main(String[] args) {
		String s = "abcd";
		List<Integer> l = new ArrayList<>();
		List<Integer> r = new ArrayList<>();
		l.add(1);
		l.add(1);
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(2);
		//System.out.println(howManyPalindromes(s, l, r));
		String[] arr = {"{}[]()","{[}]}"};
		//String[] res = braces(arr);
		
		System.out.println(deleteProducts(l, 2));
	}
	
	
	  public static List<Long> howManyPalindromes(String s, List<Integer> l, List<Integer> r) {
		  List<Long> result = new ArrayList<>();
		  int n = s.length();
		  for(int k=0; k<l.size(); k++){
			  int minLength = l.get(k);
			  int maxLength = r.get(k);
			  int count = 0;
			  for(int i=0; i<n; i++){
				  for(int j=i; j<n; j++){
					  String sub = s.substring(i, j+1);
					  if(sub.length() >= minLength && sub.length()<=maxLength){
						  if(isPalindrom(sub)){
							  count++;  
						  }
						  
					  }
				  }
			  }
			  result.add(Long.valueOf(count));
		  }
		  
		  
		  return result;
	}
	  
	  public static boolean isPalindrom(String s){
		  int start = 0;
		  int end = s.length()-1;
		  while(start <= end){
			  if(s.charAt(start) != s.charAt(end)){
				  return false;
			  }
			  start++;
			  end--;
		  }
		  return true;
	  }
	  
	  
	  static String[] braces(String[] values) {
		  String[] result = new String[values.length];
		  
		  
		  
		  for(int k = 0; k<values.length; k++){
			  String str = values[k];
			  Stack<Character> sk = new Stack<>();
			  for(int i = 0; i<str.length(); i++){
				  
				  char c = str.charAt(i);
				  if(c == '{' || c == '(' || c == '['){
					  sk.push(c);
				  }else{
					  	if(!sk.isEmpty()){
						  if(isPair(sk.peek(),c)){
							  sk.pop();  
						  }else{
							  break;
						  }
						  
					  }
				  }
			  }
			  if(sk.isEmpty()){
				  result[k] = "YES";
			  }else{
				  result[k] = "NO";
			  }
		  }
		  return result;
	    }
	  
	  public static boolean isPair(char c1, char c2){
		  if(c1 == '(' && c2 == ')'){
			  return true;
		  }
		  if(c1 == '{' && c2 == '}'){
			  return true;
		  }
		  if(c1 == '[' && c2 == ']'){
			  return true;
		  }
		  return false;
	  }
	  
	  
	  public static int deleteProducts(List<Integer> ids, int m) {
		    // Write your code here
		 
		 Map<Integer, Integer> map = new HashMap<>();
		 
		 for(int value : ids){
			 if(map.containsKey(value)){
				 map.put(value, map.get(value)+1);
			 }else{
				 map.put(value, 1);
			 }
		 }
		 
		 Comparator<Entry<Integer, Integer>> comp = new Comparator<Map.Entry<Integer,Integer>>(
				 ) {
					@Override
					public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
						return o1.getValue().compareTo(o2.getValue());
					}
		};
		 
		Set<Entry<Integer, Integer>> entry = map.entrySet();
		List<Entry<Integer, Integer>> list = new ArrayList<>(entry);
		Collections.sort(list, comp);
		
		int i = 0;
		int size = list.size();
		while(m > 0 && i<list.size()){
			Entry<Integer, Integer> e = list.get(i++);
			if(e.getValue() - m <= 0){
				size--;
			}
			m = Math.abs(e.getValue()-m);
		}
		 return size;
	}
}
