/*
 * @lc app=leetcode id=400 lang=java
 *
 * [400] Nth Digit
 */
class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        int count = 9;
        int start = 1;

        // find the range which the target lies on
        while(n > len * count){
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }


    }
}

