/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */
class Solution {
    public int numDistinct(String s, String t) {
        // DP solution
        // res[i][j]: # of distinct subseqs t(0, i) does s(0, j) have         
        int res[][] = new int[t.length() + 1][s.length() + 1];

        for(int i = 0; i <= s.length(); i++)
            res[0][i] = 1;

        for(int i = 0; i < t.length(); i++)
            for(int j = 0; j < s.length(); j++){
                if(t.charAt(i) == s.charAt(j))
                    res[i + 1][j + 1] = res[i][j] + res[i + 1][j];
                else
                    res[i + 1][j + 1] = res[i + 1][j];
            }
        
        return res[t.length()][s.length()];
        
        
    }
}

