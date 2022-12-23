package com.leetcode;

public class IntersectionOfTwoLinkedLists {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	class Solution {
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			int counter1 = 0, counter2 = 0;
			ListNode temp1 = headA;
			ListNode temp2 = headB;
			while (temp1 != null) {
				temp1 = temp1.next;
				counter1++;
			}
			while (temp2 != null) {
				temp2 = temp2.next;
				counter2++;
			}
			while (counter1 > counter2) {
				headA = headA.next;
				counter1--;
			}
			while (counter2 > counter1) {
				headB = headB.next;
				counter2--;
			}
			while (headB != null && headA != null) {
				if (headB == headA) {
					return headA;
				}
				headA = headA.next;
				headB = headB.next;
			}
			return null;
		}
	}
}

