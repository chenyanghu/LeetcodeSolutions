/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        //Use stack for back tracking
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                // push left child into stack first
                stack.push(root);
                root = root.left;
            }
            // if left = null
            root = stack.pop();
            // check if left < root || root < right
            // pre.val is always larger than or equal to p.val
            // because p is generated from stack
            // which consist of all left nodes
            if (pre != null && root.val <= pre.val)
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}

