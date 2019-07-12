/*
 * @lc app=leetcode id=354 lang=java
 *
 * [354] Russian Doll Envelopes
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) { 
        if(envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length == 0)
            return 0;
        // sort envelopes on w in (w, h)
        Arrays.sort(envelopes, 
            (int[] a, int[] b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] dp = new int[envelopes.length];
        int res = 0;

        for(int i = 0; i < envelopes.length; i++){
            dp[i] = 1;
            // j: from 0 to i
            for(int j = 0; j < i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

