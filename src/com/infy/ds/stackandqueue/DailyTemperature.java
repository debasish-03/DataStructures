package com.infy.ds.stackandqueue;
import java.util.Stack;

public class DailyTemperature {
	
	public static int[] dailyTemperature(int[] temp) {
		// concept used monotonic stack
		int[] ans = new int[temp.length];
		Stack<Integer> st = new Stack<>();
		/*traversing array from length-1 to 0 
		 * we will compare peek element with current element if current is greater than peek we will pop and push the current at last*/
		for(int i=temp.length-1; i>=0; i--) { 
			while(!st.isEmpty() && temp[st.peek()] <= temp[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				ans[i] = 0;
			} else {
				ans[i] = st.peek()-i;
			}
			st.push(i);
		}
		
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = dailyTemperature(new int[] {73,74,75,71,69,72,76,73}); // o/p= [1,1,4,2,1,1,0,0]
		for(int i: arr) {
			System.out.print(i+" ");
		}
	}

}
