package com.infy.ds.array;

import java.util.HashMap;

public class MaxOccuranceInaGivenRange {

	public static void main(String[] args) {
		int arr[] = {-5, -5, 2, 2, 2, 2, 3, 7, 7, 7};
		int n = arr.length;
		int l = 4, r = 9;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=l; i<=r; i++) {
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		}
		int max = Integer.MIN_VALUE;
		for(Integer i: hm.values()) {
			max = Math.max(max, i);
		}
		System.out.println(max);
	}

}
