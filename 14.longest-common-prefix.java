/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        String first = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(first) != 0)
                first = first.substring(0, first.length() - 1);
            i++;
        }
        return first;
    }
}

