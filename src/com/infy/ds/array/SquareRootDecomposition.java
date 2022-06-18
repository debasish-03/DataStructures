package com.infy.ds.array;

import java.util.Arrays;


// to find the min element
public class SquareRootDecomposition {

	public static void main(String[] args) {
		int[] arr = {-1, 2, 3, -4, 5, 0, 4, 9, 6, -7, 13};
		int l = 1;
		int r = 9;
		int sqrt = (int) Math.ceil(Math.sqrt(arr.length));
		int ans = Integer.MAX_VALUE;
		int[] blockArr = preprocesor(arr, sqrt);
		while(l <= r) {
			if(l % sqrt == 0 && l+sqrt-1 <= r) {
				ans = Math.min(ans, blockArr[l/sqrt]);
				l += sqrt;
			} else {
				ans = Math.min(ans, arr[l]);
				l++;
			}
		}
		System.out.println("Min ele is: "+ans);
	}
	private static int[] preprocesor(int[] arr, int sqrt) {
		int[] block = new int[sqrt];
		Arrays.fill(block, Integer.MAX_VALUE);
		for(int i=0; i<arr.length; i++) {
			block[i/sqrt] = Math.min(arr[i], block[i/sqrt]);
		}
		return block;
	}
	
}
