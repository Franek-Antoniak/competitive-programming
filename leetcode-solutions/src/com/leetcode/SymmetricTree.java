package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
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
    class IterativeSolution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null)
                return true;
            return BFS(root.left, root.right);
        }

        private boolean BFS(TreeNode left, TreeNode right) {
            Queue<TreeNode> qL = new LinkedList<>();
            Queue<TreeNode> qR = new LinkedList<>();
            qL.add(left);
            qR.add(right);
            while (!qL.isEmpty()) {
                TreeNode l = qL.poll();
                TreeNode r = qR.poll();
                if (l == null || r == null) {
                    if (!(l == r)) return false;
                    continue;
                }
                if (l.val == r.val) {
                    qR.add(r.right);
                    qR.add(r.left);
                    qL.add(l.left);
                    qL.add(l.right);
                } else {
                    return false;
                }
            }
            return qR.isEmpty();
        }
    }
    class RecursiveSolution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null || right == null)
                return left == right;
            if (left.val == right.val)
                return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
            return false;
        }
    }
}



