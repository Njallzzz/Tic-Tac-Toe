public class ConsoleUI{
	
	/*
    * draw prints the tic-tac-toe board with available moves, and moves already made.
    * @param board contains moves made, and available moves in a two dimensional 
    * array, board[line][column]
    */
    public void drawBoard(char[][] board){
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
	}
}