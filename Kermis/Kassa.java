public class Kassa {
	static double totaleOmzet;
	static int totaleKaartjes;
	
	// Houdt bij hoeveel belasting er betaald is en hoe vaak de inspecteur langs is geweest.
	static double betaaldeBelasting;
	static int belastinginspecteurLangsgeweest;
	
	static void printOmzet() {
		System.out.println("De totale omzet is: " + totaleOmzet + " euro.\n");
	}
	
	static void printKaartjes() {
		System.out.println("Het totaal aantal verkochte kaartjes is: " + totaleKaartjes + "\n");
	}

}