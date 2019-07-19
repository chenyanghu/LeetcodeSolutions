/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length == 0 || matrix == null)
            return 0;
        int m = matrix.length;
        int low = matrix[0][0];
        int high = matrix[m - 1][m - 1];
        while(low < high){
            int mid = (low + high) / 2;
            // counting: # of elements in matrix that are smaller than mid
            int count = counting(matrix, mid);
            if(count < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    private int counting(int[][] matrix, int target){
        int count = 0;
        int i = matrix.length - 1;
        int j = 0;
        while(i >=0 && j < matrix.length){
            if(matrix[i][j] <= target){
                j++;
                count += i + 1;
            }
            else
                i--;
        }
        return count;
    }
}

