package com.infy.ds.string;

public class LargestPallindromicSubString {

	public static void main(String[] args) {
		String s = "babad";
		System.out.println(solve(s));
	}
	private static String solve(String s) {
		int start=0, end=0;
		for(int i=0; i<s.length(); i++) {
			int max1 = expandFromCenter(s, i, i);
			int max2 = expandFromCenter(s, i, i+1);
			int max = Math.max(max1, max2);
			if(end-start < max) {
				System.out.println("============");
				System.out.println(max);
				start = i-(max-1)/2;
				end = i+max/2;
				System.out.println(start+" "+end);
				System.out.println("============");
			}
		}
		return s.substring(start, end+1);
	}
	private static int expandFromCenter(String s, int i, int j) {
		while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
			i--; j++;
		}
		return j-i-1;
	}

}
