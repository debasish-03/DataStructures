package com.infy.ds.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	public static void main(String[] args) {
		String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> res = new GroupAnagram().groupAnagrams(strs);

	}
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] ch = new char[26];
            for(Character c: str.toCharArray()) {
                ch[c - 'a']++;   
            }
            String sortedChar = String.valueOf(ch);
            System.out.println(String.valueOf(sortedChar));
            if(!map.containsKey(sortedChar)) {
                map.put(sortedChar, new ArrayList());
            }
            map.get(sortedChar).add(str);
        }
        return new ArrayList(map.values());
    }

}
