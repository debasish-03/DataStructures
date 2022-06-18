package com.infy.ds.array;

import java.util.ArrayList;

public class RearrangeArrayAlternatePosNeg {

	public static void main(String[] args) {
		int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
		int n = arr.length;
		int i=0, j=n-1;
		while(i<j) {
			while(arr[i]>=0 && i<=n-1) {
				i++;
			}
			while(arr[j]<0 && j>=0) {
				j--;
			}
			if(i<j) {
				swap(arr, i, j);
			}
		}
		if(i==0 || j==n) {
			return;
		}
		int k=0;
		while(k<n && i<n) {
			swap(arr, k, i);
			i++;
			k+=2;
		}
		for(int val: arr) {
			System.out.print(val +" ");
		}
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
