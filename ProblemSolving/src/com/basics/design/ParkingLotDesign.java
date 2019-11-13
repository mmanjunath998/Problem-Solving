package com.basics.design;

import java.util.ArrayList;
import java.util.List;

class Floor implements Comparable<Floor>{
	int floorNumber;
	List<Slot> slot = new ArrayList<>();
	int occupiedCount;
	
	public Floor(){
		
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	
	public List<Slot> getSlot() {
		return slot;
	}
	public void setSlot(List<Slot> slot) {
		this.slot = slot;
	}
	
	@Override
	public int compareTo(Floor o) {
		if(this.floorNumber > o.getFloorNumber()){
			return 1;
		}else if(this.floorNumber < o.getFloorNumber()){
			return -1;
		}
		return 0;
	}
	
	public long getOccupiedCount(){
		return occupiedCount;
	}
	
	public int getFreeSlotsCount(){
		return  slot.size()-occupiedCount;
	}
	
	
}

class Slot{
	int spotNumber;
	boolean isOccupied;
	
	public Slot(){
		
	}

	public int getSpotNumber() {
		return spotNumber;
	}

	public void setSpotNumber(int spotNumber) {
		this.spotNumber = spotNumber;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
}



public class ParkingLotDesign {

}
