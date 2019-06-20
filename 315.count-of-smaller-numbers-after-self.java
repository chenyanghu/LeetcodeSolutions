/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */
class Solution {
    //BST solution

    private class Node {
        // @params val: value of node
        // @params sum: sum of elements that are smaller after self
        // @params dup: # of dup value after self
        private int val, sum, dup;
        private Node left, right;

        public Node(int val, int sum) {
            this.val = val;
            this.sum = sum;
            dup = 1;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--)
            root = insert(nums[i], root, ans, i, 0);

        return Arrays.asList(ans);
    }

    // @params i: inserting node
    // @params node: current node
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } 
        // inserting node's value is small than the current node
        else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } 
        // inserting node's value is larger than the current node
        else
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);

        return node;
    }
}
