/**
 * Solved by Paco
 * Date: 2022-07-02 19:51:01
 * Exercise number: 876
 * Title: middle-of-the-linked-list
 */

// Import libraries with LinkedList ListNode class
package com.paco.algorithms.java.leetcode.editor.en;

public class MiddleOfTheLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

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
        public ListNode middleNode(ListNode head) {
            int size = checkSize(head);
            size /= 2;
            while (size > 0) {
                head = head.next;
                size--;
            }
            return head;
        }

        private int checkSize(ListNode head) {
            return head.next == null ? 1 : 1 + checkSize(head.next);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
