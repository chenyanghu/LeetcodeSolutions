/*
 * @lc app=leetcode id=397 lang=java
 *
 * [397] Integer Replacement
 */
class Solution {
    public int integerReplacement(int n) {
        int count = 0;
        while(n != 1){
            if((n & 1) == 0)
                n >>>= 1;
            else if(n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1))
                n--;
            else
                n++;

            count++;
        }
        return count;
    }
}

