package com.infy.ds.searchingandsorting;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {23, 56, 1, 2, 57, 97, 12, 199, 7, 5, 9};
		Arrays.sort(arr);
		for(int i: arr) System.out.print(i+" ");
		System.out.println();
		System.out.println(arr[binarySearch(arr, 0, arr.length-1, 12)]+" present in sorted array(arr) at index "+binarySearch(arr, 0, arr.length-1, 12));
		System.out.println(arr[binarySearch(arr, 199)]+" present at index "+binarySearch( arr, 199)+ " in the sorted array");
	}
	private static int binarySearch(int[] arr,int start, int end, int target) {
		int midIndex = start + (end-start)/2;
		if(arr[midIndex] == target) return midIndex;
		else if(arr[midIndex] < target) return binarySearch(arr, start, midIndex, target);
		else return binarySearch(arr, midIndex, end, target);
		
	}
	private static int binarySearch(int[] arr, int target) {
		// using two pointer approach
		int low = 0, high = arr.length-1;
		while(low <= high) {
			int mid = low+(high-low)/2;
			if(arr[mid] == target) return mid;
			else if(arr[mid] > target) high = mid-1;
			else low = mid+1;
		}
		return -1;
	}

}
