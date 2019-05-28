/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */
class Solution {
    public int minDistance(String word1, String word2) {
        // DP solution
        int m = word1.length();
        int n = word2.length();
        // res: Min steps to transform 
        // from word1.substring(0, i) to word2.substring(0, j)
        int[][] res = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            res[i][0] = i;
        for (int i = 0; i <= n; i++)
            res[0][i] = i;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                // same character at i, j
                // res[i][j] = res[i - 1][j - 1]
                if (word1.charAt(i) == word2.charAt(j))
                    res[i + 1][j + 1] = res[i][j];
                else {
                    // select best result from (i,j) (i + 1,j) (i,j + 1)
                    // and update the value with plusing 1
                    int a = res[i][j];
                    int b = res[i][j + 1];
                    int c = res[i + 1][j];
                    res[i + 1][j + 1] = Math.min(a, Math.min(b, c)) + 1;
                }
            }

        return res[m][n];
    }
}
