/*
 * @lc app=leetcode id=363 lang=java
 *
 * [363] Max Sum of Rectangle No Larger Than K
 */
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        
        // Kadane's algorithm: max subarray problem
        // update -> array[i] += array[i - 1] if array[i - 1] > 0
        for(int top = 0; top < m; top++){
            int[] sums = new int[n];
            for(int bottom = top; bottom < m; bottom++){
                for(int j = 0; j < n; j++){
                    sums[j] += matrix[bottom][j];
                }

                TreeSet<Integer> treeSet = new TreeSet<>();
                // 0: for single row case
                treeSet.add(0);
                int currSum = 0;

                for(int sum : sums){
                    currSum += sum;
                    Integer num = treeSet.ceiling(currSum - k);
                    if(num != null)
                        max = Math.max(max, currSum - num);
                    treeSet.add(currSum);
                }
            }
        }
        return max;
    }
}

