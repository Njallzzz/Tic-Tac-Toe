import java.util.Scanner;

public class Player {
    
	private static String name;
	private static char symbol;

	public Player() {
		this.name = "";
		this.symbol = ' ';
	}
	
	public boolean somePlayerMethod() {
        return true;
    }
	
	public void setName(String n) {
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
	
}
