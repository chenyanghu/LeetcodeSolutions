/*
 * @lc app=leetcode id=371 lang=java
 *
 * [371] Sum of Two Integers
 */
class Solution {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}

