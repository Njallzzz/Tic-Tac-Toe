import org.junit.Test;
import static org.junit.Assert.*;


public class BoardTest {
	
	private static final int size = 3;
	
    @Test
	public void testBoardMethood() {
        Board board = new Board(size);
        assertTrue("boardMethood should return 'true'", board.boardMethood());
    }
    
    @Test
	public void testBoardConstructor() {
    	
    	Board board = new Board(size);
    	
    	char[][] testBoard = new char[3][3];
    	
    	int counter = 1;

    	for (int i = 0; i < 3; i++)
    	{
    		for (int j = 0; j < 3; j++)
    		{
    			testBoard[i][j] = (char) counter;
    			counter++;	
    		}	
    	}

    	assertArrayEquals(testBoard, board.getBoard());
    	
    }
}
