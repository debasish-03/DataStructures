package com.infy.ds.searchingandsorting;
public class SelectionSort {

	public static void main(String[] args) {
		int[] nums = new int[]{10, 7, 2, 90, 64, 52, 34, 29, 12, 4, 20};;
		selectionSort(nums);
		//printing the array
		for(int i: nums) {
			System.out.print(i+" ");
		}
	}

	private static void selectionSort(int[] nums) {
		for(int i=0; i<nums.length; i++) {
			int minIndex = i;
			for(int j=i; j<nums.length; j++) {
				if(nums[minIndex] > nums[j]) {
					minIndex = j;
				}
			}
			int temp = nums[i];
			nums[i] = nums[minIndex];
			nums[minIndex] = temp;
		}
	}

}
