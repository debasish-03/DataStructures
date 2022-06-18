package com.infy.ds.array;

import java.util.Arrays;

public class ArraySquareRootDecomposition {

	public static void main(String[] args) {
		int[] arr = {1, 5, 2, 4, 6, 1, 3, 5, 7, 10};
		int block_len = (int)Math.ceil(Math.sqrt(arr.length));
		int[] block = preprocessor(arr, block_len);
		int l = 8, r = 8;
		int temp = l;
		int sum = 0;
		update(block, arr, 8, 0, block_len);
		while(l<=r) {
			if(l%block_len == 0 && l+block_len-1 <= r) {
				sum += block[l/block_len];
				l += block_len;
			} else {
				sum += arr[l];
				l++;
			}
		}
		System.out.println("Sum from "+ temp +" to "+ r +" = "+ sum);
		
		
	}
	private static int[] preprocessor(int[] arr, int block_len) {
		int[] block = new int[block_len];
		Arrays.fill(block, 0);
		for(int i=0; i<arr.length; ++i) {
			block[i/block_len] += arr[i];
		}
		return block;
	}
	static void update(int[] block, int[] arr,int idx, int val, int block_len)
	{
	    int blockNumber = idx / block_len;
	    block[blockNumber] += val - arr[idx];
	    arr[idx] = val;
	}

}
