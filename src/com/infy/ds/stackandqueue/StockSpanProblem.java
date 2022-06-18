package com.infy.ds.stackandqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StockSpanProblem {
	/*
	 * arr[] = {100, 80, 60, 70, 60, 75, 85}, 
	 span[] =  {1, 1, 1, 2, 1, 4, 6} */

	public static void main(String[] args) {
		int arr[] = {100, 80, 60, 70, 60, 75, 85};
		int[] span= new int[arr.length];
        Stack<Integer> st = new Stack<>();
        span[0] = 1;
        st.push(0);
		for(int i=1; i<arr.length; i++) {
			while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				span[i] = i+1;
			} else {
				span[i] = i-st.peek();
			}
			st.push(i);
		}
		for(int i: span) {
			System.out.print(i+" ");
		}
	}

}












