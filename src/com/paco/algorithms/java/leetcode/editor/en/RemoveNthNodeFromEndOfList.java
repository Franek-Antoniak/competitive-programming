/**
 * Solved by Paco
 * Date: 2022-07-03 02:13:08
 * Exercise number: 19
 * Title: remove-nth-node-from-end-of-list
 */

package com.paco.algorithms.java.leetcode.editor.en;

public class RemoveNthNodeFromEndOfList {
    public class ListNode {
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode first = head;
            ListNode second = head;
            if (head.next == null)
                return null;
            while (n != 0) {
                if (second.next == null)
                    return head.next;
                second = second.next;
                n--;
            }
            while (second.next != null) {
                first = first.next;
                second = second.next;
            }
            first.next = first.next.next;
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}