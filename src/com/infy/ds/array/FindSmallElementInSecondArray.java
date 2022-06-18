package com.infy.ds.array;
import java.util.*;

public class FindSmallElementInSecondArray {

	public static void main(String[] args) {
		int[] A = {5 ,4 ,3, 2, 1} , B = {3 ,4};
		List<Integer> res = countSmallerOrEqual(A, B, A.length, B.length);
		for(Integer i: res) {
			System.out.print(i+" ");
		}

	}
	

	    public static List<Integer> countSmallerOrEqual(int[] a, int[] b, int n, int m) {
	        // Write your code here!
	        Arrays.sort(b);
	        List<Integer> res = new ArrayList<Integer>();
	        for(int i=0; i<n; i++) {
	            int count =0;
	            boolean flag = true;
	            for(int j=0; j<m; j++) {
	                if(a[i]<b[j]) {
	                    res.add(count);
	                    flag = false;
	                    break;
	                }
	                count++; 
	            }
	            if(flag) res.add(count);
	        }
	        return res;
	    }
	

}
