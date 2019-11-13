package com.basics.design;

class SharedSource{
	int count;
	int zero;
	
}

class Zero extends Thread{
	SharedSource lock;
	public Zero(SharedSource lock){
		this.lock = lock;
	}
	
	public void run(){
		
		while(lock.count <=100){
			synchronized(lock){
				if(lock.zero != 0){
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("from zero"+lock.zero++);
				lock.notifyAll();
				
			}
		}
		
	}
}

class Even extends Thread{
	
	SharedSource lock;
	public Even(SharedSource lock){
		this.lock = lock;
	}
	
	public void run(){
		while(lock.count <=100){
			synchronized(lock){
				if(lock.count%2 != 0 && lock.zero != 0){
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println("even"+lock.count++);
				lock.zero = 0;
				lock.notifyAll();	
			}
		}
	}
}

class Odd extends Thread{
	SharedSource lock;
	public Odd(SharedSource lock){
		this.lock = lock;
	}
	
	
	public void run(){
		while(lock.count <=100){
			synchronized (lock) {
				if(lock.count %2 == 0 && lock.zero != 0){
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println("odd"+lock.count++);
				lock.zero = 0;
				lock.notifyAll();
			}
			
		}
	}
}
public class OddEvenThread {
	
	public static void main(String[] args) {
		SharedSource lock = new SharedSource();
		lock.count = 1;
		Even even = new Even(lock);
		Odd odd = new Odd(lock);
		Zero zero = new Zero(lock);
		zero.start();
		odd.start();
		even.start();
		
		
	}

}
