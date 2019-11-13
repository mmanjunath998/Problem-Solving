package com.basics.design;

class Shared{
	int count;
}

class EvenThread extends Thread{
	Shared lock;
	public EvenThread(Shared lock){
		this.lock = lock;
	}

	public void run(){
		while(lock.count <= 100){
			synchronized(lock){
				if(lock.count %2 != 0){
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("even "+lock.count);
				lock.count++;
				lock.notify();
			}

		}
	}
}

class OddThread extends Thread{

	Shared lock;
	public OddThread(Shared lock){
		this.lock = lock;
	}

	public void run(){
		while(lock.count<= 100){
			synchronized (lock) {
				if(lock.count%2 == 0){
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("odd"+lock.count);
				lock.count++;
				lock.notify();
			}

		}
	}
}

public class PrintOddEven {

	public static void main(String[] args) {
		Shared lock = new Shared();
		lock.count = 1;
		EvenThread even = new EvenThread(lock);
		OddThread odd = new OddThread(lock);
		even.start();
		odd.start();
	}

}
