/**
 * Solved by Paco
 * Date: 2022-07-24 19:51:19
 * Exercise number: 242
 * Title: valid-anagram
 * Programming Language: Java
 */

package com.paco.algorithms.java.leetcode.editor.en;

public class ValidAnagram {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] count = new int[26];
            int[] count2 = new int[26];
            for (int i = 0; i < s.length(); i++)
                count[s.charAt(i) - 'a']++;
            for (int i = 0; i < t.length(); i++)
                count2[t.charAt(i) - 'a']++;
            for (int i = 0; i < 26; i++)
                if (count[i] != count2[i])
                    return false;
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}