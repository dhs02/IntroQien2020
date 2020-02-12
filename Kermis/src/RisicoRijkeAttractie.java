import java.util.Scanner;

abstract class RisicoRijkeAttractie extends Attractie {
	int draaiLimiet;
	void opstellingsKeuring() {
		try {
			if (this.aantalRondes == this.draaiLimiet) {
				throw new ArithmeticException("Draailimiet bereikt.");
			}
		}
		catch (Exception e) {
			System.out.print("De draailimiet is bereikt, er moet een keuring plaatsvinden. Toets \"m\" om een monteur te roepen: ");
			Scanner scan = new Scanner(System.in);
			char userInput = scan.next().charAt(0);
			while (userInput != 'm') {
				System.out.print("Ongeldige invoer. Toets \"m\" om een monteur te roepen: ");
				userInput = scan.next().charAt(0);
			}
			this.aantalRondes = 0;
			System.out.println("De keuring is voltooid. De attractie kan weer draaien.");
		}
	}
}

class Spin extends RisicoRijkeAttractie implements gokAttractie {
	Spin(){
		this.naam = "Spin";
		this.prijs = 2.25;
		this.draaiLimiet = 5;
	}
	
	public void kansSpelBelastingBetalen() {
		double kansSpelBelasting = this.omzet * 0.3;
		Kassa.betaaldeBelasting += kansSpelBelasting;
		
		this.omzet -= kansSpelBelasting;
		Kassa.totaleOmzet -= kansSpelBelasting;
	}
}

class Hawaii extends RisicoRijkeAttractie {
	Hawaii(){
		this.naam = "Hawaii";
		this.prijs = 2.9;
		this.draaiLimiet = 10;
	}
}