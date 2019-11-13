package com.basics.threads;

class EvenThreadT extends Thread{
	
	public void run(){
		for(int i=2; i<100; ){
			if(!OddThreadT.isOdd){
				System.out.println("Even Thread : "+i);
				i = i+2;
				OddThreadT.isOdd = true;
			}
		}
	}
}

class OddThreadT extends Thread{
	public static boolean isOdd = true;
	public void run(){
		for(int i=1; i<100;){
			if(isOdd){
				System.out.println("Odd Thread : "+i);
				i = i+2;
				isOdd = false;
			}
		}
	}
}
public class EvenOddByThredsUsingBooleanVar {

	public static void main(String[] args){
		OddThreadT odd = new OddThreadT();
		EvenThreadT even = new EvenThreadT();
		odd.start();
		even.start();
	}
}
