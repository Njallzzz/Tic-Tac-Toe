

public class Player {
    
	private static String name;
	private static char symbol;
	private static boolean hasTurn;
	
	public boolean somePlayerMethod() {
        return true;
    }
	
	public boolean hasTurn() {
		return hasTurn;
	}
	
	public void move() {
		hasTurn = false;
	}
}