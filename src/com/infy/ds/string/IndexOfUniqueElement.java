package com.infy.ds.string;

import java.util.HashMap;
import java.util.Map;

public class IndexOfUniqueElement {

	
	public static void main(String[] args) {
		String str = "hackthegame";
		System.out.println(solve(str));
	}
	private static int solve(String str) {
		char ans=str.charAt(0);
		boolean flag = false;
		Map<Character, Integer> hm = new HashMap<>();
		for(int i=0; i<str.length(); i++) { // calculate the number of frequency of an character in Given String
			if(hm.containsKey(str.charAt(i))) {
				hm.put(str.charAt(i), hm.get(str.charAt(i))+1);
			} else {
				hm.put(str.charAt(i), 1);
			}
		}
		for(Map.Entry<Character, Integer> e: hm.entrySet()) {
			if(e.getValue() == 1) {
				flag = true;
				ans = e.getKey();
				break;
			}
		}
		if(flag) return str.indexOf(ans)+1;
		
		return -1;
	}

}
