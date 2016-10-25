import java.until.Scanner;

public class Player {
    
	private static String name;
	private static char symbol;
	private static boolean hasTurn;
	private static int xcord;
	private static int ycord;

	Player() {
		this.name = "";
		this.symbol = '';
		this.hasTurn = false;
	}
	
	public boolean somePlayerMethod() {
        return true;
    }
	
	public boolean hasTurn() {
		return hasTurn;
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

	public void setXCoord(int x) {
		this.xcord = x;
	}

	public int getXCoord() {
		return this.xcord;
	}

	public void setYCoord(int y) {
		this.ycord = y;
	}

	public int getYcoord() {
		return this.ycord;
	}
	
	public void move() {
		int xcoord = 5;
		int ycoord = 5;
		Scanner input = new Scanner(System.in);
		if ( this.hasTurn ) {
			System.out.print("Input 0, 1 or 2 for x coordinates");
			while (xcoord < 0 && xcoord > 3) {
				xcoord = input.next();	
			}

			System.out.print("Input 0, 1 or 2 for y coordinates");
			while (ycoord < 0 && ycoord > 3) {
				ycoord = input.next();
			}

			setXCoord(xcoord);
			setYCoord(ycoord);
			hasTurn = false;
		} else {
			System.out.print("It is not your move.");
		}
	}
	
}
