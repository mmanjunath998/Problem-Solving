package com.basics.design;

import java.util.List;
import java.util.Random;

class Snake{
	int mouthPosition;
	int tailPosition;
}

class Ladder{
	int startPosition;
	int endPosition;
}

class Board{
	List<Snake> snakes;
	List<Ladder> ladders;
	
}

enum PlayerState{
	READY,
	NOT_READY;
}

class Player{
	String name;
	int currentPosition;
	PlayerState currState;
}

class Dice{
	int roll(){
		Random random = new Random();
		return random.nextInt(6);
	}
}


interface SnakeAndLadderGame{
	
	void assigningPlayingOrder();
	int rollDice(Player player, Dice dice);
	boolean isSnakePresent(int position);
	boolean isLadderPresent(int position);
	int calculatePosition(Player player, int newPosition);
}


class SnakeAndLadderGameImpl implements SnakeAndLadderGame{

	Player currPlayer;
	Board board;
	List<Player> orderingPlayer;
	
	@Override
	public void assigningPlayingOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int rollDice(Player player, Dice dice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isSnakePresent(int position) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLadderPresent(int position) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int calculatePosition(Player player, int newPosition) {
		// TODO Auto-generated method stub
		return 0;
	}
}

interface SnakeAndLadderGameRules{
	
	boolean canStartGame(int diceValue);
	boolean hasWonGame(Player player, int position);
	boolean canPlayAgain(Player player, int diceValue);
}

class SnakeAndLadderGameRulesImpl implements SnakeAndLadderGameRules{

	@Override
	public boolean canStartGame(int diceValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasWonGame(Player player, int position) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canPlayAgain(Player player, int diceValue) {
		// TODO Auto-generated method stub
		return false;
	}
}


class SnakeAndLadderGameFactory{
	
	SnakeAndLadderGameFactory getInstance(){
		return new SnakeAndLadderGameFactory();
	}
	
	public Player createPlayer(String name, int position, PlayerState state){
		return new Player();
	}
	
	public Snake createSnake(int mouthPosition, int tailPosition){
		return new Snake();
	}
	
	public Ladder createLadder(int start, int end){
		return new Ladder();
	}
}

public class SnakeLadderOOPSDesign {

	
	public static void main(String[] args){
		
	}
}
