/**
 * Solved by Paco
 * Date: 2022-07-08 17:15:01
 * Exercise number: 206
 * Title: reverse-linked-list
 * Programming Language: Java
 */


package com.leetcode;


public class ReverseLinkedList {
	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	// Solution 1:
	// Recursive solution (Time: O(n), Space: O(n))
	// Beats 100% of submissions
	class Solution {
		public ListNode reverseList(ListNode head) {
			return reverseNode(null, head);
		}

		public ListNode reverseNode(ListNode previous, ListNode next) {
			if (next == null) {
				return previous;
			}
			ListNode result = reverseNode(next, next.next);
			next.next = previous;
			return result;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}