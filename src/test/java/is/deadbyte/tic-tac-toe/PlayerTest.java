import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
	
	@Test
	public void testPlayer() {
        Player player = new Player();

        assertFalse("The initialized state of player returns hasTurn 'false'", player.hasTurn());
        //assertTrue("somePlayerMethod should return 'true'", player.somePlayerMethod());
    }
	
	@Test
	public void testMove() {
		Player player1 = new Player();

		player1.move();

		assertFalse("hasTurn should return 'false'", player1.hasTurn());
	}
	
	@Test
	public void testName() {
		Player player = new Player();

		player.setName("Gulli");
		
		assertEquals("Gulli", player.getName());
	}
	
	@Test
	public void testSymbol() {
		Player player1 = new Player();

		player1.setSymbol('X');
		
		assertEquals('X', player1.getSymbol());
	}

	@Test
	public void testMoev() {
		Player player = new Player();

		assertEquals("It is not your move.", player.move());
	}
}
