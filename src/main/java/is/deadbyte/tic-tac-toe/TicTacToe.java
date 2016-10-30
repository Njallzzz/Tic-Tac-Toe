/**
* <h1>Tic Tac Toe Class</h1>
* A class that contains all basic functions for the game Tic Tac Toe
*/

public class TicTacToe implements Game{

	private char[][] board;
	private Player playerX, playerO;
	private boolean playerXTurn;
/**
* Constructor for Tic Tac Toe Game
* @param pX Player 1 name
* @param pO Player 2 name
*/
	public TicTacToe(String pX, String pO){
		initializeGame();
		initializePlayers(pX, pO);
	}

	public boolean getPlayerXTurn(){
		return playerXTurn;
	}

	public char[][] getBoard(){
		return board;
	}

	public Player getPlayerX(){
		return playerX;
	}

	public Player getPlayerO(){
		return playerO;
	}

	public void initializePlayers(String pX, String pO){
		playerX = new Player(pX);
		playerO = new Player(pO);
	}

	/**
	* Method that creates an empty tic tac toe board
	* inserts values 1 - 9 in corresponding squares
	*/
	public void initializeGame(){
		playerXTurn = true;
		board = new char[3][3];
		for(int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				board[i][j] = (char)((i * 3) + j + 49);
			}
		}
	}

	/**
	* A method that tells if a play is valid
	* @param row number starting at 0 and ending at 2
	* @param col number starting at 0 and ending at 2
	* @return boolean true if a play is valid, else false
	*/
	public boolean isValid(int row, int col){
		if ((row < 3 && row >= 0) && (col < 3 && col >= 0)){

			if ((board[row][col] != 'X') && (board[row][col] != 'O')){
				return true;
			}
		}
			
		return false;
	}

	/**
	* Method that uses if statement's to figure which player turn it is
	* @param tablePos is the play position made by player
	* @return String which tells where and what player just played or if an illegal play was made
	*/
	public String nextTurn(int tablePos){

		int row = (tablePos -1) / 3;
		int col = (tablePos -1) % 3;
		if(playerXTurn && isValid(row,col)){
			board[row][col] = 'X';
			playerXTurn = false;
			return "'X' was placed successfully at "+row+","+col;
		}
		else if(playerXTurn == false && isValid(row,col)){
			board[row][col] = 'O';
			playerXTurn = true;
			return "'O' was placed successfully at "+row+","+col;
		}
		
		return "Illegal play, try again";
	}

	/**
	* Method that checks if board is full
	* @return returns false if board is not full, else true
	*/
	public boolean checkBoardFull(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] != 'X' && board[i][j] != 'O'){
					return false;
				}
			}
		}
		return true;
	}
	/**
	* Method that checks who is the winner of the game
	* @return return the string "No Winner" if there is a draw
	* else returns x or o
	*/
	public String checkWinner(){

		char turn = 'X';
		if (playerXTurn == true){
			turn = 'O';
		}
		
		for (int i = 0; i < 3; i++){
			
			int counthorizontal = 0;
			int countvertical = 0;

			for (int j = 0; j < 3; j++){

				if (board[i][j] == turn){
					counthorizontal++;
				}
				if (board[j][i] == turn){
					countvertical++;
				}
			}

			if ((counthorizontal == 3) || (countvertical == 3)){
				return String.valueOf(turn);
			}
		}
		
		if((board[0][0] == board[1][1]) && board[1][1] == board[2][2]){
			return String.valueOf(turn);
		}
		if((board[0][2] == board[1][1]) && board[1][1] == board[2][0]){
			return String.valueOf(turn);
		}
		return "No Winner";
	}
}
