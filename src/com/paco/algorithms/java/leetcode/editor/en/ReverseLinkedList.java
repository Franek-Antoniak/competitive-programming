/**
 * Solved by Paco
 * Date: 2022-07-08 17:15:01
 * Exercise number: 206
 * Title: reverse-linked-list
 * Programming Language: Java
 */


package com.paco.algorithms.java.leetcode.editor.en;

public class ReverseLinkedList {
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            return reverseNode(null, head);
        }

        public ListNode reverseNode(ListNode previous, ListNode next) {
            if (next == null)
                return previous;
            ListNode result = reverseNode(next, next.next);
            next.next = previous;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}