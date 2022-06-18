package com.infy.ds.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {

	public static void main(String[] args) {
		String str1 = "anagram";
		String str2 = "anagramm";
		if(validateAnagram(str1, str2)) {
			System.out.println("String '" +str1+ "' and String '" +str2+ "' are Anagram");
		} else {
			System.out.println("String '" +str1+ "' and String '" +str2+ "' are not Anagram");
		}
		
		// find group anagram
		String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
		System.out.print("Group Anagram for ");
		for(String s: strs) System.out.print("'" +s+ "' ");
		System.out.print(" are below:\n");
		List<List<String>> groupAnagramList = getGroupAnagramList(strs);
		for(List<String> list: groupAnagramList) {
			System.out.println(String.valueOf(list));
		}
		
	}
	private static List<List<String>> getGroupAnagramList(String[] strs) {
		List<List<String>> groupAnagramList = new ArrayList<>();
		HashMap<String, List<String>> groupAnagramMap = new HashMap<>();
		for(String str: strs) {
			
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			
			String sortedStr = new String(ch);
			
			if(!groupAnagramMap.containsKey(sortedStr)) {
				groupAnagramMap.put(sortedStr, new ArrayList<String>());
			}
			groupAnagramMap.get(sortedStr).add(str);
		}
		
		for(List<String> list: groupAnagramMap.values()) {
			groupAnagramList.add(list);
		}
		
		return groupAnagramList;
	}
	public static boolean validateAnagram(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		
		HashMap<Character, Integer> frequencyMap = new HashMap<>();
		for(char ch: str1.toCharArray()) {
			frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
		}
		
		for(char ch: str2.toCharArray()) {
			if(frequencyMap.containsKey(ch)) {
				frequencyMap.put(ch, frequencyMap.get(ch) - 1);
			}else {
				frequencyMap.put(ch, 1);
			}
		}
		for(char ch: frequencyMap.keySet()) {
			if(frequencyMap.get(ch) != 0) {
				return false;
			}
		}
		return true;	
	}

}
