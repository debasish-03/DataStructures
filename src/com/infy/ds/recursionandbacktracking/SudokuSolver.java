package com.infy.ds.recursionandbacktracking;

public class SudokuSolver {

	public static void main(String[] args) {
		char[][] board = new char[][] {{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};
				//{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		new SudokuSolver().solve(board);
		for (int r = 0; r < board.length; r++)
        {
            for (int d = 0; d < board.length; d++)
            {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");
 
            if ((r + 1) % (int)Math.sqrt(board.length) == 0)
            {
                System.out.print("");
            }
        }
	}
//	    public void solveSudoku(char[][] board) {
//	        solve(board);
//	       
//	    }
	    boolean solve(char[][] board) {
	        
	        int row = -1, col = -1; //we will try to finf the empty square in sudoko
	        boolean isEmpty = true;
	        for(int r=0; r<board.length; r++) {
	            for(int c=0; c<board.length; c++) {
	                if(board[r][c] == '.') {
	                    isEmpty = false;
	                    row = r;
	                    col = c;
	                    break;
	                }
	            }
	            if(!isEmpty) {
	                break;
	            }
	        }
	        if(isEmpty) {
	            return true;
	        }
	        for(char num='1'; num<= '9'; num++) {
	            
	            if(isSafe(board, row, col, num)) {
	                board[row][col] = num;
	                if(solve(board)){
	                    return true;
	                }else{
	                    board[row][col] = '.';
	                }
	            } 
	        }
	        return false;
	    }
	    private static boolean isSafe(char[][] board, int row, int col, char num) {
	        // first we will check the rows if the number is present or not
	    
	        for(int r=0; r<board.length; r++) {
	            if(board[row][r] == num) {
	                return false;
	            }
	        }
	        // column level check
	        for(int c=0; c<board.length; c++) {
	            if(board[c][col] == num) {
	                return false;
	            }
	        }
	        // 3*3 square matrix check
	        
	        int sqrt = (int) Math.sqrt(board.length);
	        int boxrow = row - row%sqrt;
	        int boxcol = col - col%sqrt;
	        for(int i=boxrow ; i<boxrow+sqrt; i++) {
	            for(int j=boxcol; j<boxcol+sqrt; j++) {
	                if(board[i][j] == num) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
}





