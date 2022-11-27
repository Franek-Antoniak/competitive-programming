/**
 * Solved by Paco
 * Date: 2022-07-14 23:06:45
 * Exercise number: 2
 * Title: add-two-numbers
 * Programming Language: Java
 */

package com.leetcode;


public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return addNodes(l1, l2, 0);
        }

        private ListNode addNodes(ListNode l1, ListNode l2, int acc) {
            if (l1 == null && l2 == null) {
                return acc != 0
                       ? new ListNode(acc)
                       : null;
            }
            int x = ((l1 != null)
                     ? l1.val
                     : 0) + ((l2 != null)
                             ? l2.val
                             : 0) + acc;
            return new ListNode(x % 10, addNodes(l1 == null
                                                 ? null
                                                 : l1.next, l2 == null
                                                            ? null
                                                            : l2.next, x / 10));
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


}