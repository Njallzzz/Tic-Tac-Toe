import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

	@Test
	public void testPlayer() {
        Player player = new Player("Baldur");

        //assertFalse("The initialized state of player returns hasTurn 'false'", player.hasTurn());
        assertTrue("somePlayerMethod should return 'true'", player.somePlayerMethod());
    }

	@Test
	public void testName() {
		Player player = new Player();

		player.setName("Gulli");

		assertEquals("Gulli", player.getName());
	}

}
