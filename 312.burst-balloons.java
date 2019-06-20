/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 */
class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        return helper(nums, 0, nums.length - 1, dp);
    }

    private int helper(int[] nums, int start, int end, int[][] dp) {
        if (start > end)
            return 0;

        if (dp[start][end] != 0)
            return dp[start][end];

        int max = nums[start];

        for (int i = start; i <= end; i++) {
            // Assume that at index i, [start, i - 1] and [i + 1, end] has been bursted already.
            // there remains (start - 1), i, (end + 1) 
            // so getVal(i) * getVal(start - 1) * getVal(end + 1)
            int val = helper(nums, start, i - 1, dp) + getVal(nums, i) * getVal(nums, start - 1) * getVal(nums, end + 1)
                    + helper(nums, i + 1, end, dp);

            max = Math.max(max, val);
        }
        
        dp[start][end] = max;
        return max;
    }

    private int getVal(int[] nums, int i) {
        if (i == -1 || i == nums.length)
            return 1;
        return nums[i];
    }
}
