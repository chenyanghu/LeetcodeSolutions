/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */
class Solution {
    int begin = 0, max = 0;
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length < 2)
            return s;
        for(int i = 0; i < length - 1; i++){
            helper(s, i, i); // for odd length
            helper(s, i, i + 1); // for even length
        }
        return s.substring(begin, begin + max);
    }
    private void helper(String s, int start, int end){ 
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        if(end - start - 1 > max){
            begin = start + 1;
            max = end - start - 1;
        }
    }
}

