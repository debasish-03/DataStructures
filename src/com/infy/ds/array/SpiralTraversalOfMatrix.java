package com.infy.ds.array;

import java.util.ArrayList;

public class SpiralTraversalOfMatrix {

	public static void main(String[] args) {
		int[][] arr = {{1,    2,   3,   4},
	              	   {5,    6,   7,   8},
	                   {9,   10,  11,  12},
	                   {13,  14,  15,  16 }};
		ArrayList<Integer> res = spriralTraversal(arr);
		for(Integer i: res) {
			System.out.print(i+" ");
		}
		
	}
	private static ArrayList<Integer> spriralTraversal(int[][] arr) {
		ArrayList<Integer> res = new ArrayList<>();
		int top =0, bottom = arr.length-1; 
		int left=0, right=arr[0].length-1;
		int diff =0; // 0=> left - right, 1=> top - bootom, 2 => right-left, 3=> bootom- top
		
		while(top <=bottom && left <= right) {
			
			if(diff == 0) { // left - right traversal
				for(int i=left; i<=right; i++) {
					res.add(arr[top][i]);
				}
				top++;
			} else if(diff == 1) { // top - bootom traversal
				for(int i=top; i<=bottom; i++) {
					res.add(arr[i][right]);
				}
				right--;
			} else if(diff == 2) { // right-left traversal
				for(int i=right; i>=left; i--) {
					res.add(arr[bottom][i]);
				}
				bottom--;
			} else if(diff == 3) {
				for(int i=bottom; i>=top; i--) {
					res.add(arr[i][left]);
				}
				left++;
			}
			
			diff = (diff+1) % 4;
		}
		
		return res;
	}

}
