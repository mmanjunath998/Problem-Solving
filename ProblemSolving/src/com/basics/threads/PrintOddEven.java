package com.basics.threads;

class SharedObject{
	int num;
	public SharedObject(int num){
		this.num = num;
	}
}
class EvenThread extends Thread{
	SharedObject lock;
	EvenThread(SharedObject lock){
		this.lock = lock;
	}
	
	public void run(){
		while(lock.num <=100){
			synchronized(lock){
				if(lock.num % 2 != 0){
					try {
						lock.wait();
						System.out.println("even is waiting for"+lock.num);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					System.out.println("Even Thread : "+lock.num);
					lock.num = lock.num+1;
					lock.notify();
				}
				
			}
		}
	}
}

class OddThread extends Thread{
	
	SharedObject lock;
	public OddThread(SharedObject lock){
		this.lock = lock;
	}
	
	public void run(){
		while(lock.num <=100){
			synchronized(lock){
				if(lock.num % 2 == 0){
					try {
						lock.wait();
						System.out.println("odd is waiting for"+lock.num);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					System.out.println("Odd Thread : "+lock.num);
					lock.num = lock.num+1;
					lock.notify();	
				}
				
			}
		}
	}
	
}

public class PrintOddEven {

	public static void main(String[] args){
		SharedObject lock = new SharedObject(1);
		OddThread odd = new OddThread(lock);
		EvenThread even = new EvenThread(lock);
		odd.start();
		even.start();
	}
	
}
