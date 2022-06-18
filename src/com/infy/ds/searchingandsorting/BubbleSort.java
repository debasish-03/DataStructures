package com.infy.ds.searchingandsorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] nums = new int[]{10, 7, 2, 90, 64, 52, 34, 29, 12, 4, 20};
		bubbleSort(nums);
		//printing the array
		for(int i: nums) {
			System.out.print(i+" ");
		}
	}

	private static void bubbleSort(int[] nums) {
		for(int i=0; i<nums.length-1; i++) {
			boolean flag = true;
			for(int j=0; j<nums.length-1-i; j++) {
				if(nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
					flag = false;
				}
			}
			if(flag) break;
		}
	}

}
