

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

	/*
	* 
	*/
	public boolean isValid(int row, int col){
		return(board[row][col] != 'X' || board[row][col] != 'O');
	}

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
		
		return "illegal play, try again";
	}
}
