package com.basics.design;

enum Direction{
	UP,
	DOWN;
}

enum States{
	MOVING,
	STOPPED;
}

enum Door{
	OPEN,
	CLOSED;
}

class Request{
	int floor;
	Direction direction;
	long time;
	
	public Request(int floor, Direction direction, long time){
		this.floor = floor;
		this.direction = direction;
		this.time = time;
	}
}


public class ElevatorSystem {

}
