package com.infy.ds.array;

public class ShortestUnOderedSubArray {

	public static void main(String[] args) {
		int[] arr = {6, 5, 4, 3, 2, 1};
		System.out.println("Shorted Un-Ordered subarray is: "+ solve(arr));
	}
	private static int solve(int[] arr) {
		if(increasingOrder(arr) == true || decreasingOrder(arr) == true) {
			return 0;
		}
		return 3;
	}
	private static boolean increasingOrder(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] > arr[i+1]) 
				return false;
		}
		return true;
	}
	private static boolean decreasingOrder(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] < arr[i+1]) 
				return false;
		}
		return true;
	}

}
