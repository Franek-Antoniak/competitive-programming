package com.leetcode;

public class MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int index = nums1.length - 1;
            int i1 = m - 1, i2 = n - 1;
            while (index >= 0) {
                if (i1 != -1 && (i2 == -1 || nums2[i2] < nums1[i1])) {
                    nums1[index] = nums1[i1--];
                } else {
                    nums1[index] = nums2[i2--];
                }
                index--;
            }
        }
    }
}


