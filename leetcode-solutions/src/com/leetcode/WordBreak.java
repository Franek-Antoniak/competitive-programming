/**
 * Solved by Paco
 * Date: 2022-07-24 19:51:08
 * Exercise number: 139
 * Title: word-break
 * Programming Language: Java
 */

package com.leetcode;

import java.util.*;

public class WordBreak {

    /**
     * Solution 1:
     * Recursive Solution with Memoization
     * Time Complexity:
     * Average Case: O(n^3),  The Worst Case: O(n^4) with the HashSet
     * Space Complexity: O(n)
     * The Worst Case & Average Case with TreeSet: O(n^3 * log(n)
     */
    static class RecursiveSolution {
        public boolean wordBreak(String s, List<String> wordDict) {
            return wordBreakMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
        }

        private boolean wordBreakMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
            if (start == s.length()) {
                return true;
            }
            if (memo[start] != null) {
                return memo[start];
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end, memo)) {
                    return memo[start] = true;
                }
            }
            return memo[start] = false;
        }
    }

    /**
     * Solution 2:
     * BFS Solution
     * Time Complexity:
     * O(n^3 * log(n))
     * Space Complexity: O(n)
     */
    static class BFSSolution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet = new HashSet<>(wordDict);
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[s.length()];
            queue.add(0);
            while (!queue.isEmpty()) {
                int start = queue.remove();
                if (visited[start]) {
                    continue;
                }
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = true;
            }
            return false;
        }
    }

    // Solution 3:
    // DP Solution
    // Time Complexity: O(n^3)
    // Space Complexity: O(n)
    // The Worst Case: O(n^4) with the HashSet
    // The Worst Case with TreeSet: O(n^3 * log(n))
    static class DPSolution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }

    // Solution 4:
    // DP Solution
    // Time Complexity: O(n^2 * wordDict.size())
    // Space Complexity: O(n)
    // Nice trick with the for each loop in the wordDict instead of using double for loop to iterate over the every
    // substring of the string.
    // Leetcode runtime: 3ms faster than 93.39% of Java submissions
    static class ListDPSolution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] t = new boolean[s.length() + 1];
            t[0] = true;
            for (int i = 0; i < s.length(); i++) {
                if (!t[i]) continue;
                for (String a : wordDict) {
                    int len = a.length();
                    int end = i + len;
                    if (end > s.length()) continue;
                    if (t[end]) continue;
                    if (s.substring(i, end)
                            .equals(a)) {
                        t[end] = true;
                    }
                }
            }
            return t[s.length()];
        }
    }

    // Solution 5:
    // DP Solution with Trie
    // Time Complexity: O(n^2 * d) where d is the length of the longest word in the dictionary
    // However, it is speeded up by the use of a Trie - we don't need to iterate over the every substring of the "s"
    // string, due to the use of the Trie.
    // Space Complexity: O(n + d * x) where d is the length of the longest word in the dictionary and x is the size
    // of the dictionary.
    // The trick to make it works is to use a Trie with reverse order of the words in the dictionary.
    // If we used the normal order of the words in the dictionary, it wouldn't work
    // on such examples as "aaaaaaa" with words in dictionary "aaaa" and "aaa" because
    // the algorithm would find only "aaa" and not "aaaa". It would stop entire searching
    // because it would find "aaa" first.
    // There isn't faster solution I could find.
    // The fastest solution: Leetcode runtime: 1ms faster than 99.88% of Java submissions
    static class TrieSolution {

        public boolean wordBreak(String s, List<String> wordDict) {
            if (s.length() == 0)
                return false;

            int n = s.length();
            Node root = new Node();
            for (String w : wordDict)
                addWordReverse(w, root);

            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                Node cur = root;
                for (int j = i; j >= 0; j--) {
                    char ch = s.charAt(j);
                    cur = search(ch, cur);
                    if (cur == null)
                        break;
                    if (cur.isWord && dp[j]) {
                        dp[i + 1] = true;
                        break;
                    }
                }
            }

            return dp[n];
        }

        private void addWordReverse(String word, Node root) {
            Node n = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (n.children[idx] == null) {
                    n.children[idx] = new Node();
                }
                n = n.children[idx];
            }
            n.isWord = true;
        }

        private Node search(char ch, Node root) {
            if (root == null) {
                return null;
            }
            int idx = ch - 'a';
            return root.children[idx];
        }

        static class Node {
            Node[] children;
            boolean isWord;

            public Node() {
                children = new Node[26];
                isWord = false;
            }
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    //leetcode submit region end(Prohibit modification and deletion)

}
