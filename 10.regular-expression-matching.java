/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */
class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null)
            return false;
        
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '*' && dp[0][i - 1] == true)
                dp[0][i + 1] = true;
        }

        for(int i = 0; i < s.length(); i++)
            for(int j = 0; j < p.length(); j++){
                if(p.charAt(j) == '.')
                    dp[i + 1][j + 1] = dp[i][j];
                if(p.charAt(j) == s.charAt(i))
                    dp[i + 1][j + 1] = dp[i][j];
                // *: any number of p.charAt(j - 1)
                //  s = "mississippi"
                //  p = "mis*is*p*."
                // case 1: p.charAt(j - 1) != s.charAt(i) AND p.charAt(j - 1) != '.'
                //         ex: last 'p' in string p
                //     dp[i + 1][j + 1] depends on dp[i + 1][j - 1]

                // case 2: equal to neibor result
                if(p.charAt(j) == '*'){
                    if(p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.')
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    else
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                }
            }
        
        return dp[s.length()][p.length()];

    }
}

