/*
 * @lc app=leetcode id=87 lang=java
 *
 * [87] Scramble String
 */
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        // chars[26] represent 26 characters
        // Use chars[] to check if s1 and s2
        // have the same amount on each character
        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
        }
        for (int i : chars) {
            if (i != 0)
                return false;
        }

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) 
                    && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                return true;
        }
        return false;
    }
}
