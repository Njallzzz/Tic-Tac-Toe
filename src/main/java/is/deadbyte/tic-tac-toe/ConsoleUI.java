import java.util.Scanner;

public class ConsoleUI{
	
    public void drawBoard(char[][] board){
         String output = "";

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                output += String.valueOf(board[i][j])+" ";
            }

            output += "\n";
        }

        System.out.println(output);
    }
	
}