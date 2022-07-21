/**
 * Solved by Paco
 * Date: 2022-07-19 08:05:42
 * Exercise number: 9
 * Title: palindrome-number
 * Proramming Language: Java
 */

package com.paco.algorithms.java.leetcode.editor.en;

public class PalindromeNumber {

/*
    // BEST SOLUTION
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }
            int revertedNumber = 0;
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x /= 10;
            }
            return x == revertedNumber || x == revertedNumber / 10;
        }
    }*/

    // My solution
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0)
                return false;
            int div = 1;
            while (x / div >= 10)
                div *= 10;
            while (x > 0) {
                if (x / div != x % 10)
                    return false;
                x = (x % div) / 10;
                div /= 100;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}