/**
 * Solved by Paco
 * Date: 2022-07-08 17:12:58
 * Exercise number: 617
 * Title: merge-two-binary-trees
 * Programming Language: Java
 */

package com.paco.algorithms.java.leetcode.editor.en;

public class MergeTwoBinaryTrees {
    class TreeNode {
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

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            return mergeNodes(root1, root2);
        }

        private TreeNode mergeNodes(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 != null) {
                root1 = new TreeNode();
                root1.val = root2.val;
            } else if (root2 == null)
                return root1;
            else
                root1.val += root2.val;
            root1.left = mergeNodes(root1.left, root2.left);
            root1.right = mergeNodes(root1.right, root2.right);
            return root1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}