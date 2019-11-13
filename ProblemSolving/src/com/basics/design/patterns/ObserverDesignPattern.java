package com.basics.design.patterns;

import java.util.ArrayList;
import java.util.List;

class Subscriber{
	private String name;
	private Channel channel;
	
	public Subscriber(String name){
		this.name = name;
	}
	
	public void update(){
		System.out.println("hey "+name+" "+channel.titile+ " video updloaded");
	}
	
	public void subscribe(Channel channel){
		this.channel = channel;
	}
	
}

class Channel{
	
	public String titile;
	
	List<Subscriber> subscribers = new ArrayList<Subscriber>();
	
	public void subscribe(Subscriber sub){
		subscribers.add(sub);
	}
	
	public void unsubscriber(Subscriber sub){
		subscribers.remove(sub);
	}
	
	public void notifySubscribers(){
		subscribers.forEach(sub -> sub.update());
	}
	
	public void upload(String title){
		this.titile = title;
		notifySubscribers();
	}
}

public class ObserverDesignPattern {
	
	public static void main(String[] args){
		
		Channel javaBrains = new Channel();
		
		Subscriber s1 = new Subscriber("manjunath");
		Subscriber s2 = new Subscriber("sundar");
		Subscriber s3 = new Subscriber("mutturaj");
		Subscriber s4 = new Subscriber("gaja");
		
		s1.subscribe(javaBrains);
		s2.subscribe(javaBrains);
		s3.subscribe(javaBrains);
		s4.subscribe(javaBrains);
	
		
		javaBrains.subscribe(s1);
		javaBrains.subscribe(s2);
		javaBrains.subscribe(s3);
		javaBrains.subscribe(s4);
		
		javaBrains.upload("learn design patterns...!");
		javaBrains.unsubscriber(s3);
		System.out.println("..........................");
		javaBrains.upload("learn data structure...!");
		
	}

}
