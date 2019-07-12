/*
 * @lc app=leetcode id=372 lang=java
 *
 * [372] Super Pow
 */
class Solution {
    public int superPow(int a, int[] b) {
        int length = b.length;
        long count = 0;
        for(int i = length - 1; i >= 0; i--)
            count += b[i] * Math.pow(10, length - i - 1);
        return (int)((Math.pow(a, count)) % 1337);
    }
}

