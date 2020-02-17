public class Turn {
	// Per worp wordt de uitslag in deze int-Array opgeslagen.
	int[] results = new int[5];
	
	// Deze methode print de uitslag op het scherm.
	void returnResults(int [] res) {
		for (int result : results) {
			System.out.print(result + " ");
		}
		System.out.println("\n");
	}
}
