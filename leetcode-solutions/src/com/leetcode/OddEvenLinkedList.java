package com.leetcode;

public class OddEvenLinkedList {
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
	class Solution {
		public ListNode oddEvenList(ListNode head) {
			if (head == null || head.next == null) {
				return head;
			}
			ListNode slower = head;
			ListNode faster = head.next;
			ListNode fasterTemp = head.next;
			while (slower.next != null && faster.next != null) {
				slower.next = slower.next.next;
				slower = slower.next;
				faster.next = faster.next.next;
				faster = faster.next;
			}
			slower.next = fasterTemp;
			return head;
		}
	}
}


