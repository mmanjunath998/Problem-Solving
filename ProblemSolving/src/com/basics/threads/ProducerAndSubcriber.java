package com.basics.threads;

import java.util.ArrayList;
import java.util.List;

class SharedObj{
	List<String> messages;
	int capaicty;
	int value;
	public SharedObj(List<String> messages, int capacity, int value){
		this.messages = messages;
		this.capaicty = capacity;
		this.value = value;
	}
}

class Producer extends Thread{
	
	SharedObj lock;
	public Producer(SharedObj lock){
		this.lock = lock;
	}
	
	public void run(){
		
		while(true){
			
			synchronized(lock){
				while(lock.capaicty == lock.messages.size()){
					try {
						lock.wait();
						System.out.println("buffer is full producer is waiting...!");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println("produced message"+lock.value);
				lock.messages.add(String.valueOf(lock.value));
				lock.value = lock.value+1;
				lock.notify();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class Consumer extends Thread{
	SharedObj lock;
	public Consumer(SharedObj lock){
		this.lock = lock;
	}
	
	public void run(){
		while(true){
			
			synchronized(lock){
				while(lock.messages.isEmpty()){
					try {
						lock.wait();
						System.out.println("buffer is empty consumer is waiting...");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				System.out.println("consumed messages : "+lock.messages.remove(0));
				lock.notify();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}

public class ProducerAndSubcriber {
	
	public static void main(String[] args){
		List<String> msg = new ArrayList<>();
		SharedObj lock = new SharedObj(msg, 5, 1);
		Producer produce = new Producer(lock);
		Consumer consume = new Consumer(lock);
		produce.start();
		consume.start();
	}

}
