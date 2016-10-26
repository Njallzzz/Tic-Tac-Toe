import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

	@Test
	public void testPlayer() {
        Player player = new Player("Baldur");

        assertEquals(player.getName(), "Baldur");
    }

	@Test
	public void testName() {
		Player player = new Player("");

		player.setName("Gulli");

		assertEquals("Gulli", player.getName());
	}

}
