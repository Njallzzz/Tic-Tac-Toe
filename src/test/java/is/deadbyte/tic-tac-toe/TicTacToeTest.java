
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

public class TicTacToeTest {

    @Test 
    public void interFaceTest() {

        Game interFaceTest = new TicTacToe("","");

        assertThat(interFaceTest, instanceOf(TicTacToe.class));
    }

    @Test 
    public void initializeGameTest(){

    	TicTacToe ticTest  =new TicTacToe("","");
    	char[][] boardTest = new char[3][3];

    	for(int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				boardTest[i][j] = (char)((i * 3) + j + 49);
			}
		}

    	assertArrayEquals(boardTest, ticTest.getBoard());
    }

    @Test
    public void isValidTest(){

    	TicTacToe ticTest  = new TicTacToe("","");
    	assertTrue(ticTest.isValid(0,0));
    }

    @Test
    public void isNotValidTest(){

        TicTacToe ticTest  =new TicTacToe("","");
        ticTest.nextTurn(1);
        assertFalse(ticTest.isValid(0,0));
    }

    /*
    * Test inserting a legal, first move in row 0, column 1
    */
    @Test
    public void nextTurnTest(){

    	TicTacToe ticTest  = new TicTacToe("","");

    	assertEquals("'X' was placed successfully at 0,1", ticTest.nextTurn(2));
    }

    /*
    * Test inserting a legal, second move in row 1, column 1
    */
    @Test
    public void nextTurnTestSecondMove(){

        TicTacToe ticTest  = new TicTacToe("","");
        ticTest.nextTurn(1);
        assertEquals("'O' was placed successfully at 1,1", ticTest.nextTurn(5));
    }

    /*
    * Test inserting illegal, second move in row 1, column 1
    */
    @Test
    public void nextTurnTestIllegalMove(){

        TicTacToe ticTest  = new TicTacToe("","");
        ticTest.nextTurn(5);
        assertEquals("Illegal play, try again", ticTest.nextTurn(5));
    }

    @Test
    public void nextTurnTestIllegalMoveOutOfScope(){

        TicTacToe ticTest  = new TicTacToe("","");
        assertFalse(ticTest.isValid(-1,-1));
    }

    @Test
    public void checkBoardFullTestWithEmptyBoard(){
        TicTacToe ticTest  = new TicTacToe("","");
        assertFalse(ticTest.checkBoardFull());
    }

    @Test
    public void checkBoardFullTestWithFullBoard(){
        TicTacToe ticTest  = new TicTacToe("","");

        for(int i = 1; i < 10; i++){
            ticTest.nextTurn(i);
        }

        assertTrue(ticTest.checkBoardFull());
    }

    @Test
    public void checkWinnerHorizontal(){
        TicTacToe ticTest  = new TicTacToe("","");
        ticTest.nextTurn(4);
        ticTest.nextTurn(1);
        ticTest.nextTurn(5);
        ticTest.nextTurn(2);
        ticTest.nextTurn(9);
        ticTest.nextTurn(3);
        assertEquals("O", ticTest.checkWinner());
    }

    @Test
    public void checkWinnerVertical(){
        TicTacToe ticTest  = new TicTacToe("","");
        ticTest.nextTurn(1);
        ticTest.nextTurn(2);
        ticTest.nextTurn(3);
        ticTest.nextTurn(5);
        ticTest.nextTurn(9);
        ticTest.nextTurn(8);
        assertEquals("O", ticTest.checkWinner());
    }

    @Test
    public void checkWinnerDiagonal(){
        TicTacToe ticTest  = new TicTacToe("","");
        ticTest.nextTurn(1);
        ticTest.nextTurn(2);
        ticTest.nextTurn(5);
        ticTest.nextTurn(3);
        ticTest.nextTurn(9);
        assertEquals("X", ticTest.checkWinner());
    }

    @Test
    public void checkWinnerNoWinner(){
        TicTacToe ticTest  = new TicTacToe("","");
        ticTest.nextTurn(1);
        ticTest.nextTurn(2);
        assertEquals("No Winner", ticTest.checkWinner());
    }
}