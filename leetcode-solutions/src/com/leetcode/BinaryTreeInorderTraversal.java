package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null)
                return List.of();
            List<Integer> result = new ArrayList<>();
            helper(root, result);
            return result;
        }

        public void helper(TreeNode root, List<Integer> result) {
            if (root.left != null) {
                helper(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                helper(root.right, result);
            }
        }
    }

    class IterativeSolution {
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null)
                return List.of();
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> list = new ArrayList<>();
            stack.add(root);
            while (!stack.empty()) {
                TreeNode x = stack.peek();
                if (x.left == null) {
                    list.add(x.val);
                    stack.pop();
                    if (x.right != null) {
                        stack.add(x.right);
                        x.right = null;
                    }
                } else {
                    stack.add(x.left);
                    x.left = null;
                }
            }
            return list;
        }
    }
}

