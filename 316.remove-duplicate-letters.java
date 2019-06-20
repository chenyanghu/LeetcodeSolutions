/*
 * @lc app=leetcode id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 */


class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];       
        // Flags of if each character has been visited
        boolean[] visited = new boolean[26];
        char[] chars = s.toCharArray();
        // How many times does each character appear
        for(char c : chars)
            count[c - 'a']++;

        for(char c : chars){
            count[c - 'a']--;
            if(visited[c - 'a'])
                continue;
            // if top in stack is larger than c  --->
            // pop stack and set visited to be false
            while(!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0){
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c- 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();

        for(char c : stack)
            sb.append(c);
        
        return sb.toString();
    }
}

