import java.util.Random;

public class CodeMaker {
	Random random = new Random();
	char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
	char[] pickedChars = new char[4];

	String generateCode() {
		String tempCode ="";
		for (int i = 0; i < pickedChars.length; i++) {
			int randomNum = random.nextInt(6);
			pickedChars[i] = charArray[randomNum];
		}
		tempCode = String.valueOf(pickedChars);
		return tempCode;
	}
}