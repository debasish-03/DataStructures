package com.infy.ds.recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {

	public static void main(String[] args) {
		String str = "abc";
		List<String> ans = permute(str);
		System.out.println(String.valueOf(ans));
	}
	
	public static List<String> permute(String str) {
		List<String> ans = new ArrayList<>();
		boolean[] visited = new boolean[str.length()];
		getPermute(str, visited, new ArrayList<>(), ans);
		return ans;
	}
	private static void getPermute(String str, boolean[] visited, List<Character> ds, List<String> ans) {
		if(ds.size() == str.length()) {
			StringBuilder sb = new StringBuilder();
			for(Character ch: ds) {
				sb.append(ch);
			}
			String s = sb.toString();
			ans.add(s);
			return;
		}
		for(int i=0; i<str.length(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				ds.add(str.charAt(i));
				getPermute(str, visited, ds, ans);
				ds.remove(ds.size()-1);
				visited[i] = false;
			}
		}
	}
}
