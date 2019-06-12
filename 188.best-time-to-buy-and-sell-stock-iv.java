/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length <= 1)
            return 0;
        
        // if k > prices.length
        // can make maxProfit by selling the stock everytime when the price is higher than previous day's
        if(k > prices.length / 2){
            int maxProfit = 0;
            for(int i = 1; i < prices.length; i++){
                if(prices[i] > prices[i - 1])
                    maxProfit += prices[i] - prices[i - 1];
            }
            return maxProfit;
        }
        // dp[i][j] : maxProfit at day j when max transactions is i 
        int[][] dp = new int[k + 1][prices.length];
        for(int i = 1; i <= k; i++){
            // first day: only buying stock, profit is -prices[0];
            int localMax = - prices[0];
            for(int j = 1; j < prices.length; j++){
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, dp[i - 1][j - 1] - prices[j]);
            }
        }

        return dp[k][prices.length - 1];
    }
}

