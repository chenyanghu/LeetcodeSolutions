/*
 * @lc app=leetcode id=214 lang=java
 *
 * [214] Shortest Palindrome
 */
class Solution {
    public String shortestPalindrome(String s) {
        // two way pointer: left to right -> i , right to left -> j

        int i = 0, end = s.length() - 1, j = end;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                i = 0;
                end--;
                j = end;
            }
        }

        StringBuilder sb = new StringBuilder(s.substring(end + 1, s.length()));

        return sb.reverse().toString() + s;
    }
}

