import org.junit.Test;
import static org.junit.Assert.*;


public class BoardTest {

    @Test
	public void testBoardMethood() {
        Board board = new Board();
        assertTrue("boardMethood should return 'true'", board.boardMethood());
    }
}
