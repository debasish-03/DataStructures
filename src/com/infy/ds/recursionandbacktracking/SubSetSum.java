package com.infy.ds.recursionandbacktracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubSetSum {

	public static void main(String[] args) {
		int[] arr = new int[] {3, 1,2 };
		List<Integer> sumList = new ArrayList<>();
		subSetSum(0, arr, 0, sumList);
		Collections.sort(sumList);
		System.out.println(String.valueOf(sumList));
	}

	private static void subSetSum(int i, int[] arr, int sum, List<Integer> sumList) {
		if(i == arr.length) {
			sumList.add(sum);
			return;
		}
		subSetSum(i+1, arr, sum + arr[i], sumList);
		subSetSum(i+1, arr, sum, sumList);
	}

}
