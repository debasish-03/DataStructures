package com.infy.ds.array;

public class DutchNationalFlagAlgo {

	public static void main(String[] args) {
		int[] arr = {1, 2, 0, 0, 1, 2, 1, 0, 2, 1, 2, 0, 0};
		int n=arr.length;
		dnfa(arr, n);
		for(int i: arr) {
			System.out.print(i+" ");
		}
	}
	private static void dnfa(int[] arr, int n) {
		int low=0, mid=0, high=n-1;
		while(mid<=high) {
			if(arr[mid] == 0) {
				swap(arr, low, mid);
				low++;mid++;
			} else if(arr[mid] == 1) {
				mid++;
			} else {
				swap(arr, mid, high);
				high--;
			}
			
		}
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
