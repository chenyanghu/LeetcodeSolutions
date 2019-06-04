/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */
class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str == null || str.length() == 0)
            return 0;
        
        int sign = 1, start = 0;
        if(str.charAt(0) == '-'){
            sign = -1;
            start++;
        }
        else if(str.charAt(0) == '+'){
            start++;
        }

        long sum = 0;
        for(int i = start; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i)))
                return (int)sum * sign;
            sum = sum * 10 + str.charAt(i) - '0';
            if(sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int)sum * sign;
    }
}

