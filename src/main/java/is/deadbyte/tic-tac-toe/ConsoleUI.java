/**
* <h1>ConsoleUi class</h1>
* A class that is used to illuminate the game Tic Tac Toe to console
*/

import java.util.Scanner;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONArray;

public class ConsoleUI{

    private static String nameX, nameO, message;
	
    /**
    * A method that draws the board to console
    *
    * @param board contains all moves made by users
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
    * A method that gets user inputs for the two players
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
    *
    * @param str is the string that we check
    * @param str is the string that we check
    * @return true if string is numeric / else false
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

    /**
    * The main method to run Tic Tac Toe in console. 
    * It uses database JSON to store names with wins and losses.
    *
    * @param args is not used
    */
    public static void main(String [] args){
        JSONDB db;
        try{
            db = new JSONDB();
        } catch (IOException e) {
            System.out.println("Unable to access database");
           return;
        }
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

        if(ttt.checkWinner().equals("X")){
            System.out.println(nameX);
            try{
                db.addPlayer(nameX);
                db.addPlayer(nameO);
                db.addWin(nameX);
                db.addLoss(nameO);
            } 
            catch (IOException e){
                System.out.println("Unable to access database");
            }
        }
        else if(ttt.checkWinner().equals("O")){
            System.out.println(nameO);
            try{
                db.addPlayer(nameO);
                db.addPlayer(nameX);
                db.addWin(nameO);
                db.addLoss(nameX);
            }
            catch (IOException e){
                System.out.println("Unable to access database");
            }
        }
        else{
            System.out.println("DRAW!");
        }
    }
	
}
