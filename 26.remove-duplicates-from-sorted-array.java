/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[j] != nums[i])
                nums[++j] = nums[i];
        }
        return ++j;
    }
}

