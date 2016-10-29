import java.util.Scanner;

public class ConsoleUI{
	
	/*
    * draw prints the tic-tac-toe board with available moves, and moves already made.
    * @param board contains moves made, and available moves in a two dimensional 
    * array, board[line][column]
    */
    public static void drawBoard(char[][] board){
        String output = "";

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                output += String.valueOf(board[i][j]);
            }
            output += "\n";
        }

        System.out.println(output);
    }

	public static void main(String [] args){
        
        String nameX, nameO;

        System.out.println("WELCOME TO A GAME OF TIC TAC TOE");
        System.out.println("Enter the name of Player X:");
        Scanner input = new Scanner(System.in);
        nameX = input.next();
        System.out.println("Enter the name of Player O:");
        nameO = input.next();


        TicTacToe ttt = new TicTacToe(nameX, nameO);
        drawBoard(ttt.getBoard());


        while(true){

        }


	}
}