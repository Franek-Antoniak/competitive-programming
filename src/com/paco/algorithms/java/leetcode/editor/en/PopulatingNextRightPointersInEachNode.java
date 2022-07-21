/**
 * Solved by Paco
 * Date: 2022-07-08 17:13:30
 * Exercise number: 116
 * Title: populating-next-right-pointers-in-each-node
 * Programming Language: Java
 */


package com.paco.algorithms.java.leetcode.editor.en;

// Definition for a Node.

public class PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Node connect(Node root) {
            func1(root);
            return root;
        }

        private void func1(Node root) {
            if (root != null && root.right != null) {
                root.left.next = root.right;
                if (root.next != null) {
                    root.right.next = root.next.left;
                }
                func1(root.left);
                func1(root.right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}