package com.infy.ds.array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Processor {

	public static void main(String[] args) {
		Integer[] pt = {5, 11};
		List<Integer> processTime = new ArrayList<>();
		Collections.addAll(processTime, pt);
		
		Integer[] tt = {3, 1, 8, 7, 4, 2, 5, 2};
		List<Integer> taskTime = new ArrayList<>();
		Collections.addAll(taskTime, tt);
		
		System.out.println(solve(processTime, taskTime));
		
	}
	private static int solve(List<Integer> processTime, List<Integer> taskTime) {
		int ans=Integer.MIN_VALUE;
		int count=0;
		Collections.sort(processTime);
		Collections.sort(taskTime, Collections.reverseOrder());
		for(int i=0; i<processTime.size(); i++) {
			for(int j=0; j<4; j++) {
				ans = Math.max(processTime.get(i)+taskTime.get(count), ans);
				//System.out.println(ans);
				count++;
				if(count == taskTime.size()) break;
			}
		}
		return ans;
	}

}
