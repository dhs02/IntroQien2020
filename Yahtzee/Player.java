import java.util.ArrayList;

public class Player {
	    private final String name;
	    int turnsLeft = 3;
	    
	    ArrayList<int[]> resultHistory = new ArrayList<int[]>(); 

	    Player(String name){
	        this.name = name;
	    }

	    String getName(){
	        return name;
	    }
	    
	    void setTurnsLeft (int turns){
	    	this.turnsLeft = turns;
	    }
}