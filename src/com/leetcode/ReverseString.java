/**
 * Solved by Paco
 * Date: 2022-07-24 17:26:22
 * Exercise number: 344
 * Title: reverse-string
 * Programming Language: Java
 */

package com.leetcode;

public class ReverseString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int left = 0;
            int right = s.length - 1;
            while (left <= right) {
                swap(s, left, right);
                left++;
                right--;
            }

        }

        public void swap(char[] arr, int i, int j) {
            arr[i] = (char) ((arr[i] + arr[j]) - (arr[j] = arr[i]));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}