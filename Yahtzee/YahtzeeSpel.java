import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class YahtzeeSpel {
	private Scanner sc = new Scanner(System.in);
	private Turn turn = new Turn();
	private String input;
	// Huidig spel wordt gespeeld met 2 spelers.
	List<Player> playerList = Arrays.asList(new Player("Speler 1"),new Player("Speler 2"));
	Player currentPlayer = playerList.get(0);
	// Lege Dice-ArrayList.
	private ArrayList<Dice> diceArray = new ArrayList<Dice>();
	// Lege array voor 5 elementen.
	private int[] blockArray = new int[5];
	// Constructor die 5 Dice-objecten toevoegt aan de diceArray.
	YahtzeeSpel() {
		addDices(diceArray, 5);
	}
	void spelen() {
		while (true) {
			System.out.println(currentPlayer.getName() + " is aan de beurt.");
			System.out.print("Druk Enter voor het werpen van een nieuwe worp. Druk \"q\" voor het stoppen met het spel.");
			input = sc.nextLine();
			if (input.equals("")) {
				resetArray(blockArray);
				throwDices(diceArray, blockArray);
				while (currentPlayer.turnsLeft > 0) {
					resetArray(blockArray);
					System.out.println("Welke posities wilt u vasthouden? Toets 0 voor geen anders bv \"125\".");
					input = sc.nextLine();
					if (input.equals("0")) {
						throwDices(diceArray, blockArray);
					} else if (!input.equals("0")) {
						if (checkValue(input) == false) {
							continue;
						}
						holdValue(input);
						throwDices(diceArray, blockArray);	
					}
				}
			} else if (input.equals("q")) {
				break;
			}
			// De huidige speler heeft weer 3 pogingen nadat de volgende speler klaar is met gooien.
			currentPlayer.setTurnsLeft(3);
			// Schakelt naar volgend Player-object in de lijst.
			currentPlayer = playerList.get((playerList.indexOf(currentPlayer)+1)%playerList.size());
		}
	}
	// Maak <amount> Dice-objecten en voeg deze toe aan een Dice-ArrayList
	void addDices (ArrayList<Dice> arr, int amount) {
		for(int i = 0; i < amount; i++) {	
			arr.add(new Dice());
		}
	}
	// Methode om de invoer te checken voordat er mee gewerkt wordt.
	boolean checkValue(String value) {
		int singleNum;
		// Check of de String bestaat uit integers.
		try { 
	        Integer.parseInt(value); 
	    } catch(NumberFormatException e) {
	    	System.out.println("Ongeldige invoer. De invoer mag alleen getallen bevatten.\n");
	        return false; 
	    } 
		// Check of de String maximaal 5 karakters bevat.
		if (value.length() <= 0 || value.length() > 5) {
			System.out.println("Ongeldige invoer. De invoer mag maximaal 5 cijfers lang zijn.\n");
			return false;
		}
		// Check of de String alleen de getallen 1, 2, 3, 4, 5 bevat.
		for (int i = 0; i < value.length(); i++) {
			singleNum = Integer.parseInt(String.valueOf(value.charAt(i)));
			if (singleNum <= 0 || singleNum > 5) {
				System.out.println("Ongeldige invoer. De invoer mag alleen de getallen 1 t/m 5 bevatten.\n");
				return false;
			} else {
				continue;
			}
		}
		return true;
	}
	// 1. Zet alle individuele karakters van de invoer-String om in Integers.
	// 2. Check welke posities er gehouden moeten worden en verander de waarde van het blockArray-element in 1
	void holdValue(String value) {
		int temp;
		for (int i = 0; i < value.length(); i++) {
			temp = Integer.parseInt(String.valueOf(value.charAt(i)));
			blockArray[temp-1] = 1;
		}
	}
	// Gooi de dobbelstenen en vergelijk ze met de blockArray om te zien welke eventueel opnieuw gegooid moeten worden.
	void throwDices(ArrayList<Dice> diceArr, int[] intArr) {
		String currentTurn = "";
		int index = 0;
		int[] tempResult = new int[5];
		// Zorg dat de huidige beurt juist wordt weergegeven op het scherm.
		switch (currentPlayer.turnsLeft) {
		case 1:
			currentTurn = "3";
			break;
		case 2:
			currentTurn = "2";
			break;
		case 3: 
			currentTurn = "1";
			break;
		}
		// 1. Als het nummer in de blockArray 0 is, wordt een dobbelsteen opnieuw gegooid. 
		// 2. De index houdt bij met welk element uit de diceArray, de blockArray correspondeert.
		System.out.println("WORP " + currentTurn + ":\n1 2 3 4 5");
		for (int element : intArr) {
			if (element == 0) {
				diceArr.get(index).throwDice();
			}
			tempResult[index] = diceArr.get(index).getDiceValue();
			index++;
		}
		turn.results = tempResult;
		turn.returnResults(turn.results);
		currentPlayer.resultHistory.add(tempResult);
		currentPlayer.turnsLeft -= 1;
	}
	// Methode om de blockArray te resetten na iedere worp. Deze methode wordt voor elke worp gebruikt.
	void resetArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
	}
}