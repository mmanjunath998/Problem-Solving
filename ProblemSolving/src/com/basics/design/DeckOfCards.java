package com.basics.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

enum Suit{
	
	DIAMONDS(1),
	HEARTS(2),
	SPADES(3),
	CLUBS(4);
	
	private int suitValue;
	private Suit(int suitValue){
		this.suitValue = suitValue;
	}
	
	public int getSuitValue(){
		return this.suitValue;
	}
	
}
enum Rank{
	
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	JACK(11),
	KING(12),
	QUEEN(13),
	ACE(14);
	
	private int rankValue;
	private Rank(int rankValue){
		this.rankValue = rankValue;
	}
	
	public int getRankValue(){
		return this.rankValue;
	}
}

class Card{
	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit){
		this.rank = rank;
		this.suit = suit;
	}

	@Override
	public String toString() {
		return "Card [rank=" + rank + ", suit=" + suit + "]";
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}
}

class Deck{
	
	private List<Card> cardDeck;
	
	public Deck(){
		cardDeck = new ArrayList<Card>();
		for(Suit suit : Suit.values()){
			for(Rank rank : Rank.values()){
				cardDeck.add(new Card(rank, suit));
			}
		}
	}
	
	public void suffle(){
		//shuffle for 20 times
		Random random = new Random();
		for(int i=1; i<=20; i++){
			int firstCard  =  random.nextInt(52);
			int secondCard = random.nextInt(52);
			Collections.swap(cardDeck, firstCard, secondCard);
		}
	}
	
	public void dealCard(Players player){
		//take the first card from the deck
		Card card = cardDeck.remove(0);
		player.getHand().add(card);
	}
	
	public int cardDeckSize(){
		return cardDeck.size();
	}
	
	
	public void lookDeck(){
		for(Card card : cardDeck){
			System.out.println(card);
		}
	}
}


class Players{
	
	private List<Card> hand;
	
	public Players(){
		hand = new ArrayList<>();
	}
	
	public List<Card> getHand() {
		return hand;
	}
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	@Override
	public String toString() {
		return "Player [hand=" + hand + "]";
	}
	
	public void showPlayerCard(){
		System.out.println("player cards");
		for(Card card : hand){
			System.out.println(card);
		}
		
	}
	
}

public class DeckOfCards {
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		Players player1 = new Players();
		Players player2 = new Players();
		
		System.out.println(deck.cardDeckSize());
		deck.lookDeck();
		deck.suffle();
		deck.lookDeck();
		
		deck.dealCard(player1);
		deck.dealCard(player2);
		player1.showPlayerCard();
		System.out.println(" ");
		player2.showPlayerCard();
		System.out.println(" ");
		System.out.println(deck.cardDeckSize());
		deck.lookDeck();
	}
}
