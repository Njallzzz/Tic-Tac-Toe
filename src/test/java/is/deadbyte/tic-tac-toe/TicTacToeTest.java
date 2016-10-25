
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

    	for(int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				boardTest[i][j] = (char)((i * 3) + j + 1);
			}
		}

    	assertArrayEquals(boardTest, ticTest.getBoard());
    }
}