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
                //output += String.valueOf(board[i][j]);
                System.out.print(board[i][j]);
            }
            System.out.println();
            //output += "\n";
        }

        //System.out.println(output);
    }

	public static void main(String [] args){
        
        String nameX, nameO, message, checkWinner;

        System.out.println("WELCOME TO A GAME OF TIC TAC TOE");
        System.out.println("Enter the name of Player X:");
        Scanner input = new Scanner(System.in);
        nameX = input.next();
        System.out.println("Enter the name of Player O:");
        nameO = input.next();

        TicTacToe ttt = new TicTacToe(nameX, nameO);
        drawBoard(ttt.getBoard());
        nameX = ttt.getPlayerX().getName();
        nameO = ttt.getPlayerO().getName();

        while(!ttt.checkWinner().equals("X") && !ttt.checkWinner().equals("O") && !ttt.checkBoardFull()){

            if (ttt.playerXTurn){
                System.out.println(nameX + " select a number between 1-9: ");
            }
            else{
                System.out.println(nameO + " select a number between 1-9: ");
            }

            message = ttt.nextTurn(input.nextInt());
            System.out.println(message);
            
            drawBoard(ttt.getBoard());
        }

        if(ttt.checkWinner().equals("X"))
            System.out.println(nameX);
        else if(ttt.checkWinner().equals("O"))
            System.out.println(nameO);
        else
            System.out.println("DRAW!");
	}
}