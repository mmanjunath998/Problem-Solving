package com.basics.design.patterns;


class Phone{
	
	private String os;
	private String processor;
	private double price;
	private int ram;
	private int battary;
	
	public Phone(String os, String processor, double price, int ram, int battary) {
		super();
		this.os = os;
		this.processor = processor;
		this.price = price;
		this.ram = ram;
		this.battary = battary;
	}
	@Override
	public String toString() {
		return "Phone [os=" + os + ", processor=" + processor + ", price=" + price + ", ram=" + ram + ", battary="
				+ battary + "]";
	}
}

class PhoneBuilder{
	private String os;
	private String processor;
	private double price;
	private int ram;
	private int battery;
	
	
	public PhoneBuilder setOs(String os) {
		this.os = os;
		return this;
	}
	public PhoneBuilder setProcessor(String processor) {
		this.processor = processor;
		return this;
	}
	
	public PhoneBuilder setPrice(double price) {
		this.price = price;
		return this;
	}
	
	public PhoneBuilder setRam(int ram) {
		this.ram = ram;
		return this;
	}
	
	public PhoneBuilder setBattery(int battery) {
		this.battery = battery;
		return this;
	}
	
	public Phone build(){
		return new Phone(os, processor, price, ram, battery);
	}
}

public class BuilderDesignPattern {

	public static void main(String[] args) {
		Phone phone = new Phone("Android", "Qualcom", 500.5, 4, 5000);
		System.out.println(phone);
		
		Phone p  = new PhoneBuilder()
				.setProcessor("intel")
				.setPrice(2000)
				.setRam(4)
				.setOs("ios")
				.setBattery(5000)
				.build();
		System.out.println(p);
	}
}
