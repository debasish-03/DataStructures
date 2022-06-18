package com.infy.ds.array;

public class MaxSumRectangleIn2dArray {

	public static void main(String[] args) {
		int arr[][] = new int[][] { { 1, 2, -1, -4, -20 },
						            { -8, -3, 4, 2, 1 },
						            { 3, 8, 10, 1, 3 },
						            { -4, -1, 1, 7, -6 } };
            System.out.println(maxSumRectangle(arr, 4, 5));
	}

	public static int maxSumRectangle(int[][] arr, int n, int m)
	    {
	        // Write your code here.
		int cnt = 1;
	    	int maxSum = Integer.MIN_VALUE;
	    	for(int i=0; i<n;i++) {
	            int[] temp = new int[m];
	            for(int r=i; r<n; r++) {
	                for(int c=0; c<m; c++) {
	                    temp[c] += arr[r][c];
	                    System.out.print(temp[c]+" ");
	                    
	                }
	                System.out.println();
	                maxSum = Math.max(maxSum, maxSubArraySum(temp));
	                System.out.println(maxSum+" "+cnt++);
	            }
	        } 
	    	return maxSum;
	    }
	    private static int maxSubArraySum(int[] arr) {
	        int maxSum = Integer.MIN_VALUE;
	        int sum =0;
	        for(int i=0; i<arr.length; i++) {
	            sum += arr[i];
	            if(sum < 0)  sum = 0;
	            maxSum = Math.max(maxSum, sum);
	        }
	        return maxSum;
	    } 
	


}
