/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */
class Solution {
    public boolean isPalindrome(int x) {
        int res = 0;
        if(x < 0 || (x != 0 && x % 10 == 0))
            return false;
        while(x > res){
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (res == x || res / 10 == x);
    }
}

