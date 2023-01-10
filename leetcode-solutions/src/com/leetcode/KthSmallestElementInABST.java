package com.leetcode;

public class KthSmallestElementInABST {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class Solution {
		private int counter;

		public int kthSmallest(TreeNode root, int k) {
			counter = k;
			return jump(root);
		}

		public int jump(TreeNode root) {
			int result = -1;
			if (root.left != null) {
				result = jump(root.left);
			}
			if (--counter == 0) {
				return root.val;
			}
			if (root.right != null) {
				result = Math.max(jump(root.right), result);
			}
			return result;
		}
	}
}


