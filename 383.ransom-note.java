/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for(char c : magazine.toCharArray()){
            arr[c - 'a']++;
        }
        for(char c : ransomNote.toCharArray()){
            if(--arr[c - 'a'] < 0)
                return false;
        }
        return true;
    }
}

