package com.infy.ds.recursionandbacktracking;

import java.util.ArrayList;
import java.util.Arrays;


public class NQueen {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = nQueen(5);
		System.out.println(String.valueOf(res));

	}
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] ch: board) {
            Arrays.fill(ch, '.');
        }
        solve(0, board, n, res);
        return res;
    }
    static void solve(int row, char[][] board, int n, ArrayList<ArrayList<Integer>> res) {
        if(row == n) {
            ArrayList<Integer> ans = new ArrayList<>();
            for(char[] ch: board) {
                for(int i=0; i<ch.length; i++) {
                	if(ch[i] == 'Q') ans.add(i+1);
                }
            }
            res.add(ans);
            return;
        }
        for(int col=0; col<n; col++) {
            if(isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(row+1, board, n, res);
                board[row][col] = '.';
            }
        }
    }
    static boolean isSafe(char[][] board, int row, int col, int n) {
        for(int i=0; i<row; i++) {
            if(board[i][col] == 'Q') return false;
        }
        for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }
        for(int i=row, j=col; i>=0 && j<n; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
}
