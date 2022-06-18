package com.infy.ds.array;

import java.util.HashMap;
import java.util.Iterator;

/*
Time Complexity : O(N ^ 2)
Space Complexity : O(N)

Where 'N' is the length of the array.
*/

public class ValidPair {
	public static void main(String[] args) {
		System.out.println(isValidPair(new int[] {2, 1, 5 ,7},4, 9, 3 ));
		System.out.println(isValidPair(new int[] {6 ,6, 3, 0 ,0},5, 9, 3 ));
		
	}
	
	
	// optimal sol O(n)
	 public static boolean isValidPairOpt(int[] arr, int n, int k, int m) 
		{

	        // An odd length array cannot be divided into pairs.
	        if (n % 2 == 1) 
			{
	            return false;
	        }

	        /*
			    Create a frequency array to count occurrences
	            of all remainders when divided by k.
			*/
	        HashMap<Integer, Integer> map = new HashMap<>();

	        for (int i = 0; i < n; i++) 
			{
	            int rem = arr[i] % k;

	            if (!map.containsKey(rem)) 
				{
	                map.put(rem, 1);
	            } 
				
				else 
				{
	                map.put(rem, map.get(rem) + 1);
	            }
	        }

	        Iterator<Integer> itr = map.keySet().iterator();

	        while (itr.hasNext()) 
			{
	            int rem = itr.next();

	            /* 
				    If current remainder divides
	                m into two halves.
				*/
	            if (2 * rem == m) 
				{

	                // Then there must be even occurrences of such remainder.
	                if (map.get(rem) % 2 == 1) 
					{
	                    return false;
	                }
	            }

	            /*    
				    Else number of occurrences of remainder
	                must be equal to number of occurrences of m - remainder.
				*/
	            else 
				{
	                if (!map.get((m - rem + k) % k).equals(map.get(rem))) 
					{
	                    return false;
	                }
	            }
	        }

	        return true;
	    }
	public static boolean isValidPair(int[] arr, int n, int k, int m) {

		// An odd length array cannot be divided into pairs.
		if (n % 2 == 1) {
			return false;
		}
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				// If arr[i] and arr[j] is not included in any pair.
				if (visited[i] == false && visited[j] == false) {
					if ((arr[i] + arr[j]) % k == m) {
						visited[i] = true;
						visited[j] = true;

						/*
					    	If any pair formed, then break and
							move to next pair that can be formed.
					    */ 
						break;
					}
				}
			}
		}

		// Check the condition if all the elements can be paired.
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				return false;
			}
		}
		return true;
	}
}