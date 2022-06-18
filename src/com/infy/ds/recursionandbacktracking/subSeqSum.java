package com.infy.ds.recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

public class subSeqSum {

	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 1};
		List<List<Integer>> sumList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		int sum = 2;
		sumList(arr, 0, sum, 0, list, sumList);
		System.out.println(String.valueOf(sumList));
		
		System.out.println(countNoOfSubSeqSumK(arr, 0, sum, 0));
	}
	private static int countNoOfSubSeqSumK(int[] arr, int idx, int sum, int s) {
		if(idx == arr.length) {
			if(s == sum) {
				return 1;
			}
			return 0;
		}
		s += arr[idx];
		int l = countNoOfSubSeqSumK(arr, idx+1, sum, s);
		s -= arr[idx];
		int r = countNoOfSubSeqSumK(arr, idx+1, sum, s);
		return l+r;
	}
	// print any one sub-sequence whose sum = target
	private static boolean sumList(int[] arr, int i, int sum, int s, List<Integer> list,
			List<List<Integer>> sumList) {
		if(i == arr.length) {
			if(s == sum) {
				sumList.add(new ArrayList<>(list));
				return true;
			}
			return false;
		}
		
		list.add(arr[i]);
		s += arr[i];
		if(sumList(arr, i+1, sum, s , list, sumList) == true) {
			return true;
		}
		s -= arr[i];
		list.remove(list.size()-1);
		if(sumList(arr, i+1, sum, s, list, sumList) == true) {
			return true;
		}
		return false;
	}
	/*
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
	*/
}
