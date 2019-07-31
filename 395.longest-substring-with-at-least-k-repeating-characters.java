/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */
class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, 0 , s.length(), k);
    }

    private int helper(String s, int start, int end, int k){
        // Base case 1: length of substring is smaller than k
        // return 0
        if(end - start < k)
            return 0;
        int[] count = new int[26];
        for(int i = start; i < end; i++)
            count[s.charAt(i) - 'a']++;
        
        for(int i = 0; i < 26; i++){
            // charAt(i) appears less than k times
            // charAt(i) will not be included in the result
            // split the string on position i.
            if(count[i] < k && count[i] >0){
                for(int j = start; j < end; j++){
                    if(s.charAt(j) == i + 'a'){
                        int left = helper(s, start, j, k);
                        int right = helper(s, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        // Base case 2: all characters in substring appears at least k times
        return end - start;
    }
}

