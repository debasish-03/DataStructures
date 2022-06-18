package com.infy.ds.searchingandsorting;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		  
        System.out.println("Given Array");
        for(int i: arr) System.out.print(i +" ");
        System.out.println();
  
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
  
        System.out.println("\nSorted array");
        for(int i: arr) System.out.print(i +" ");
        System.out.println();
		
	}
	private void sort(int[] arr, int l, int r) {
		if(l<r) {
			int m = l+(r-l)/2;
			sort(arr, l, m); // sort left subarray
			sort(arr, m+1, r); // sort right subarray
			
			merge(arr, l, m ,r); // merge both the subarry
		}
		
	}
	
	private void merge(int[] arr, int l, int m, int r) {
		int n1 = m-l+1; // length of  L[] left sub array
		int n2 = r-m; // length R[] right sub array
		
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for(int i=0; i<n1; i++) {
			L[i] = arr[l+i];
		}
		for(int i=0; i<n2; i++) {
			R[i] = arr[m+1+i];
		}
		
		int i=0, j=0; // initial index of left and right sub arrays
		int k=l; // initial index of merged array
		while(i<n1 && j<n2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while(i<n1) {
			arr[k++] = L[i];
			i++;
		}
		while(j<n2) {
			arr[k++] = R[j];
			j++;
		}
	}

}
