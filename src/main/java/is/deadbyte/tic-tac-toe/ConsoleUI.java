import java.util.Scanner;

public class ConsoleUI{
	
    public static void drawBoard(char[][] board){
         String output = "";

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                output += String.valueOf(board[i][j])+" ";
            }

            output += "\n";
        }

        System.out.println(output);
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
        nameX = ttt.getPlayerX().getName();
        nameO = ttt.getPlayerO().getName();

        System.out.println();
        System.out.println();

        drawBoard(ttt.getBoard());

        while(!ttt.checkWinner().equals("X") && !ttt.checkWinner().equals("O") && !ttt.checkBoardFull()){

            if (ttt.getPlayerXTurn()){
                System.out.println(nameX + " select a number between 1-9: ");
            }
            else{
                System.out.println(nameO + " select a number between 1-9: ");
            }

            message = ttt.nextTurn(input.nextInt());
            System.out.println(message);
            
            System.out.println();
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