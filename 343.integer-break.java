/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 */
class Solution {
    public int integerBreak(int n) {
        //DP solution
        //dp store output from 1 to n
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            int max = 1;
            for(int j = 1; j < i; j++){
                int factor1 = Math.max(j, dp[j]);
                int factor2 = Math.max(i - j, dp[i - j]);
                max = Math.max(max, factor1 * factor2);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}

