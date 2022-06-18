package com.infy.ds.array;

import java.util.HashMap;
import java.util.Map;

public class MaxProductCount {

	public static void main(String[] args) {
		int[] arr = {4 ,1, 7, 2, 6 ,5};
		int n = arr.length;
		long[] res = maxProductCount(arr, n);
		for(long i: res) System.out.print(i+" ");

	}
	public static long[] maxProductCount(int[] arr, int n) {
		
		// count the frequency of product
		Map<Long, Integer> map = new HashMap<>();
		
		for(int i=0; i<n ; ++i) {
			for(int j=i+1; j<n; ++j) {
				long a = arr[i];
				long b = arr[j];
				long prod = a * b;
				map.putIfAbsent(prod, 0);
				map.put(prod, map.get(prod) + 1);
			}
		}
		
		int freq = 0;
		long maxProduct = 0l;
		
		for(Long prod: map.keySet()) {
			if(map.get(prod) >= freq) {
				maxProduct = Math.min(maxProduct, prod);
			} else {
				maxProduct = prod;
			}
			freq = map.get(prod);
		}
		
		long[] res = new long[2];
		
		if(map.get(maxProduct) == 1 || map.get(maxProduct) == null) {
			res[0] = 0;
			res[1] = 0;
			return res;
		}
		int combination = (freq * (freq-1)) / 2;
		res[0] = maxProduct;
		res[1] = combination;
		return res;
	}

}
