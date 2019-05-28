/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        // DP solutions
        // left[]: start index
        // right[]: end index, so right - left equals to length
        // height[]: height
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;

        int[] left = new int[n], right = new int[n], height = new int[n];
        // fill 3 arrays
        // all 0s to left and height, all ns to right
        for (int i = 0; i < n; i++) {
            left[i] = 0;
            right[i] = n;
            height[i] = 0;
        }

        int max = 0;

        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1')
                    right[j] = Math.min(right[j], cur_right);
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    max = Math.max(max, (right[j] - left[j]) * height[j]);
            }
        }
        return max;
    }
}
