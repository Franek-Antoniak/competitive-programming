/**
 * Solved by Paco
 * Date: 2022-07-04 12:12:05
 * Exercise number: 3
 * Title: longest-substring-without-repeating-characters
 * Programming Language: Java
 */

package com.paco.algorithms.java.leetcode.editor.en;

public class LongestSubstringWithoutRepeatingCharacters {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int[] map = new int[95];
            int fPointer = 0;
            int maxValue = 0;
            int temp = 0;
            int x;
            for (int i = 0; i < s.length(); i++) {
                x = s.charAt(i) - 32;
                while (map[x] != 0) {
                    map[s.charAt(fPointer++) - 32]--;
                    temp--;
                }
                map[x] = 1;
                maxValue = Math.max(++temp, maxValue);
            }
            return maxValue;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}