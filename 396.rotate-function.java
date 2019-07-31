/*
 * @lc app=leetcode id=396 lang=java
 *
 * [396] Rotate Function
 */
class Solution {
    public int maxRotateFunction(int[] A) {
        int F = 0;
        int allSum = 0;
        // allSum: sum of all elements in A[]
        // F: sum of i * A[i];
        for(int i = 0; i < A.length; i++){
            F += i * A[i];
            allSum += A[i];
        }
        int max = F;
        for(int i = A.length - 1; i >= 0; i--){
            F = F + allSum - A.length * A[i];
            max = Math.max(F, max);
        }
        return max;
    }
}

