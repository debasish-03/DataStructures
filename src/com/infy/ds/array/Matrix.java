package com.infy.ds.array;

public class Matrix {
	  public void setZeroes(int[][] matrix) {
	    Boolean isCol = false;
	    int R = matrix.length;
	    int C = matrix[0].length;

	    for (int i = 0; i < R; i++) {

	      // Since first cell for both first row and first column is the same i.e. matrix[0][0]
	      // We can use an additional variable for either the first row/column.
	      // For this solution we are using an additional variable for the first column
	      // and using matrix[0][0] for the first row.
	      if (matrix[i][0] == 0) {
	        isCol = true;
	      }

	      for (int j = 1; j < C; j++) {
	        // If an element is zero, we set the first element of the corresponding row and column to 0
	        if (matrix[i][j] == 0) {
	          matrix[0][j] = 0;
	          matrix[i][0] = 0;
	        }
	      }
	    }

	    // Iterate over the array once again and using the first row and first column, update the elements.
	    for (int i = 1; i < R; i++) {
	      for (int j = 1; j < C; j++) {
	        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
	          matrix[i][j] = 0;
	        }
	      }
	    }

	    // See if the first row needs to be set to zero as well
	    if (matrix[0][0] == 0) {
	      for (int j = 0; j < C; j++) {
	        matrix[0][j] = 0;
	      }
	    }

	    // See if the first column needs to be set to zero as well
	    if (isCol) {
	      for (int i = 0; i < R; i++) {
	        matrix[i][0] = 0;
	      }
	    }
	  }
	}




class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(matrix[i][j] == 0) {
                    int ind = i-1;
                    while(ind >=0 ){ // row above 
                        if(matrix[ind][j] != 0) {
                            matrix[ind][j] = -1;
                        }
                        ind--;
                    }
                    
                    ind = i+1;
                    while(ind < row) { // row below
                        if(matrix[ind][j] != 0) {
                            matrix[ind][j] = -1;  
                        }
                        ind++;
                    }
                    
                    ind = j-1;
                    while(ind >= 0) {
                        if(matrix[i][ind] != 0) {
                            matrix[i][ind] = -1;
                        }
                        ind--;
                    }
                    ind = j+1;
                    while(ind < col) {
                        if(matrix[i][ind] != 0) {
                            matrix[i][ind] = -1;
                        }
                        ind++;
                    }
                }
            }
        }
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    /*
    // opt solution
    static void setZeroes(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }
    } */
}
