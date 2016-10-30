/**
* <h1>ConsoleUi class</h1>
* A class that is used to illuminate the game to console
* <p>
* @param nameX is the variable for player number one
* @param nameO is the variable for player number two
* @param message is variable that is used for entering which
* square for your move
*/

import java.util.Scanner;

public class ConsoleUI{

    private static String nameX, nameO, message;
	
    /**
    * A method that draws the board to console
    * @return board is the char board variable
    */
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

     /**
    * A method that gets user inputs for the 
    * two players and uses global variables
    */
    private static void getUserInputs(){
        System.out.println("Enter the name of Player X:");
        Scanner input = new Scanner(System.in);
        nameX = input.next();
        System.out.println("Enter the name of Player O:");
        nameO = input.next();
    }

    /**
    * A method that checks if a string is a number (numeric)
    * @return str is the string that we check
    */
     public static boolean isNumeric(String str){
        try{
          int d = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe){
          return false;
        }
        return true;
    }


    public static void main(String [] args){
        JSONDB db = new JSONDB();
        String playerMove;
        Scanner input = new Scanner(System.in);

        System.out.println("WELCOME TO A GAME OF TIC TAC TOE");
        getUserInputs();
        

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
            playerMove = input.next();
            if(isNumeric(playerMove)){
                message = ttt.nextTurn(Integer.parseInt(playerMove));
                System.out.println(message);
                System.out.println();
                drawBoard(ttt.getBoard());
            }
            
        }

        if(ttt.checkWinner().equals("X"))
            System.out.println(nameX);
        else if(ttt.checkWinner().equals("O"))
            System.out.println(nameO);
        else
            System.out.println("DRAW!");
    }
	
}