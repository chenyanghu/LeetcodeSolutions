/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 *
 * https://leetcode.com/problems/largest-number/description/
 *
 * 
 */
class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                return (s2 + s1).compareTo(s1 + s2);
            }
        };
        Arrays.sort(strs, comp);
        if(strs[0].charAt(0) == '0')
            return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : strs)
            sb.append(s);

        return sb.toString();
    }
}

