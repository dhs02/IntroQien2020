import java.util.Scanner;

public class Game {
	Scanner sc = new Scanner(System.in);
	CodeMaker codeMaker = new CodeMaker();
	String code = codeMaker.generateCode();
	
	void play() {
		while (true) {
			System.out.print("Voer een code in van 4 letters of voer \"q\" in om te stoppen: ");
			String input = sc.next();
			if (input.toLowerCase().charAt(0) == 'q') {
				break;
			} else if (input.length() != 4) {
				System.out.println("Onjuiste invoer, probeer het opnieuw.\n");
				continue;
			} else if (input.equals(code) == true){
				System.out.print("Je hebt de code geraden! Toets \"s\" voor een nieuwe ronde of \"q\" om te stoppen.\n");
				String input2 = sc.next();
				if (input2.toLowerCase().charAt(0) == 'q') {
					break;
				} else if (input2.toLowerCase().charAt(0) == 's') {
					code = codeMaker.generateCode();
				}
			} else {
				char[] tempArr = input.toCharArray();
				int rightCharCounter = 0;
				int wrongCharCounter = 0;
				for (int i = 0; i < code.length(); i++) {
					for (int j = 0; j < code.length(); j++) {
						if (tempArr[i] == code.charAt(i)) {
							rightCharCounter++;
							tempArr[i] = '*';
						} else if (tempArr[i] == code.charAt(j)) {
							wrongCharCounter++;
							tempArr[i] = '*';
						}
					}
				}
				System.out.println("Het aantal correcte letters dat op de juiste plaats staat is: " + rightCharCounter);
				System.out.println("Het aantal correcte letters dat niet op de juiste plaats staat is: " + wrongCharCounter + "\n");
			}
		}
	}
}