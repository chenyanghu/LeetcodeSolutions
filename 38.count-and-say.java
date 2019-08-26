/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */
class Solution {
    public String countAndSay(int n) {
        if(n <= 1)
            return "1";
        String result = "1";
        for(int i = 1; i < n; i++){
            result = helper(result);
        }
        return result;
    }

    private String helper(String s){
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        while(pos < s.length()){
            char val = s.charAt(pos);
            int count = 0;
            while(pos < s.length() && s.charAt(pos) == val){
                pos++;
                count++;
            }
            sb.append(String.valueOf(count)).append(val);
        }
        return sb.toString();
    }
}

