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

	public TicTacToe(){
		initializeGame();
	}

	public char[][] getBoard(){
		return board;
	}

	public void initializeGame(){
		playerXTurn = true;
		board = new char[3][3];
		for(int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				board[i][j] = (char)((i * 3) + j + 1);
			}
		}
	}

	/**
	* A method that tells if a play is valid
	* @return boolean true if a play is valid, else false
	*/
	public boolean isValid(int row, int col){
		return(board[row][col] != 'X' && board[row][col] != 'O');
	}

	/**
	* Method that uses if statement's to figure which player turn it is
	* @param tablePos is the play position made by player
	* @param row is an integer value for the corresponding row of a play made on board
	* @param col is an integer value for the corresponding column of a play made on board
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



}
