package com.leetcode;

import java.util.ArrayList;

public class FindTheIndexOfTheFirstOccurrenceInAString {
	class HashedString {
		// Change M and B if you want
		public static final long M = (long) 1e9 + 9;
		public static final long B = 9973;

		// pow[i] contains B^i % M
		private static ArrayList<Long> pow = new ArrayList<>();

		// pHash[i] is the hash of the first i characters of the given string
		private long[] pHash;

		public HashedString(String s) {
			if (pow.isEmpty()) {
				pow.add(1L);
			}
			while (pow.size() <= s.length()) {
				pow.add((pow.get(pow.size() - 1) * B) % M);
			}

			pHash = new long[s.length() + 1];
			pHash[0] = 0;
			for (int i = 0; i < s.length(); i++) {
				pHash[i + 1] = ((pHash[i] * B) % M + s.charAt(i)) % M;
			}
		}

		public long getHash(int start, int end) {
			long rawVal = pHash[end + 1] - (pHash[start] * pow.get(end - start + 1));
			return (rawVal % M + M) % M;
		}
	}

	class Solution {
		public int strStr(String haystack, String needle) {
			HashedString hs = new HashedString(haystack);
			HashedString ns = new HashedString(needle);
			for (int i = 0; i + needle.length() <= haystack.length(); i++) {
				if (hs.getHash(i, i + needle.length() - 1) == ns.getHash(0, needle.length() - 1)) {
					return i;
				}
			}
			return -1;
		}
	}
}



