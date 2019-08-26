/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * 
 */
class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;

        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            sign = -1;

        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        // edge cases
        if(ldivisor == 0)
            return Integer.MAX_VALUE;
        if(ldividend == 0 || ldividend < ldivisor)
            return 0;
        
        long lans = divide(ldividend, ldivisor);

        int ans;

        // edge case
        if(lans > Integer.MAX_VALUE)
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        else
            ans = (int) (sign *lans);

        return ans;
    }

    private long divide(long ldividend, long ldivisor){
        if(ldividend < ldivisor)
            return 0;
        long sum = ldivisor;
        long multiple = 1;
        while((sum + sum) <= ldividend){
            // to reduce time complexity to be logN
            sum += sum;
            // multiple: 1, 2, 4, 8 ....
            multiple += multiple;
        }
        return multiple + divide(ldividend - sum, ldivisor);
    } 
}

