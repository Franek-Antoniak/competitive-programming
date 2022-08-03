/**
 * Solved by Paco
 * Date: 2022-07-24 19:49:33
 * Exercise number: 5
 * Title: longest-palindromic-substring
 * Programming Language: Java
 */

package com.paco.algorithms.java.leetcode.editor.en;

// Solution: 1
// Time Complexity: O(n^2) not O(n^3) because of the use of Hashing algorithm
// Space Complexity: O(n) but use a lot of memory in practice because of the use of Hashing algorithm
// - subwordsEquals() creates a lot of variables to calculate
// It's not a good solution because it uses a lot of memory, and it's slow compared to other solutions.
// It's still better than brute force - O(n^3)
// Solution passes the tests in contrasts to brute force.
class HashingSolution {
    public String reverse(String s) {
        return new StringBuilder(s).reverse()
                .toString();
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        HashCreator hashCreator = new HashCreator(s);
        HashCreator hashCreator2 = new HashCreator(reverse(s));
        Pair<Integer> maxIndex = new Pair<>(0, 0);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                Pair<Integer> indexOfOwn = new Pair<>(i, j);
                Pair<Integer> indexOfOther = new Pair<>(s.length() - j - 1, s.length() - i - 1);
                if (hashCreator.subwordsEquals(hashCreator2, indexOfOwn, indexOfOther)) {
                    if (j - i > maxIndex.second() - maxIndex.first()) {
                        maxIndex = new Pair<>(i, j);
                    }
                }
            }
        }
        return s.substring(maxIndex.first(), maxIndex.second() + 1);
    }

    record Pair<T>(T first, T second) {
    }

    static class HashCreator {
        private final char[] word;
        private final long[] hash;
        private final int bigPrimeNumber = 1000000007;
        private final int smallPrimeNumber;
        private long[] powersOfSmallPrime;

        public HashCreator(String word) {
            this.word = word.toCharArray();
            this.hash = new long[word.length() + 1];
            this.smallPrimeNumber = 29;
            fillPowersOfSmallPrime();
            createHash();
        }

        private void fillPowersOfSmallPrime() {
            powersOfSmallPrime = new long[word.length];
            powersOfSmallPrime[0] = 1;
            for (int i = 1; i < word.length; i++) {
                powersOfSmallPrime[i] = (powersOfSmallPrime[i - 1] * smallPrimeNumber) % bigPrimeNumber;
            }
        }

        private void createHash() {
            hash[0] = 0;
            for (int i = 1; i <= word.length; i++) {
                hash[i] = (word[i - 1] * powersOfSmallPrime[i - 1] + hash[i - 1]) % bigPrimeNumber;
            }
        }

        public boolean subwordsEquals(HashCreator other, Pair<Integer> indexOfOwn, Pair<Integer> indexOfOther) {
            if (other.smallPrimeNumber != smallPrimeNumber) {
                throw new IllegalArgumentException("The small prime numbers of the two hash creators must be the same");
            }
            int length = indexOfOwn.second() - indexOfOwn.first();
            if (length != indexOfOther.second() - indexOfOther.first()) {
                return false;
            }
            long hashOfOther = (other.hash[indexOfOther.second() + 1] - other.hash[indexOfOther.first()] + bigPrimeNumber) % bigPrimeNumber;
            long hashOfOwn = (hash[indexOfOwn.second() + 1] - hash[indexOfOwn.first()] + bigPrimeNumber) % bigPrimeNumber;
            if (indexOfOther.first()
                    .equals(indexOfOwn.first())) {
                return hashOfOther == hashOfOwn;
            }
            hashOfOther = (hashOfOther * powersOfSmallPrime[indexOfOwn.first()]) % bigPrimeNumber;
            hashOfOwn = (hashOfOwn * powersOfSmallPrime[indexOfOther.first()]) % bigPrimeNumber;
            return hashOfOther == hashOfOwn;
        }
    }
}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)