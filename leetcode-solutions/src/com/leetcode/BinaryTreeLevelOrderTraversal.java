package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

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
		public List<List<Integer>> levelOrder(TreeNode root) {
			if (root == null) {
				return List.of();
			}
			List<List<Integer>> result = new ArrayList<>();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			int counter = 1;
			int newCounter = 0;
			List<Integer> temp = new ArrayList<>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				temp.add(node.val);
				if (node.left != null) {
					newCounter++;
					queue.add(node.left);
				}
				if (node.right != null) {
					newCounter++;
					queue.add(node.right);
				}
				counter--;
				if (counter == 0) {
					result.add(temp);
					temp = new ArrayList<>();
					counter = newCounter;
					newCounter = 0;
				}
			}
			return result;
		}
	}
}




