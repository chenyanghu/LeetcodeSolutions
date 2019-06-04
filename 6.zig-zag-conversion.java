/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */
class Solution {
    public String convert(String s, int numRows) {
        if(s == "" || s.length() == 0)
            return "";
        StringBuffer[] sb = new StringBuffer[numRows];
        char[] chars = s.toCharArray();

        for(int i = 0; i < numRows; i++)
            sb[i] = new StringBuffer();
        int i = 0;

        while(i < chars.length){
            for(int index = 0; index < numRows && i < chars.length; index++){
                sb[index].append(chars[i++]);
            }
            for(int index = numRows - 2; index > 0 && i < chars.length; index--){
                sb[index].append(chars[i++]);
            }
        }
        StringBuffer res = new StringBuffer();
        for(StringBuffer strBuff : sb){
            res.append(strBuff);
        }
        return res.toString();
    }
}

