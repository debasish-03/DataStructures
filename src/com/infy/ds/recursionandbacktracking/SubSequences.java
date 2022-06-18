package com.infy.ds.recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

public class SubSequences {

	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 1};
		List<List<Integer>> resList = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		formSubSequence(0, arr, resList, res);
		System.out.println(String.valueOf(resList));
		
		List<List<Integer>> sumList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		int sum = 2;
		sumList(arr, 0, sum, 0, list, sumList);
		System.out.println(String.valueOf(sumList));
	}

	private static void sumList(int[] arr, int i, int sum, int s, List<Integer> list,
			List<List<Integer>> sumList) {
		if(i == arr.length) {
			if(s == sum) {
				sumList.add(new ArrayList<>(list));
			}
			return;
		}
		
		list.add(arr[i]);
		s += arr[i];
		sumList(arr, i+1, sum, s , list, sumList);
		s -= arr[i];
		list.remove(list.size()-1);
		sumList(arr, i+1, sum, s, list, sumList);
	}

	private static void formSubSequence(int i, int[] arr, List<List<Integer>> resList, List<Integer> res) {
		if(i >= arr.length) {
			resList.add(new ArrayList<>(res));
			return;
		}
		res.add(arr[i]);
		formSubSequence(i+1, arr, resList, res);
		res.remove(res.size()-1);
		formSubSequence(i+1, arr, resList, res);
		
	}

}
