package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
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

    class RecursiveSolution {
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            return DFS(root, 0);
        }

        public int DFS(TreeNode root, int counter) {
            if (root == null)
                return counter;
            return Math.max(DFS(root.left, counter + 1), DFS(root.right, counter + 1));
        }
    }

    class IterativeSolution {
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            return BFS(root);
        }

        public int BFS(TreeNode root) {
            int max = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            root.val = 0;
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    temp.val++;
                    if (temp.left != null) {
                        temp.left.val = temp.val;
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        temp.right.val = temp.val;
                        queue.add(temp.right);
                    }
                    max = Math.max(max, temp.val);
                }
            }
            return max;
        }
    }
}
