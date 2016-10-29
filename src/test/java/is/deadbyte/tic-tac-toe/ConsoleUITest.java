import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

public class ConsoleUITest {

	@Test
	public void drawBoardTest(){
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	 	ConsoleUI drawTest = new ConsoleUI();
	 	char[][] stats = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};

	 	drawTest.drawBoard(stats);

	 	String outputTest = "";


        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                outputTest += String.valueOf(stats[i][j]);
            }
            outputTest += "\n";
        }
        outputTest += "\n";

	 	assertEquals(outputTest, outContent.toString());
	 		
	 	System.setOut(null);
    	}
}