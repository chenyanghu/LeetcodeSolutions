/*
 * @lc app=leetcode id=233 lang=java
 *
 * [233] Number of Digit One
 */
class Solution {
    public int countDigitOne(int n) {
        int ones = 0;
        for(long i = 1; i <= n; i *= 10){
            ones += (n / i + 8) / 10 * i + (n / i % 10 == 1 ? n % i + 1 : 0); 
        }
        return ones;
    }
}

