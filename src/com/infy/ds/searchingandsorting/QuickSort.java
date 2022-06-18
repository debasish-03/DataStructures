package com.infy.ds.searchingandsorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] nums = new int[]{-2,4,1,0,7,3,10,7,15};
		quickSort(nums, 0, nums.length-1);
		//printing the array
		for(int i: nums) {
			System.out.print(i+" ");
		}
	}

	private static void quickSort(int[] nums, int i, int j) {
		int pi = partition(nums, i, j);
		if(i < pi-1) {
			quickSort(nums, i, pi-1);
		}
		if(pi < j) {
			quickSort(nums, pi, j);
		}
	}

	private static int partition(int[] nums, int i, int j) {
		int pivot = nums[(i+j)/2];
		while(i < j) {
			while(nums[i] < pivot) {
				i++;
			}
			while(nums[j] > pivot) {
				j--;
			}
			if(i<=j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;j--;
			}
		}
		return i;
	}

}
