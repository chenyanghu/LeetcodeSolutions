/*
 * @lc app=leetcode id=390 lang=java
 *
 * [390] Elimination Game
 */
class Solution {
    public int lastRemaining(int n) {
        int remaining = n;
        int step = 1;
        boolean leftToRight = true;
        int res = 1;
        while(remaining > 1){
            if(leftToRight || remaining % 2 == 1){
                res += step;
            }
            remaining /= 2;
            step *= 2;
            leftToRight = !leftToRight;
        }
        return res;
    }
}

