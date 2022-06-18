package com.infy.ds.array;

public class FindTheBestPosToInsertInSortedArray {

	public static void main(String[] args) {
		int[] arr= {1,2,4,7};
		System.out.println(bestInsertPos(arr, arr.length, 6));

	}

		public static int bestInsertPos(int [] arr, int n, int m){
			// Write your code here.
	        int left=0, right=n-1;
	        while(left <= right) {
	            int mid = left+(right-left)/2;
	            if(arr[mid] == m) {
	                return mid;
	            } else if(arr[mid] > m) {
	                right = mid-1;
	            } else {
	                left = mid+1;
	            }
	        }
	        return left+(right-left)/2;
		}
	


}
