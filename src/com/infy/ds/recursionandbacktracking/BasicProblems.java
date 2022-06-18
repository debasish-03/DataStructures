package com.infy.ds.recursionandbacktracking;

public class BasicProblems {

	public static void main(String[] args) {
		int n = 10;
		printOneToTen(1, n);
		System.out.println();
		printTenToOne(n, n);
		System.out.println();
		printOneToTenBackTracking(n, n);
		System.out.print("\nSum of n: "+ sumOf(n));
		System.out.print("\nFactorial of 5: " +factorial(5));
		
		int[] arr = new int[] {1, 2, 3, 4, 5};
		System.out.print("\nBefore reversing arr: ");
		for(int i: arr) System.out.print(i+ " ");
		swap(arr, 0, arr.length-1);
		System.out.print("\nAfter reversing arr: ");
		for(int i: arr) System.out.print(i+ " ");
		
		String str = "1121111211";
		System.out.print("\nCheck if " +str+ " pallindrome or not: " +checkPallindrome(str, 0, str.length()-1));
		System.out.println();
		int ans = fibbonacciSeries(4);
		System.out.println("Ans: " +ans);
	}

	private static int fibbonacciSeries(int n) {
		if(n <= 1) {
			return n;
		}
		int end = fibbonacciSeries(n-1);
		int send = fibbonacciSeries(n-2);
		return end+send;
	}

	private static boolean checkPallindrome(String str, int i, int j) {
		if(i >= j) return true;
		if(str.charAt(i)  != str.charAt(j-i)) {
			return false;
		}
		return checkPallindrome(str, i+1, j);
	}

	private static void swap(int[] arr, int i, int j) {
		if(i >= j) return;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		swap(arr, i+1, j-1-i);
	}

	private static int factorial(int n) {
		if(n == 1) return 1;
		return n * factorial(n-1);
	}

	private static void printOneToTenBackTracking(int i, int n) {
		if(i<1) return;
		printOneToTenBackTracking(i-1, n);
		System.out.print(i+ " ");
	}

	private static int sumOf(int n) {
		if(n == 1) return 1;
		return n + sumOf(n-1);
	}

	private static void printTenToOne(int i,int n) {
		if(i<1) return;
		System.out.print(i+ " ");
		printTenToOne(i-1, n);
	}

	private static void printOneToTen(int i, int n) {
		if(i>n) return;
		System.out.print(i+ " ");
		printOneToTen(i+1, n);
	}

}
