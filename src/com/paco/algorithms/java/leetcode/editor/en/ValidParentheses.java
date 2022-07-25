/**
 * Solved by Paco
 * Date: 2022-07-24 19:50:46
 * Exercise number: 20
 * Title: valid-parentheses
 * Programming Language: Java
 */

package com.paco.algorithms.java.leetcode.editor.en;

import java.util.Stack;

public class ValidParentheses {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            char[] chars2 = s.toCharArray();
            char[] chars = new char[128];
            chars['('] = ')';
            chars['{'] = '}';
            chars['['] = ']';
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (chars[chars2[i]] != 0)
                    stack.push(chars2[i]);
                else if (stack.empty() || !(chars[stack.pop()] == chars2[i]))
                    return false;
            }
            return stack.empty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}