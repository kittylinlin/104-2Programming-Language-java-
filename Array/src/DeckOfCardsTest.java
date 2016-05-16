import java.security.SecureRandom;

//card shuffling and dealing
public class DeckOfCardsTest{
	
	//execute application
	public static void main(String[] args){
		
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); //place cards in random order
		
		//print all 52 cards in the order in which they are dealt
		for(int i = 1; i <= 52; i++){
			//deal and display a card
			System.out.printf("%-19s", myDeckOfCards.dealCard());
			
			if(i % 4 == 0){ //output a newline after every fourth card
				System.out.println();
			}
		}
	}
}

//card class represents a playing card
class Card {
	
	private final String face; //face of card ("Ace", "Deuce", ...)
	private final String suit; //suit of card ("Heart", "Diamond", ...)
	
	//two-argument constructor initializes card's face and suit
	public Card(String cardFace, String cardSuit){
		this.face = cardFace; //initialize face of card
		this.suit = cardSuit; //initialize suit of card
	}
	
	//return string representation of card
	public String toString(){
		return face + " of " + suit;
	}
}

//DeckOfCard class represents a deck of playing cards
class DeckOfCards{
	
	private Card[] deck; //array of card object
	private int currentCard; //index of next card to be dealt(0-51)
	private static final int NUMBER_OF_CARDS = 52; //constant # of cards
	
	//random number generator
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	//constructor fills deck of cards
	public DeckOfCards(){
		
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		deck = new Card[NUMBER_OF_CARDS]; //create array of card objects
		currentCard = 0; //first card dealt will be deck[0]
		
		//populate deck with card object
		for(int i = 0; i < deck.length; i++){
			deck[i] = new Card(faces[i % 13], suits[i / 13]);
		}
	}
	
	//shuffle deck of cards with one-pass algorithm
	public void shuffle(){
		
		//next call to method dealCard should start at deck[0] again
		currentCard = 0;
		
		//for each card, pick another random card (0-51) and swap them
		for(int first = 0; first < deck.length; first++){
			//select a random number between 0 and 51
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			
			//swap current card with randomly selected card
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}
	
	//deal one card
	public Card dealCard(){
		
		//determine whether cards remain to be dealt
		if(currentCard < deck.length){
			return deck[currentCard++]; //return current card in array
		}
		else {
			return null; //return null to indicate that all cards were dealt
		}
	}
}

