import java.util.*;

public class Blackjack {
	
	static Scanner sc = new Scanner(System.in);
	static Random r = new Random();
	
	static Card[] cards = new Card[52];
	static List<String> pickedCards = new ArrayList<String>();
	
	static int totalVal = 0;

	public static void main(String[] args) {
		System.out.println("Welkom bij Blackjack!");
		playRound();
		System.out.println("Bedankt voor het spelen!");
	}

	static void playRound() {
		String input = "";
		char firstChar;
		boolean hasBlackjack = false;
		
		totalVal = 0;						// De totale waarde van de kaarten van de speler.
		pickedCards.clear();				// Zorgt ervoor dat alle kaarten uit het vorige potje uit de lijst verdwijnen (bij aanvang van een nieuw potje).
		
		createDeck(cards);					// Genereert een nieuwe array van Card-objecten.
		shuffle(cards);						// Zet alle objecten in een willekeurige volgorde.
	
		game:
		while (true) {
			String tempCard = "";
			
			System.out.print("Druk \'k\' om twee kaarten te vragen of \'q\' om te stoppen: ");
			input = sc.next();
			firstChar = input.toLowerCase().charAt(0);
			if(firstChar == 'q') {
				break game;
			} else if (firstChar == 'k') {
				tempCard = pickCard();
				totalVal += getValue(tempCard);
				System.out.println("Jouw eerste kaart is: " + tempCard);
					
				tempCard = pickCard();
				totalVal += getValue(tempCard);
				System.out.println("Jouw tweede kaart is: " + tempCard);
				System.out.println("De totale waarde van je twee kaarten is: " + totalVal + '\n');
					
				if (totalVal == 21) {
					hasBlackjack = true;
					System.out.println("Gefeliciteerd, je hebt Blackjack!");
					// CPU turn
				} 
			} else {
				System.out.println("Ongeldige invoer, probeer het opnieuw. \n");
				continue;
			}

			while (hasBlackjack == false) {
				System.out.print("Druk \'k\' voor een nieuwe kaart, \'p\' om je kaarten te houden of \'q\' om te stoppen: ");
				input = sc.next();
				firstChar = input.toLowerCase().charAt(0);
				if (firstChar == 'q') {
					break game;
				} else if (firstChar == 'p') {
					break;
				} else if (firstChar == 'k') {
					tempCard = pickCard();
					totalVal += getValue(tempCard);
					System.out.println("Geef een nieuwe kaart: " + tempCard);
					System.out.println("De totale waarde van je kaarten is: " + totalVal + '\n');
					
					if (totalVal > 21) {
						System.out.println("Helaas, je hebt deze ronde verloren! Wil je nog een ronde spelen? Druk \'j\' voor een nieuw spel of \'q\'om te stoppen.");
						input = sc.next();
						firstChar = input.toLowerCase().charAt(0);
						if (firstChar == 'y') {
							playRound();
						} else if (firstChar == 'q') {
							break game;
						}
					} else if (totalVal == 21) {
						System.out.println("Gefeliciteerd, je hebt Blackjack!");
						break;
						// Ronde naar volgende Speler
					} 
				} else {
					System.out.println("Ongeldige invoer, probeer het opnieuw. \n");
					continue;
				}
			}
		}		// einde game-label
	}
	
	
	// Functies:
	
	// Genereer een String van een Card-object binnen een Card-array.
	static String cardName(Card[] arr, int index) {
		return arr[index].suit + " " + arr[index].rank;
	}
	
	// Print alle Card-objecten binnen een Card-array.
	static void showCards(Card[] deck) {
		for(int i = 0 ; i < deck.length ; i++) {
		    System.out.println(cardName(deck, i));
		}
	}
	
	/* Check of een willekeurige kaart al in het huidige spel gegenereerd is. 
	 * Zo ja, genereer een nieuwe kaart. 
	 * Zo niet, voeg kaart toe aan ArrayList en geef waarde terug.
	 */
	static String pickCard() {
		String temp = cardName(cards, r.nextInt(52));
		while(pickedCards.contains(temp) == true) {
			temp = cardName(cards, r.nextInt(52));
			continue;
		}
		pickedCards.add(temp);
		return temp;
	}
	
	// Voeg 52 Card-objecten toe aan een deck.
	static void createDeck(Card[] deck) {
		int totalIterations = 0;
		for(int i = 0 ; i < Card.suits.length ; i++) {
			for(int j = 0 ; j < Card.ranks.length ; j++) {
				deck[totalIterations] = new Card(i, j);
				totalIterations++;
			}
		}
	 }
	
	// Zet alle 52 kaarten in het deck op willekeurige volgorde.
	 static void shuffle(Card[] array) {
         int arrLength = array.length;
         Random random = new Random();
         for (int i = 0; i < array.length; i++) {
             int randomValue = i + random.nextInt(arrLength - i);
             Card randomElement = array[randomValue];
             array[randomValue] = array[i];
             array[i] = randomElement;
         }
	 }
	 
	 // Bepaal de waarde van een kaart aan de hand van een String.
	 static int getValue(String card) {
			int cardVal = 0;
			char lastChar = card.charAt(card.length()-1);
			// Check of de kaart een A is.
			if (lastChar == 'A') {
				if (totalVal <= 10) {
					cardVal = 11;
				} else {
					cardVal = 1;
				}
			} 
			// Check of de kaart een 10, J, Q of K is.
			else if (lastChar == '0' || lastChar == 'J' || lastChar == 'Q' || lastChar == 'K') {
				cardVal = 10;
			}
			// Check of de kaart een nummer onder de 10 is.
			switch(lastChar) {
			case '2':
				cardVal = 2;
				break;
			case '3':
				cardVal = 3;
				break;
			case '4':
				cardVal = 4;
				break;
			case '5':
				cardVal = 5;
				break;
			case '6':
				cardVal = 6;
				break;
			case '7':
				cardVal = 7;
				break;
			case '8':
				cardVal = 8;
				break;
			case '9':
				cardVal = 9;
				break;
			}
			return cardVal;
		}
}