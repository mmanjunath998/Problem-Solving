package com.basics.corejava;

public class Laptop implements Comparable<Laptop>{

	private int price;
	private int ram;
	private String brand;
	
	public int compareTo(Laptop laptop2){
		if(this.getRam() > laptop2.getRam()){
			return 1;
		}else{
			return -1;
		}
	}
	
	public Laptop(int price, int ram, String brand){
		this.price = price;
		this.ram = ram;
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Laptop [price=" + price + ", ram=" + ram + ", brand=" + brand + "]";
	}
}
