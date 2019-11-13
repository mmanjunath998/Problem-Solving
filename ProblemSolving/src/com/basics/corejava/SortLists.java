package com.basics.corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortLists {

	public static void main(String[] args){
		sortString();
		sortInteger();
		sortLaptops();
	}

	private static void sortLaptops(){
		List<Laptop> laptops = new ArrayList<>();
		laptops.add(new Laptop(800, 4, "Apple"));
		laptops.add(new Laptop(200, 8, "Dell"));
		laptops.add(new Laptop(500, 2, "Compac"));

		laptops.forEach(laps -> System.out.println(laps));
		Collections.sort(laptops);
		System.out.println(".......................................");
		laptops.forEach(laps -> System.out.println(laps));


		Comparator<Laptop> byBrand = new Comparator<Laptop>(){

			public int compare(Laptop l1, Laptop l2){
				return l1.getBrand().compareTo(l2.getBrand());
			}
		};
		System.out.println("by brand.......................................");
		Collections.sort(laptops, byBrand);
		laptops.forEach(value -> System.out.println(value));


		Comparator<Laptop> byPrice = new Comparator<Laptop>(){

			public int compare(Laptop l1, Laptop l2){
				if(l1.getPrice() > l2.getPrice()){
					return 1;
				}else{
					return -1;
				}
			}
		};
		System.out.println("by price.................................");
		Collections.sort(laptops, byPrice);
		laptops.forEach(prices -> System.out.println(prices));

		Comparator<Laptop> byRam = new Comparator<Laptop>(){

			public int compare(Laptop l1, Laptop l2){
				if(l1.getRam() > l2.getRam()){
					return 1;
				}else{
					return -1;
				}
			}
		};
		System.out.println("by ram....................................");
		Collections.sort(laptops, byRam);
		laptops.forEach(ram -> System.out.println(ram));
	}


	private static void sortInteger(){
		List<Integer> ages = new ArrayList<>();
		ages.add(23);
		ages.add(10);
		ages.add(2);
		ages.add(15);
		System.out.println(ages);
		Collections.sort(ages);
		System.out.println(ages);
	}


	private static void sortString() {
		List<String> names = new ArrayList<>();
		names.add("manjunath");
		names.add("vinod");
		names.add("prasad");
		names.add("geroge");
		System.out.println(names);
		Collections.sort(names);
		System.out.println(names);
	}


}
