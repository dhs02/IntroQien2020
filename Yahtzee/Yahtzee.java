import java.util.Arrays;

public class Yahtzee {
	public static void main(String[] args) {
		YahtzeeSpel spel = new YahtzeeSpel();
		spel.spelen();
		System.out.println("Bedankt voor het spelen!");
		// Print de worpgeschiedenis van alle spelers nadat het spel is afgelopen.
		for (int i = 0; i < spel.playerList.size(); i++) {
			System.out.println("\n" + "Worpgeschiedenis " + spel.playerList.get(i).getName() + ":");
			for (int j = 0; j < spel.playerList.get(i).resultHistory.size(); j++) {
				System.out.println(Arrays.toString(spel.playerList.get(i).resultHistory.get(j)));
			}
		}
	}
}