import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
	
	@Test
	public void testPlayer() {
        Player classUnderTest = new Player();
        assertTrue("somePlayerMethod should return 'true'", classUnderTest.somePlayerMethod());
    }
	
}
