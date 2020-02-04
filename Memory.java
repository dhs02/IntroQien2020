import java.util.Scanner;

public class Memory {
	
	static String numbers = "****";
	static boolean turn = true;
	
	public static void showNum(int x) {
		switch (x) {
		case 1:
			System.out.println("7" + numbers.substring(1,4) + "\n");
			break;
		case 2:
			System.out.println(numbers.substring(0,1) + "3" + numbers.substring(2,4) + "\n");
			break;
		case 3:
			System.out.println(numbers.substring(0,2) + "3" + numbers.substring(3) + "\n");
			break;
		case 4:
			System.out.println(numbers.substring(0,3) + "7" + "\n");
			break;
		}
	  }
	
	  public static void main(String[] args){
			Scanner sc = new Scanner(System.in);
			int input1;
			int input2;
			
			while (turn == true) {
				input1 = 0;
				input2 = 0;

				System.out.println(numbers);

				System.out.print("Voer de nummer van de positie van het eerste cijfer in: ");
				input1 = sc.nextInt();
				showNum(input1);

				System.out.print("Voer de nummer van de positie van het tweede cijfer in: ");
				input2 = sc.nextInt();
				showNum(input2);

				if ((input1 == 1 && input2 == 4) || (input1 == 4 && input2 == 1)) {
					System.out.println("Het is een match! \n");
					numbers = '7' + numbers.substring(1,3) + '7';
				} else if ((input1 == 2 && input2 == 3) || (input1 == 3 && input2 == 2)) {
					System.out.println("Het is een match! \n");
					numbers = numbers.substring(0,1) + '3' + '3' + numbers.substring(3);
				} else {
					System.out.println("Helaas, probeer het nog een keer! \n");
					continue;
				}
				
				if (numbers.compareTo("7337") == 0) {
					System.out.println(numbers);
					System.out.println("Gefeliciteerd, je hebt alles geraden!");
					turn = false;
				}
				
			}
	 }
	  
	  

}