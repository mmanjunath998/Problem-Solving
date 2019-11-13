package com.basics.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstNonRepeatingCharInStream {
	
	
	
	public static void find(){
		List<String> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the character length");
		int i = sc.nextInt();
		int x = 0;
		while(x <= i){
			System.out.println("enter the character...");
			String s = sc.next();
			
			if(list.contains(s)){
				list.remove(s);
			}else{
				list.add(s);
			}
			System.out.println(list);
			System.out.println("so far the first non repeating char is "+list.get(0));
			x++;
		}
		sc.close();
	}

	public static void main(String[] args) {
		find();
	}
}
