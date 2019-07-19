/*
 * @lc app=leetcode id=388 lang=java
 *
 * [388] Longest Absolute File Path
 */
class Solution {
    public int lengthLongestPath(String input) {
        String[] arr = input.split("\n");
        int[] stack = new int[arr.length + 1];
        int maxLen = 0;
        for(String s : arr){
            int level = s.lastIndexOf("\t") + 1;
            // stack[level] + s.length() - level + 1
            // +1: remove all "/t" and add "/"
            int curLen = stack[level + 1] = stack[level] + (s.length() - level + 1);
            if(s.contains("."))
                maxLen = Math.max(maxLen, curLen - 1);
        }
        return maxLen;

    }
}

