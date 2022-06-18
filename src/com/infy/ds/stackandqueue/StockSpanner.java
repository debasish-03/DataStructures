package com.infy.ds.stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
    List<Integer> list;
    int i;
    Stack<Integer> st;
    public StockSpanner() {
        list = new ArrayList<Integer>();
        st = new Stack<Integer>();
        i=0;
    }
    
    public int next(int price) {
        list.add(price);
        
        int ans = 0;
        while(!st.isEmpty() && list.get(st.peek()) <= price) {
            st.pop();
        }
        if(st.isEmpty()) {
            ans = i+1;
        } else {
            ans = i-st.peek();
        }
        st.push(i);
        i++;
        return ans;
    }

	public static void main(String[] args) {
		int arr[] = {100, 80, 60, 70, 60, 75, 85};
		StockSpanner obj = new StockSpanner();
		for(int i=0; i<arr.length; i++) {
			System.out.print(obj.next(arr[i])+" ");
		}

	}
}
