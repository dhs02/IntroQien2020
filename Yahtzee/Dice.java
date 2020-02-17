import java.util.Random;

public class Dice {
	private int diceValue;
	
	public void throwDice() {
		Random rand = new Random(); 
		this.diceValue = rand.nextInt(6) + 1;
	}
	
	public int getDiceValue() {
		return this.diceValue;
	}
}
