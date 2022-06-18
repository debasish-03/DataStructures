package com.infy.ds.recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfArray {

	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3};
		List<List<Integer>> ans = permute(nums);
		System.out.println(String.valueOf(ans));
		System.out.println("--------------");
		int[] nums2 = new int[] {1, 2, 3};
		List<List<Integer>> ans2 = permuteWithOutSpace(nums2);
		System.out.println(String.valueOf(ans2));
//				char[][] board = new char[4][4];
//				List<Integer> res= new ArrayList<>();
//				for(char[] ch: board) {
//	                for(char i: ch) {
//	                    if(Character.isDigit(i)) res.add(Integer.parseInt(String.valueOf(i)));
//	                }
//	            }
		
		char[] board = new char[]{'1', '2'};
		System.out.println(String.valueOf(board));
	           
	}
	public static List<List<Integer>> permuteWithOutSpace(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		getPermuteWithOutSpace(0, nums , ans);
		return ans;
	}
	private static void getPermuteWithOutSpace(int index, int[] nums,  List<List<Integer>> ans) {
		if(index == nums.length) {
			List<Integer> ds = new ArrayList<>();
			for(int i: nums) ds.add(i);
			ans.add(ds);
			return;
		}
		for(int i=index; i<nums.length; i++) {
			swap(index, i, nums);
			getPermuteWithOutSpace(index+1, nums, ans);
			swap(index, i, nums);
		}
	}
	
	private static void swap(int index, int i, int[] nums) {
		int temp = nums[index];
		nums[index] = nums[i];
		nums[i] = temp;
	}
	
	
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		getPermute(nums, visited, new ArrayList<>(), ans);
		return ans;
	}
	private static void getPermute(int[] nums, boolean[] visited, List<Integer> ds, List<List<Integer>> ans) {
		if(ds.size() == nums.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		for(int i=0; i<nums.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				ds.add(nums[i]);
				getPermute(nums, visited, ds, ans);
				ds.remove(ds.size()-1);
				visited[i] = false;
			}
		}
	}

}
