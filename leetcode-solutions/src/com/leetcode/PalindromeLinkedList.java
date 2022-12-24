package com.leetcode;

public class PalindromeLinkedList {
	static class ListNode {
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

	class DestroyerSolution {
		public boolean isPalindrome(ListNode head) {
			ListNode slow = head;
			ListNode faster = head;
			while (faster != null && faster.next != null) {
				faster = faster.next.next;
				slow = slow.next;
			}
			if (faster != null) {
				slow = slow.next;
			}
			faster = head;
			slow = reverseList(slow);
			while (slow != null) {
				if (slow.val != faster.val) {
					return false;
				}
				slow = slow.next;
				faster = faster.next;
			}
			return true;
		}

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

	class RecursiveSolution {
		ListNode head;

		public boolean isPalindrome(ListNode head) {
			this.head = head;
			return isPalindromeHelper(head);
		}

		private boolean isPalindromeHelper(ListNode curr) {
			if (curr.next != null && !isPalindromeHelper(curr.next)) {
				return false;
			}
			boolean palindrome = head.val == curr.val;
			head = head.next;
			return palindrome;
		}
	}
}





