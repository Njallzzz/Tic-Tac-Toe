import java.util.Scanner;

public class Player {

	private static String name;

  /**
  * Constructor for Player class
  *
  * @param name  name of the player
  */
  public Player(String name) {
		this.name = name;
  }

  /**
  * Setter for Player Class name
  * @param n  new name for Player
  */
	public void setName(String n) {
		name = n;
	}

  /**
  * Getter for Player Class name
  *
  * @return name of Player
  */
	public String getName() {
		return name;
	}

}
