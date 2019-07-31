/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */
class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<String> resStack = new Stack<String>();
        Stack<Integer> countStack = new Stack<>();

        int index = 0;
        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            }
            else if(s.charAt(index) == '['){
                resStack.push(res);
                res = "";
                index++;
            }
            else if(s.charAt(index) == ']'){
                StringBuilder sb = new StringBuilder(resStack.pop());
                int repeatTime = countStack.pop();
                for(int i = 0; i < repeatTime; i++){
                    sb.append(res);
                }
                res = sb.toString();
                index++;
            }
            else
                res += s.charAt(index++);
        }
        return res;
    }
}

