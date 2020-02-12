import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char input;
		
		// Maak een object van elke subclass van Attractie
		Attractie botsauto = new Botsauto();
		RisicoRijkeAttractie spin = new Spin();
		Attractie spiegelpaleis = new Spiegelpaleis();
		Attractie spookhuis = new Spookhuis();
		RisicoRijkeAttractie hawaii = new Hawaii();
		Attractie ladderklimmen = new Ladderklimmen();
		
		// Maak ArrayLists van Attractie-objecten en RisicoRijkeAttractie-objecten
		List<Attractie> attractieLijst = new ArrayList<Attractie>();
		List<RisicoRijkeAttractie> rrAttractieLijst = new ArrayList<RisicoRijkeAttractie>();
		
		// Voeg items toe aan betreffende ArrayList
		attractieLijst.add(botsauto);
		attractieLijst.add(spiegelpaleis);
		attractieLijst.add(spookhuis);
		attractieLijst.add(ladderklimmen);
		rrAttractieLijst.add(spin);
		rrAttractieLijst.add(hawaii);
		
		while (true) {
			System.out.println("Toets 1 voor \"Botsauto\", 2 voor \"Spin\", 3 voor \"Spiegelpaleis\", 4 voor \"Spookhuis\", 5 voor \"Hawaii\" of 6 voor \"Ladderklimmen\". ");
			System.out.print("Toets \"o\" voor de omzet, \"k\" voor het aantal verkochte kaartjes of \"b\" voor de Belastinginspecteur. \n");
			input = sc.next().charAt(0);
			switch (input) {
			case '1':
				botsauto.draaien();
				break;
			case '2':
				spin.opstellingsKeuring();
				spin.draaien();
				break;
			case '3':
				spiegelpaleis.draaien();
				break;
			case '4':
				spookhuis.draaien();
				break;
			case '5':
				hawaii.opstellingsKeuring();
				hawaii.draaien();
				break;
			case '6': 
				ladderklimmen.draaien();
				break;
			case 'o':
				Kassa.printOmzet();
				break;
			case 'k':
				Kassa.printKaartjes();
				break;
			case 'b':
				for (Attractie attr : attractieLijst) {
					Belastinginspecteur.belastingCheck(attr);
				}
				for (RisicoRijkeAttractie rrAttr : rrAttractieLijst) {
					Belastinginspecteur.belastingCheck(rrAttr);
				}
				Kassa.belastinginspecteurLangsgeweest++;
				break;
			default:
				System.out.println("Geen geldige invoer.\n");
				continue;
			}
		}
	}
}
