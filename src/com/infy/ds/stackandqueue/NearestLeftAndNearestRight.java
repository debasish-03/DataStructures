package com.infy.ds.stackandqueue;
import java.util.Stack;
//GeeksforGeeks
public class NearestLeftAndNearestRight {
	/*
	 * Input  : arr[] = {2, 4, 8, 7, 7, 9, 3}
		Output : 4
		Left smaller   LS[] = {0, 2, 4, 4, 4, 7, 2}
		Right smaller  RS[] = {0, 3, 7, 3, 3, 3, 0}
		Maximum Diff of abs(LS[i] - RS[i]) = 7 - 3 = 4 

		Input : arr[] = {5, 1, 9, 2, 5, 1, 7}
		Output : 1
	 * */

	public static void main(String[] args) {
		int arr[] = {2, 4, 8, 7, 7, 9, 3};
		int[] r = new int[arr.length];
		int[] l = new int[arr.length];
		Stack<Integer> LS = new Stack<>();
		Stack<Integer> RS = new Stack<>();
		for(int i=arr.length-1; i>=0; i--) {
			while(!RS.isEmpty() && RS.peek() >= arr[i]) {
				RS.pop();
			}
			if(RS.isEmpty()) {
				r[i] = 0;
			} else {
				r[i] = RS.peek();
			}
			RS.push(arr[i]);
		}
		//{2, 4, 8, 7, 7, 9, 3}
		for(int i=0; i<arr.length; i++) {
			while(!LS.isEmpty() && LS.peek() >= arr[i]) {
				LS.pop();
			}
			if(LS.isEmpty()) {
				l[i] = 0;
			} else {
				l[i] = LS.peek();
			}
			LS.push(arr[i]);
		}
		for(int i:l) {
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i:r) {
			System.out.print(i+" ");
		}
		System.out.println();
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			max = Math.max(max, Math.abs(l[i]-r[i]));
		}
		System.out.println(max);
	}

}
