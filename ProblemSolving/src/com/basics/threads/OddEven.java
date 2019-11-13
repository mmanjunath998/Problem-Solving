package com.basics.threads;

class Shared{
	int num;
	public Shared(int num){
		this.num = num;
	}
}

class Even extends Thread{
	Shared lock;
	public Even(Shared lock){
		this.lock = lock;
	}
	
	public void run(){
		while(lock.num <= 100){
			synchronized(lock){
				if(lock.num %2 != 0){
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("even : "+lock.num);
				lock.num = lock.num+1;
				lock.notify();
			}
		}
	}
	
}

class Odd extends Thread{
	Shared lock;
	public Odd(Shared lock){
		this.lock = lock;
	}
	
	public void run(){
		while(lock.num <=100){
			synchronized(lock){
				if(lock.num %2 == 0){
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				System.out.println("odd : "+lock.num);
				lock.num = lock.num+1;
				lock.notify();
			}
		}
	}
}

public class OddEven {

	public static void main(String[] args){
		Shared lock = new Shared(1);
		Odd odd = new Odd(lock);
		Even even = new Even(lock);
		odd.start();
		even.start();
	}
}
