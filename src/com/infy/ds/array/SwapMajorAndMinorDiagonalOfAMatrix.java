package com.infy.ds.array;

public class SwapMajorAndMinorDiagonalOfAMatrix {

	public static void main(String[] args) {
		int[][] matrix ={{0, 1, 2},
						 {3, 4, 5},
						 {6, 7, 8}};
		
		swapDiagonal(matrix);
		for(int i=0; i<matrix.length;i++) {
			for(int j=0; j<matrix.length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void swapDiagonal(int[][] arr) {
		int n = arr.length;
		for(int i=0; i<n; i++) {
			int temp = arr[i][i];
			arr[i][i] = arr[i][n-i-1];
			arr[i][n-i-1] = temp;
		}
	}
}
