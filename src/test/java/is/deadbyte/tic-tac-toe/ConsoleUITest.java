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
	 		
	 	String output = "       |    |    \n"
	        +"    "+stats[0][0]+"  | "+stats[0][1]+"  | "+stats[0][2]+"\n"
	        +"   ____|____|____\n"
	        +"       |    |    \n"
	        +"    "+stats[1][0]+"  | "+stats[1][1]+"  | "+stats[1][2]+"\n"
	        +"   ___ |___ |____\n"
	        +"       |    |    \n"
	        +"    "+stats[2][0]+"  | "+stats[2][1]+"  | "+stats[2][2]+"\n"
	        +"       |    |    \n";

	 	assertEquals(output, outContent.toString());
	 		
	 	System.setOut(null);
    	}
}