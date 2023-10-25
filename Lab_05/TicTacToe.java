package Lab_05;

public class TicTacToe {
	    private static final char EMPTY = ' ';
	    private char[][] board;

	    public TicTacToe(char[][] board) {
	        this.board = board;
	    }
	    //Task 2.1
	    public boolean checkRows() {
	        for (int row = 0; row < board.length; row++) {
	            if (board[row][0] != EMPTY && board[row][0] == board[row][1] &&
	            		board[row][0] == board[row][2]) {
	                return true;
	            }
	        }
	        return false;
	    }
	    //Task 2.2
	    public boolean checkColumns() {
	        for (int col = 0; col < board[0].length; col++) {
	            if (board[0][col] != EMPTY && board[0][col] == board[1][col] && 
	            		board[0][col] == board[2][col]) {
	                return true;
	            }
	        }
	        return false;
	    }
	    //Task 2.3
	    public boolean checkDiagonals() {
	        // Check top-left to bottom-right
	        if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
	            return true;
	        }
	        
	        // Check bottom-left to top-right
	        if (board[2][0] != EMPTY && board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
	            return true;
	        }
	        
	        return false;
	    }

	    public static void main(String[] args) {
	    	 char[][] board = {{'O', 'O', 'O'}, 
	    			           {'X', ' ', 'X'}, 
	    			           {'X', 'X', 'X'}};
	         TicTacToe test = new TicTacToe(board);
	        System.out.println("Check Rows: " + test.checkRows()); // Expected output: true
	        System.out.println("Check Columns: " + test.checkColumns()); // Expected output: false
	        System.out.println("Check Diagonals: " + test.checkDiagonals()); // Expected output: false
	    }

}
