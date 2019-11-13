package com.basics.random;
import java.util.LinkedList;
import java.util.Queue;

class Broker{
	int counter;
	Queue<String> buffer = new LinkedList<String>();


}

class Producer implements Runnable{

	Broker broker;


	public Producer(Broker broker){
		this.broker = broker;
	}

	public void run(){

		while(broker.counter < 10){

			synchronized(broker){
				while(!broker.buffer.isEmpty()){
					try {
						System.out.println("producer is waiting because buffer is full");
						broker.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				broker.buffer.add("message added by produces"+broker.counter++);
				broker.notifyAll();;
			}
		}

	}
}

class Consumer implements Runnable{
	Broker broker;
	public Consumer(Broker broker){
		this.broker = broker;
	}

	public void run(){

		while(broker.counter< 10){
			synchronized(broker){
				while(broker.buffer.isEmpty()){
					try {
						System.out.println("cosumer is waiting because buffer is empty"+Thread.currentThread().getName());
						broker.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				String message = broker.buffer.remove();
				System.out.println("consumer consumed message "+message);
				broker.notify();
			}

		}
	}
}


public class MessageBroker {

	public static void main(String[] args){
		Broker broker = new Broker();
		Producer prod = new Producer(broker);
		Consumer con = new Consumer(broker);
		Consumer con2 = new Consumer(broker);
		Thread t = new Thread(prod);
		t.setName("prod");
		Thread con1 = new Thread(con);
		con1.setName("consumer1");
		Thread cont2 = new Thread(con2);
		cont2.setName("consumer2");
		
		t.start();
		con1.start();
		cont2.start();

	}

}
