/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */
class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++)
            arr[s.charAt(i) - 'a']++;

        for(int i = 0; i < s.length(); i++)
            if(arr[s.charAt(i) - 'a'] == 1)
                return i;
        
        return -1;
    }
}

