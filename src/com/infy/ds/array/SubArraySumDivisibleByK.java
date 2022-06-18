package com.infy.ds.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArraySumDivisibleByK {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(3);
		arr.add(1);
		System.out.println(subArrayCount(arr, 2));
	}
	public static int subArrayCount(ArrayList < Integer > arr, int k) {

   	 // Write your code here.
		int count =0;
		int sum = 0;
		Map<Integer, Integer> hm = new HashMap<>();
		hm.put(0, 1);
		for(Integer i: arr) {
			sum += i;
			int rem = sum%k;
			if(rem < 0) rem += k;
			if(hm.containsKey(rem)) {
				count+=hm.get(rem);
			}
				hm.put(rem, hm.getOrDefault(rem, 0)+1);
			
		}
		
        return count;
   }

}
