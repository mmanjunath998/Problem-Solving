package com.basics.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortByName implements Comparator<Student>
{
	public int compare(Student s1, Student s2){
		return s1.name.compareTo(s2.name);
	}
}

class SortByEmail implements Comparator<Student>
{
	public int compare(Student s1, Student s2){
		return s1.email.compareTo(s2.email);
	}
}

class SortById implements Comparator<Student>
{
	public int compare(Student s1, Student s2){
		if(s1.id > s2.id){
			return 1;
		}else{
			return -1;
		}
	}
}



class Student implements Comparable<Student>{
	int id;
	String name;
	String email;
	public Student(int id, String name , String email){
		this.id = id;
		this.name = name;
		this.email = email;
		
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public int compareTo(Student s1){
		if(s1.id > this.id){
			return 1;
		}else{
			return -1;
		}
	}
}






public class ComparableVSComparator {

	public static void main(String[] args){
		List<Student> students = new ArrayList<>();
		students.add(new Student(100, "manjunath","abs@gmail.com"));
		students.add(new Student(105, "pratyush", "zmak@gmail.com"));
		students.add(new Student(103, "shashi","man@gamil.com"));
		students.add(new Student(102, "ayush","joy@gmail.com"));
		System.out.println(students);
		Collections.sort(students);
		System.out.println(students);
		
		Collections.sort(students, new SortByName());
		System.out.println(students);
		Collections.sort(students, new SortByEmail());
		System.out.println(students);
		Collections.sort(students, new SortById());
		System.out.println(students);
		
		
	}
}
