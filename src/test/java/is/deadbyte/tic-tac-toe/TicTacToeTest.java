
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

public class TicTacToeTest {

    @Test 
    public void interFaceTest() {

        Game interFaceTest = new TicTacToe();

        assertThat(interFaceTest, instanceOf(TicTacToe.class));
    }

    @Test 
    public void initializeGameTest(){

    	TicTacToe ticTest  =new TicTacToe();
    	char[][] boardTest = new char[3][3];

    	assertArrayEquals(boardTest, ticTest.getBoard());
    }
}