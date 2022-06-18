package com.infy.ds.array;

public class FindTheClosestPairInTwoSortedArray {

	public static void main(String[] args) {
		int arr1[] = {1, 4, 5, 7};
	     int arr2[] = {10, 20, 30, 40};
	     int x = 32;
	     /*
	     int arr1[] = {1, 4, 5, 7};
	     int arr2[] = {10, 20, 30, 40};
	     int x = 50;
	     */
	     boolean[] sorted = new boolean[arr1.length+arr2.length];
	     
	     // Merging two sorted array
	     int i=0,  j=0, k=0;
	     int[] merge = new int[arr1.length+arr2.length];
	     while(i<arr1.length && j<arr2.length) {
	    	 if(arr1[i] <= arr2[j]) { 
	    		 merge[k] = arr1[i];
	    		 sorted[i] = false;
	    		 i++;
	    	 } else {
	    		 merge[k] = arr2[j];
	    		 sorted[j] = true;
	    		 j++;
	    	 }
	    	 k++;
	     }
	     while(i<arr1.length) {
	    	 merge[k++] = arr1[i];
	    	 sorted[i] = false;
	    	 i++;
	     }
	     while(j<arr2.length) {
	    	 merge[k++] = arr2[j];
	    	 sorted[j] = true;
	    	 j++;
	     }
	     for(int ele: merge) {
	    	 System.out.print(ele+" ");
	     }
	     System.out.println();
	     int diff = Integer.MAX_VALUE;
	     int l=0, r = merge.length-1;
	     int idx1 =0, idx2 =0;
	     while(l<r) {
	    	 if(Math.abs(merge[l] + merge[r] - x) < diff && sorted[l] != sorted[r]) {
	    		 diff = Math.abs(merge[l] + merge[r] - x);
	    		 idx1 = l;
	    		 idx2 = r;
	    	 }else {
	    		 l++;r--;
	    	 }
	    	 if(merge[l]+merge[r] > x) {
	    		 r--;
	    	 } else if(merge[l]+merge[r] < x) {
	    		 l++;
	    	 }
	     }
	     
	     System.out.println(" Closest sum pair for "+ x +" is : "+ merge[idx1] +" and "+ merge[idx2]);
	}

}
