package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	class Solution {
		HashMap<String, List<String>> map = new HashMap<>();

		public List<List<String>> groupAnagrams(String[] strs) {
			for (String str : strs) {
				char[] count = new char[26];
				for (char c : str.toCharArray()) {
					count[c - 'a']++;
				}
				String hash = new String(count);
				if (map.containsKey(hash)) {
					map.get(hash)
					   .add(str);
				} else {
					List<String> list = new ArrayList<>();
					list.add(str);
					map.put(hash, list);
				}
			}
			return new ArrayList<>(map.values());
		}
	}
}


