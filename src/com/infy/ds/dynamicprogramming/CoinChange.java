package com.infy.ds.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		
		int n = 3;
		int[] coins = new int[] {2};
	
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		
		System.out.println();
		int res = minCoin(coins, n, dp);
		if(res == Integer.MAX_VALUE) {
			res = -1;
		}
		for(int i: dp) System.out.print(i+" ");
		System.out.println();
		System.out.println(res);
		
 	}

	private static int minCoin(int[] coins, int n, int[] dp) {
		if(n == 0) return 0;
		
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<coins.length; i++) {
			
			if(n-coins[i] >= 0) {
				int subAns = 0;
				if(dp[n-coins[i]] != -1) {
					subAns = dp[n-coins[i]];
				} else {
					subAns = minCoin(coins, n-coins[i], dp);
				}
				if(subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
					ans = subAns + 1;
				}
				
			}
			
		}
		
		return dp[n] = ans;
	}

}
