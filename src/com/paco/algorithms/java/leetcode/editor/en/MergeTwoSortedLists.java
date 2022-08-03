/**
 * Solved by Paco
 * Date: 2022-07-08 17:14:45
 * Exercise number: 21
 * Title: merge-two-sorted-lists
 * Programming Language: Java
 */

package com.paco.algorithms.java.leetcode.editor.en;

public class MergeTwoSortedLists {

    // Structure for both of the solutions
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }
    }

    // Iterative Solution
    static class IterativeSolution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode first = new ListNode();
            ListNode result = first;
            if (list1 == null) return list2;
            if (list2 == null) return list1;
            while (list2 != null && list1 != null) {
                if (list1.val <= list2.val) {
                    first.next = list1;
                    list1 = list1.next;
                } else {
                    first.next = list2;
                    list2 = list2.next;
                }
                first = first.next;
            }
            first.next = (list1 != null) ? list1 : list2;
            return result.next;
        }
    }

    // Recursive Solution
    static class RecursiveSolution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;

            if (list1.val <= list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    //leetcode submit region end(Prohibit modification and deletion)
}