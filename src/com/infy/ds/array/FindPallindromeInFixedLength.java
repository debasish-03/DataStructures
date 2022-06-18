package com.infy.ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class FindPallindromeInFixedLength {
	public static void main(String[] args) {
		int[] queries = {36,29,871708115,917133972,452709562,7,326446953,100,959017606};
		long[] res = kthPalindrome(queries, 7);
		for(long i: res) System.out.print(i+" ");
		
	}

	    public static long[] kthPalindrome(int[] queries, int n) {
	        long[] ans = new long[queries.length];
	        
	        int halfLength = (n+1)/2; //why n+1 because of odd length numbers
	        
	        long start = (long)Math.pow(10,halfLength-1);   //this you need to figure it out by taking example like n = 4
	        long end = (long)Math.pow(10,halfLength)-1;     //this you need to figure it out
	       
	      long total = end-start+1;
	      for(int i=0;i<queries.length;i++){
	         if(queries[i]<=total){
	             
	             String left = Long.toString(start+queries[i]-1);   //little bitch trick
	             
	            StringBuilder temp = new StringBuilder(left);
	             String right = temp.reverse().toString();
	             
	             //this to handling for odd strings example for 4 -> 1001 but for 3 also it is 1001
	             //but we don't want 1001 for 3 int length instead we want 101 so we have to remove o from right string which this formula likely to do
	             ans[i] = Long.parseLong(left+right.substring(n%2));
	             
	         }
	          else
	             ans[i] = -1;
	      }
	        return ans;
	    }
	
}