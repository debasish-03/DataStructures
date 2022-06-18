package com.infy.ds.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Array {

	public static void main(String[] args) {
		int[] arr = {10, 7, 2, 90, 64, 52, 34, 29, 12, 4, 20};
		int[] arr1 = {10, 3, 5, 7, 1, 4};
		int[] arr2 = {1, 9, 3, 8, 11, 2};
		/*
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);
		selectionSort(arr);
		printArray(arr);
		quickSort(arr, 0, arr.length-1);
		printArray(arr);
		mergeSort(arr, 0, arr.length-1);
		*/
		
		printArray(arr1);
		printArray(arr2);
		//union(arr1, arr2); // this will work for increasing order
		unionUsingHashSet(arr1, arr2);
		intersection(arr1, arr2);
	}

	private static void unionUsingHashSet(int[] arr1, int[] arr2) {
		System.out.println("Union: ");
		Set<Integer> hs = new HashSet<>();
		for(int i: arr1) hs.add(i);
		for(int i: arr2) hs.add(i);
		for(int val: hs) System.out.print(val+ " ");
		System.out.println();
		
	}

	private static void intersection(int[] arr1, int[] arr2) {
		System.out.println("Intersection: ");
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int i=0, j=0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i] < arr2[j]) {
				i++;
			} else if(arr1[i] > arr2[j]) {
				j++;
			} else {
				System.out.print(arr1[i]+ " ");
				int temp = arr1[i];
				while(i<arr1.length && temp == arr1[i]) {
					i++;
				}
				while(j<arr2.length && temp == arr2[j]) {
					j++;
				}
			}
		}
	}

	private static void union(int[] arr1, int[] arr2) {
		System.out.println("Union: ");
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int i=0, j=0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i] < arr2[j]) {
				System.out.print(arr1[i]+ " ");
				i++;
			} else if(arr1[i] > arr2[j]) {
				System.out.print(arr2[j]+ " ");
				j++;
			} else {
				System.out.print(arr1[i]+ " ");
				int temp = arr1[i];
				while(i<arr1.length && temp == arr1[i]) {
					i++;
				}
				while(j<arr2.length && temp == arr2[j]) {
					j++;
				}
			}
		}
		while(i<arr1.length) {
			System.out.print(arr1[i]+ " ");
			i++;
		}
		while(j<arr2.length) {
			System.out.print(arr2[j]+ " ");
			j++;
		}
	}

	private static void mergeSort(int[] arr, int l, int r) {
		if(l<r) {
			int mid = l + (r-l) /2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			mergeArray(arr, l, mid, r);
		}
	}

	private static void mergeArray(int[] arr, int l, int mid, int r) {
		int n1 = mid+1-l;
		int n2 = r-mid;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(int i=0; i<n1; i++) {
			L[i] = arr[l+i];
		}
		for(int i=0; i<n2; i++) {
			R[i] = arr[mid+1+i];
		}
		int i=0, j=0;
		int k=l;
		while(i<n1 && j<n2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++; k++;
			} else {
				arr[k] = R[j];
				j++; k++;
			}
		}
		while(i<n1) {
			arr[k] = L[i];
			i++; k++;
		}
		while(j<n2) {
			arr[k] = R[j];
			j++; k++;
		}
	}

	private static void quickSort(int[] arr, int i, int j) {
		int pi = partition(arr, i, j);
		if(i < pi-1) {
			quickSort(arr, i, pi-1); 
		}
		if(pi < j) {
			quickSort(arr, pi, j);
		}
		
	}

	private static int partition(int[] arr, int i, int j) {
		int pivot = arr[(i+j)/2];
		while(i<j) {
			while(arr[i] < pivot) {
				i++;
			} 
			while(arr[j] > pivot) {
				j--;
			}
			if(i<=j) {
				swap(arr, i, j);
				i++; j--;
			}
		}
		return i;
	}

	private static void selectionSort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			int minIdx = i;
			for(int j=i; j<arr.length; j++) {
				if(arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			swap(arr, i, minIdx);
		}
	}

	private static void bubbleSort(int[] arr) {
		boolean flag;
		for(int i=0; i<arr.length-1; i++) {
			flag = true;
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
					flag = false;
				}
			}
			if(flag) return;
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void printArray(int[] arr) {
		System.out.println("Array elements are: ");
		for(int val: arr) {
			System.out.print(val +" ");
		}
		System.out.println();
	}

}
