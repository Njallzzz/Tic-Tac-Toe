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
		
		assertFalse("hasTurn should return 'false'", player1.hasTurn());
	}
	
	@Test
	public void testName(){
		Player player = new Player();
		player.giveName("Gulli");
		
		assertEquals("Gulli", player.getName());
	}
	
	@Test
	public void testSymbol(){
		Player player = new Player();
		player.setSymbol("x");
		
		assertEquals("x", player.getSymbol());
	}
}
