

public class TicTacToe implements Game{

	private char[][] board;
	public void nextTurn(int tablePos){};

	public TicTacToe(){
		initializeGame();
	}

	public char[][] getBoard(){
		return board;
	}

	public void initializeGame(){

		board = new char[3][3];
		for(int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				board[i][j] = (char)((i * 3) + j + 1);
			}
		}
	}

	public boolean isValid(){
		return false;
	}
}
