class Attractie {
	String naam;
	double omzet;
	int aantalKaartjes;
	int aantalRondes;
	
	double prijs;
	double oppervlakte;
	
	void draaien() {
		System.out.println("De attractie " + "\"" + naam + "\"" + " draait.\n");
		omzet += prijs;
		aantalRondes++;
		aantalKaartjes++;
		Kassa.totaleOmzet += prijs;
		Kassa.totaleKaartjes++;
	}
}

interface gokAttractie {
	void kansSpelBelastingBetalen();
}

class Botsauto extends Attractie {
	Botsauto(){
		this.naam = "Botsauto";
		this.prijs = 2.5;
	}
}

class Spiegelpaleis extends Attractie {
	Spiegelpaleis(){
		this.naam = "Spiegelpaleis";
		this.prijs = 2.75;
	}
}

class Spookhuis extends Attractie {
	Spookhuis(){
		this.naam = "Spookhuis";
		this.prijs = 3.2;
	}
}

class Ladderklimmen extends Attractie implements gokAttractie {
	
	Ladderklimmen(){
		this.naam = "Ladderklimmen";
		this.prijs = 5;
	}

	public void kansSpelBelastingBetalen() {
		double kansSpelBelasting = this.omzet * 0.3;
		Kassa.betaaldeBelasting += kansSpelBelasting;
		
		this.omzet -= kansSpelBelasting;
		Kassa.totaleOmzet -= kansSpelBelasting;
	}
}