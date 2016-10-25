import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest 
{
    @Test public void interFaceTest() 
    {
        Game interFaceTest = new Game();

        assertObjectIsClass(interFaceTest, TicTacToe);
    }
}