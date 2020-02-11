import java.util.Scanner;

public class Mastermind {
	public static void main(String[] args) {
		Game game = new Game();
		System.out.println("Welkom bij Mastermind! Druk op \"s\" om te beginnen.");
		game.play();
		System.out.println("Bedankt voor het spelen!");
	}
}