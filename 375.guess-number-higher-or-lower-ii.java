/*
 * @lc app=leetcode id=375 lang=java
 *
 * [375] Guess Number Higher or Lower II
 */
class Solution {
    public int getMoneyAmount(int n) {
        int[][] res = new int[n + 1][n + 1];
        return helper(res, 1, n);
    }

    private int helper(int[][] res, int start, int end){
        if(start >= end)
            return 0;
        if(res[start][end] != 0)
            return res[start][end];

        int result = Integer.MAX_VALUE;
        for(int i = start; i <= end; i++){
            int tmp = i + Math.max(helper(res, start, i - 1), helper(res, i + 1, end));
            result = Math.min(result, tmp);
        }
        res[start][end] = result;
        return result;
    }
}

