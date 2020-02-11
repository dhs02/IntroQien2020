abstract class RisicoRijkeAttractie extends Attractie {
	int draaiLimiet;
	abstract void opstellingsKeuring();
}

class Spin extends RisicoRijkeAttractie implements gokAttractie {
	Spin(){
		this.naam = "Spin";
		this.prijs = 2.25;
		this.draaiLimiet = 5;
	}
	
	void opstellingsKeuring() {
		if (this.aantalKaartjes > this.draaiLimiet) {
			// throw Exception;
		}
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
	void opstellingsKeuring() {
	}
}