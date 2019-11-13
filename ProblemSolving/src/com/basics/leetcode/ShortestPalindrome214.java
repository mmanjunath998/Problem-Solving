package com.basics.leetcode;

import java.util.Arrays;
import java.util.List;

class College{
	
}
class Student extends College{
	String name;
	public Student(String name){
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
}

class Pen extends College{
	int price;
	public Pen(int price){
		this.price = price;
	}
	@Override
	public String toString() {
		return "Pen [price=" + price + "]";
	}
	
}

public class ShortestPalindrome214 {
	
	public static void main(String[] args){
		String s = "aacecaaa";
		System.out.println(find(s));
		Student s1 = new Student("a");
		Student s2 = new Student("b");
		Student s3 = new Student("c");
		Pen p = new Pen(100);
		
		List list = Arrays.asList(s1,s2,s3);
		Pen pen = (Pen) list.get(0);
		System.out.println(pen);
	}

	public static String find(String s){
		int i = 0, j = s.length()-1, end = j;
		
		while(i<j){
			if(s.charAt(i) == s.charAt(j)){
				i++;
				j--;
			}else{
				i=0;
				end--;
				j = end;
			}
		}
		i = end;
		
		String suffix = s.substring(end+1);
		StringBuilder sb = new StringBuilder(suffix);
		return sb.reverse().toString()+s;
	}
}
