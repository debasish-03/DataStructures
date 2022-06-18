package com.infy.ds.array;
import java.util.*;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] res = getProductArrayExceptSelf(new int[] {1, 2,3,4,5});
		for(int i:res) {
			System.out.print(i+" ");
		}

	}




    public static int[] getProductArrayExceptSelf(int[] arr) {
    	//Your code goes here
    	 int mod = 1000000000+7;
    	 int n = arr.length;
    	 int[] res = new int[n];
    	 int product = 1;
    	 for(int i=0; i<n ; ++i) {
    		 res[i] = (product%mod);
    		 product = ((product%mod) * (arr[i]%mod)) % mod;
    	 }
    	 
    	 product = 1;
    	 for(int i=n-1; i>=0 ; --i) {
    		 res[i] = ((product%mod) * (res[i]%mod)) % mod;
    		 product = ((product%mod) * (arr[i]%mod)) % mod;
    	 }
    	 return res;
         
    }



}
