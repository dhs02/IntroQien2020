import java.util.Scanner;

public class Alfabetisch {
	public static void main(String[] args) {
	
	  Scanner sc = new Scanner(System.in);

	  System.out.print("Voer een tekst in: ");

	  String input = sc.nextLine();
	  char[] arr = input.toLowerCase().toCharArray();
	  
	  for (int i = 0; i < input.length(); i++) {
		  for (int j = i+1; j < input.length(); j++) {
			  if (arr[j] < arr[i]) {
			      char highestVal = arr[i];				// tijdelijke variabele om hoogste waarde op te slaan
			      arr[i] = arr[j];						// chars van plaats verwisselen
			      arr[j] = highestVal;					// hoogste waarde op plaats j, na plaats i zetten
		      }
	      }
      }
	  System.out.print("Letters van de String op alfabetische volgorde: ");
	  System.out.println(arr);
    }
}