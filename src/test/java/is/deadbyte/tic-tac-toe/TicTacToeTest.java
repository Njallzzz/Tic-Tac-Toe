
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

public class TicTacToeTest {

    @Test public void interFaceTest() {
    	
        Game interFaceTest = new TicTacToe();

        assertThat(interFaceTest, instanceOf(TicTacToe.class));
    }
}