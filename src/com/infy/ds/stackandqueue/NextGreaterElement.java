package com.infy.ds.stackandqueue;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		
		long[] arr = nextLargerElement(new long[] {13, 7, 6, 12}, 4);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

	}
	 public static long[] nextLargerElement(long[] arr, int n) { 
	        // Your code here
	       long[] ans = new long[n];
	       Stack<Long> st = new Stack<>();
	       for(int i=arr.length-1; i>=0; i--) {
	    	   while(!st.isEmpty() && st.peek() <= arr[i]) {
	    		   st.pop();
	    	   }
	    	   if(st.isEmpty()) {
	    		   ans[i] = -1;
	    	   } else {
	    		   ans[i] = st.peek();
	    	   }
	    	   st.push(arr[i]);
	       }
	       	
	        return ans;
	  }

}
