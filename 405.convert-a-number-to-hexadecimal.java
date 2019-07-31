/*
 * @lc app=leetcode id=405 lang=java
 *
 * [405] Convert a Number to Hexadecimal
 */
class Solution {
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String toHex(int num) {
        if(num == 0)
            return "0";
        String res = "";
        while(num != 0){
            // 15 -> 1111
            res = map[(num & 15)] + res;
            // compare every 4 bits
            num = (num >>> 4);
        }
        return res;
    }
}

