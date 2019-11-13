package com.basics.design;

abstract class Peice{
	private boolean isKilled;
	private boolean isWhite;
	
	public Peice(boolean isWhite){
		this.isWhite = isWhite;
	}
	public boolean isKilled() {
		return isKilled;
	}

	public void setKilled(boolean isKilled) {
		this.isKilled = isKilled;
	}

	public boolean isWhite() {
		return isWhite;
	}

	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public abstract boolean canMove(BoardC board, Box start, Box end);
}

class King extends Peice{

	public King(boolean isWhite){
		super(isWhite);
	}
	
	@Override
	public boolean canMove(BoardC board, Box start, Box end) {
		if(end.getPeice().isWhite() == this.isWhite()){
			return false;
		}
		int x = Math.abs(start.getX()- end.getX());
		int y = Math.abs(start.getY()- end.getY());
		return (x+y) == 2;
	}
}

class Queen extends Peice{

	public Queen(boolean isWhite){
		super(isWhite);
	}
	
	@Override
	public boolean canMove(BoardC board, Box start, Box end) {
		if(end.getPeice().isWhite() == this.isWhite()){
			return false;
		}
		return false;
	}
}

class Bishop extends Peice{

	public Bishop(boolean isWhite){
		super(isWhite);
	}
	@Override
	public boolean canMove(BoardC board, Box start, Box end) {
		// TODO Auto-generated method stub
		return false;
	}
	
}


class Box{
	private int x;
	private int y;
	private Peice peice;
	public Box(int x, int y, Peice peice){
		this.x = x;
		this.y = y;
		this.peice = peice;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Peice getPeice() {
		return peice;
	}
	public void setPeice(Peice peice) {
		this.peice = peice;
	}
}

class BoardC{
	private Box[] boxes;
	
	public BoardC(){
		boxes = new Box[64];
		initialize();
	}
	private void initialize(){
		
	}

	public Box[] getBoxes() {
		return boxes;
	}

	public void setBoxes(Box[] boxes) {
		this.boxes = boxes;
	}
}



public class ChessGame {

}
