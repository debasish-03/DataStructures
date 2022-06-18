package com.infy.ds.array;
import java.util.ArrayList;
import java.util.List;

public class SumOfInfiniteArray {

	public static void main(String[] args) {
		int[] arr = {5, 2 ,6 ,9};
		List<List<Long>> queries = new ArrayList<>();
		List<Long> q1 = new ArrayList<>();
		q1.add(1L);
		q1.add(5L);
		List<Long> q2 = new ArrayList<>();
		q2.add(10L);
		q2.add(13L);
		queries.add(q1);
		queries.add(q2);
		List<Long> q3 = new ArrayList<>();
		q3.add(7L);
		q3.add(11L);
		queries.add(q3);
		
		int q = 2;
		List<Integer> res = sumInRanges(arr, arr.length, queries,  q);
		for(Integer i: res) System.out.print(i+" ");
		
		System.out.println();
		long[] ans = new long[3];
		System.out.println(ans[0]+"-->");
	}
	

	    public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {

	        // Write your code here!
	    	int mod = (int) 1e9 + 7;
	        List<Integer> res = new ArrayList<>();
	        
	            for(List<Long> obj: queries) {
	                Integer sum =0;
	                long l=obj.get(0);
	                long r=obj.get(1);
	                for(long j=l-1; j<r; j++) {
	                    sum = (sum + arr[(int)j % arr.length ]) % mod;
	                }
	                sum %= mod;
	                res.add((int)sum);
	            }
	        
	        return res;

	    }
	    
	    
	    //Optimised code
	    private static int mod = (int) 1e9 + 7;

	    public static List<Integer> sumInRanges2(int[] arr, int n, List<List<Long>> queries, int q) {

	        // It stores answer for each query.
	        List<Integer> ans = new ArrayList<>();

	        // It store cumulative sum where sumArray[i] = sum(A[0]+..A[i]).
	        long sumArray[] = new long[n + 1];

	        for (int i = 1; i <= n; i++) {
	            sumArray[i] = (sumArray[i - 1] + arr[i - 1]) % mod;
	        }

	        // Traversing the given queries.
	        for (List<Long> range : queries) {

	            long l = range.get(0);
	            long r = range.get(1);

	            // It stores the prefix sum from index 0 to index r in an infinite array.
	            long rsum = func(sumArray, r, n);

	            // It stores the prefix sum from index 0 to index l-1 in an infinite array.
	            long lsum = func(sumArray, l - 1, n);

	            // Add answer for each query.
	            ans.add((int) ((rsum - lsum + mod) % mod));

	        }

	        return ans;
	    }

	    // Function to calculate prefix sum upto index x of the infite array.
	    private static long func(long sumArray[], long x, long n) {

	        // Number of times the given array comes completely upto index x.
	        long count = (x / n) % mod;

	        long res = (count * sumArray[(int) n]) % mod;

	        // Adding the remaining elements sum.
	        res = (res + sumArray[(int) (x % n)]) % mod;

	        return res;
	    }
	

}
