/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        // sum of left and right
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        // update max value
        // check if current left - root - right path is larger than max
        max = Math.max(max, root.val + left + right);
        // compare which branch has the max value
        // return the maximum value
        return root.val + Math.max(left, right);
    }
}

