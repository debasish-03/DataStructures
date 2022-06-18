package com.infy.ds.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SortElementByFrequency {

	public static void main(String[] args) {
		Integer arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
		List<Integer> list = Arrays.asList(arr);
		int n = list.size();
		
		HashMap<Integer, Integer> count = new HashMap<>();
		HashMap<Integer, Integer> index = new HashMap<>();
		for(int i=0; i<n; i++) {
			if(count.containsKey(list.get(i))) {
				count.put(list.get(i), count.get(list.get(i))+1);
			} else {
				count.put(list.get(i), 0);
				index.put(list.get(i), i);
			}
		}
		
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer n1, Integer n2) {
				int freq1 = count.get(n1);
				int freq2 = count.get(n2);
				if(freq1 != freq2) {
					return freq2-freq1;
				} else {
					return index.get(n1) - index.get(n2);
				}
				
			}
		});
		
		for(Integer i: list) {
			System.out.print(i+" ");
		}
	}

}
