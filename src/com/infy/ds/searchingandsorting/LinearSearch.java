package com.infy.ds.searchingandsorting;

public class LinearSearch {

	public static void main(String[] args) {
		int[] arr = {10, 90, 1, 5, 8, 2, 8, 34, 67, 12};
		System.out.print(arr[linearSearch(arr, 34)]+" present at index "+linearSearch(arr, 10));
	}
	private static int linearSearch(int[] arr, int target) {
		for(int i=0; i<arr.length;i++) {
			if(arr[i] == target) return i;
		}
		return -1;
	}

}
