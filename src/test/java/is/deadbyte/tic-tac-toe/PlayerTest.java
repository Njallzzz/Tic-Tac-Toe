import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
	
	@Test
	public void testPlayer() {
        Player classUnderTest = new Player();
        assertTrue("somePlayerMethod should return 'true'", classUnderTest.somePlayerMethod());
    }
	
	@Test
	public void testMove() {
		Player player1 = new Player();
		player1.move();
		
		assertTrue("hasTurn should return 'false'", player1.hasTurn());
	}
}
