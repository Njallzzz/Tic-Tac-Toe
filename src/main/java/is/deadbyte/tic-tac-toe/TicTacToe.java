/**
* <h1>Tic Tac Toe Class</h1>
* A class that contains all basic functions for the game Tic Tac Toe
* <p>
* @param board contains all moves made by players
* @param playerX,playerO has player name
* @param playerXTurn stores who's turn it is
*/

public class TicTacToe implements Game{

	private char[][] board;
	private Player playerX, playerO;
	private boolean playerXTurn;

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
	}

	/**
	* A method that tells if a play is valid
	* @return boolean true if a play is valid, else false
	*/
	public boolean isValid(int row, int col){
		return true;
	}

	/**
	* Method that uses if statement's to figure which player turn it is
	* @return String which tells where and what player just played or if an illegal play was made
	*/
	public String nextTurn(int tablePos){
		return "";
	}

	/**
	* Method that checks if board is full
	* @return returns false if board is not full, else true
	*/
	public boolean checkBoardFull(){
		return true;
	}

	/**
	* Method that checks who is the winner of the game
	* @return return the string "No Winner" if there is a draw
	* else returns x or o
	*/
	public String checkWinner(){
		return "";
	}
}