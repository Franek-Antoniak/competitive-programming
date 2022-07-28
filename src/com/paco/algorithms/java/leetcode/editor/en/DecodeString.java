/**
 * Solved by Paco
 * Date: 2022-07-24 19:50:55
 * Exercise number: 394
 * Title: decode-string
 * Programming Language: Java
 */

package com.paco.algorithms.java.leetcode.editor.en;

import java.util.Stack;

public class DecodeString {

    // Main method
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        System.out.println(solution.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            Stack<Integer> numStack = new Stack<>();
            Stack<String> strStack = new Stack<>();
            char[] chars = s.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (int index = 0; index < s.length(); index++) {
                if (Character.isDigit(chars[index])) {
                    int result = 0;
                    for (; index < s.length() && Character.isDigit(chars[index]); index++)
                        result = result * 10 + (chars[index] - '0');
                    index--;
                    numStack.push(result);
                } else if (chars[index] == '[') {
                    strStack.push(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                } else if (chars[index] == ']') {
                    StringBuilder temp = new StringBuilder(strStack.pop());
                    temp.append(String.valueOf(stringBuilder)
                            .repeat(numStack.pop()));
                    stringBuilder = temp;
                } else
                    stringBuilder.append(chars[index]);
            }

            return stringBuilder.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
