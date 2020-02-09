public class Card {

	static String[] suits = {"Harten", "Klaver", "Ruiten","Schoppen"};
	static String[] ranks = {"2", "3", "4","5","6", "7", "8","9","10", "J", "Q","K","A"};

	String suit;
	String rank;
	
	Card(int s, int r){
	    this.suit = suits[s];
	    this.rank = ranks[r];
	}


}
