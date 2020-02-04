class Hallo{
	public static void main(String[] args){
		new Fiets().hoi();
		String voorbeeld = "fred";
		String upper = voorbeeld.toUpperCase();
		System.out.println(upper);
		String lower = voorbeeld.toLowerCase();
		System.out.println(lower);
	}
}

class Koe{
	void hoi(){
		System.out.println("oeps");
	}
}

class Fiets{
	void hoi(){
		System.out.println("ai");
	}
}




