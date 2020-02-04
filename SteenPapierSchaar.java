import java.util.Random;
import java.util.Scanner;

public class SteenPapierSchaar {
	// Genereer Random nummer (1 t/m 3) en ken waarde toe
	static String cpuTurn() {
		Random rand = new Random();
		int genRan = rand.nextInt(3) + 1;
		String cpuTurn = "";
		switch(genRan) {
		case 1:
			cpuTurn = "steen";
			break;
		case 2:
			cpuTurn = "papier";
			break;
		case 3:
			cpuTurn = "schaar";
			break;
		}
		return cpuTurn;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String playerTurn = "";
		String computerTurn = "";
		boolean play = true;
		
		while (play == true) {
		    System.out.print("Voer \"steen\", \"papier\" of \"schaar\" in: ");
		    
			playerTurn = sc.nextLine().trim().toLowerCase();
			computerTurn = cpuTurn();

			if (playerTurn.compareTo("steen") != 0 && playerTurn.compareTo("papier") != 0 && playerTurn.compareTo("schaar") != 0 ) {
				System.out.println("Onjuiste invoer, probeer opnieuw.\n");
				continue;
			}
			
			System.out.println("Je hebt " + "\"" + playerTurn + "\"" + " gespeeld! ");
			System.out.println("De computer heeft \"" + computerTurn + "\" gespeeld! \n");
			
			// Checken of speler gewonnen heeft.
			if ((playerTurn.compareTo("steen") == 0 && computerTurn.compareTo("schaar") == 0) || (playerTurn.compareTo("schaar") == 0 && computerTurn.compareTo("papier") == 0) || (playerTurn.compareTo("papier") == 0 && computerTurn.compareTo("steen") == 0)) {
				System.out.println("Je hebt gewonnen!\n");
				play = false;
			} 
			// Checken of de computer gewonnen heeft.
			else if ((computerTurn.compareTo("steen") == 0 && playerTurn.compareTo("schaar") == 0) || (computerTurn.compareTo("schaar") == 0 && playerTurn.compareTo("papier") == 0) || (computerTurn.compareTo("papier") == 0 && playerTurn.compareTo("steen") == 0)) {
				System.out.println("Helaas, de computer heeft gewonnen.\n");
				play = false;
			} 
			// Checken voor gelijk spel.
			else if (playerTurn.compareTo(computerTurn) == 0){
				System.out.println("Gelijkspel, probeer het nog eens.\n");
			}
		}
	}
}
