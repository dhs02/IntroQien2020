public class Belastinginspecteur {
	
	static void belastingCheck(Attractie a) {
		if (a instanceof gokAttractie) {
			((gokAttractie) a).kansSpelBelastingBetalen();
		}
	}
}