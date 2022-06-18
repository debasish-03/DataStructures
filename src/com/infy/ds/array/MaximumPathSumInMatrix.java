package com.infy.ds.array;
 import static java.lang.Math.max;
public class MaximumPathSumInMatrix {

	public static void main(String[] args) {
		/*int mat[][] = { { 10, 10, 2, 0, 20, 4 },
                { 1, 0, 0, 30, 2, 5 },
                { 0, 10, 4, 0, 2, 0 },
                { 1, 0, 2, 20, 0, 4 }
            };
*/
		int mat[][] = {{1, 2, 3},
                {9, 8, 7},
                {4, 5, 6}};
		System.out.println(findMaxPath(mat));
	}
	private static int findMaxPath(int[][] mat) {
		int res = Integer.MIN_VALUE;
		int row = mat.length;
		int col = mat[0].length;
		// find the max ele in 1st row
		for(int i=0; i<col; i++) {
			res = max(res, mat[0][i]);
		}
		// find max for remaining
		for(int i=1; i<row; i++) {
			res = Integer.MIN_VALUE;
			for(int j=0; j<col; j++) {
				if(j>0 && j<col-1) {
					mat[i][j] += max(mat[i-1][j],max(mat[i-1][j-1], mat[i-1][j+1]));
				} else if (j>0) {
					mat[i][j] += max(mat[i-1][j], mat[i-1][j-1]);
				} else if(j < col-1) {
					mat[i][j] += max(mat[i-1][j], mat[i-1][j+1]);
				}
				res = max(res, mat[i][j]);
				System.out.println(res);
			}
		}
		System.out.println("Final res");
		return res;
	}
}
