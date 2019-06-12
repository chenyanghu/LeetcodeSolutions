/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 */
class Solution {
    public int minCut(String s) {

        /**
         * Key points:
         * 1. cut[i] : the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome.
         * 
         * 2. DP solution: If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i].
         * 
         * */
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for(int i = 0; i < n; i++){
            int min = i;
            for(int j = 0; j <= i; j++){
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])){
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }

        return cut[n - 1];
    }
}

