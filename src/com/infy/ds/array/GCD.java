package com.infy.ds.array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class GCD {

	public static void main(String[] args) {
		int[] nums = {5,1,2,3,4,5};
		int gcd = nums[0];
		int maxEle = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > maxEle) {
				maxEle = nums[i];
			}
			gcd = gcd(gcd, nums[i]);
		}
		
		System.out.println(maxEle/gcd);
		
	}
	private static int gcd(int a, int b) {
		if(a==0) return b;
		if(b==0) return a;
		if(a==b) return a;
		if(a>b) return gcd(a-b,b);
		return gcd(a, b-a);
	}

}
