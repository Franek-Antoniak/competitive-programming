/**
 * Solved by Paco
 * Date: 2022-07-05 20:05:59
 * Exercise number: 567
 * Title: permutation-in-string
 */

package com.paco.algorithms.java.leetcode.editor.en;

public class PermutationInString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean checkInclusion(String s1, String s2) {
            int[] countArr = new int[26];
            int x;
            s1.chars()
                    .forEach(ch -> countArr[ch - 'a']++);
            if (s1.length() > s2.length())
                return false;
            // Sliding Window
            int start = 0, toAchieve = s1.length(), tempAchieved = 0;
            for (int i = 0; i < s2.length(); i++) {
                x = s2.charAt(i) - 'a';
                if (countArr[x] > 0) {
                    tempAchieved++;
                }
                countArr[x]--;
                if (i >= s1.length())
                    if (++countArr[s2.charAt(start++) - 'a'] > 0)
                        tempAchieved--;
                if (tempAchieved == toAchieve) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}