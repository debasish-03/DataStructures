package com.infy.ds.array;

public class MaximumTripletSumInArray {

	public static void main(String[] args) {
		int[] arr = {-2, -6, -2};
		System.out.println(maxTripletSum(arr, arr.length));
	}
    private static int maxTripletSum(int arr[], int n)
    {
        // Complete the function
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++) {
            if(arr[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            } else if(arr[i] > max2) {
                max3 = max2;
                max2 = arr[i];
            } else if(arr[i] > max3){
                max3 = arr[i];
            }
        }
        System.out.println(max1 +" "+ max2 +" "+ max3);
        return max1+max2+max3;
    }
  

}
