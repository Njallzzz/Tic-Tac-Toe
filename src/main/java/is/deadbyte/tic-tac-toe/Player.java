import java.util.Scanner;

public class Player {

	private static String name;

  public Player(String name) {
		this.name = name;
  }

	public void setName(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

}