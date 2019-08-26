/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % 2 != 0)
            return false;
        sum /= 2;
        // Assume dp[i][j] means whether the specific 
        //           sum j can be gotten from the first i numbers
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        dp[0][0] = true;
        for(int i = 1; i < dp.length; i++)
            dp[i][0] = true;
        for(int i = 1; i < dp[0].length; i++)
            dp[0][i] = false;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                dp[i][j] = dp[i - 1][j];
                if(j >= nums[i - 1])
                // dp[i - 1][j - nums[i - 1]]: previous status
                //      first i - 1 numbers WITH not picking nums[i - 1]
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[nums.length][sum];
    }
}

