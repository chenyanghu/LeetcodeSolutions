/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0)
            return 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val)
                continue;
            nums[j++] = nums[i];
        }
        return j;
    }
}

