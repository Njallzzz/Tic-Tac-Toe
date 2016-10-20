

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
	
	public void giveName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSymbol(char s) {
		symbol = s;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public void move() {
		hasTurn = false;
	}
	
}
