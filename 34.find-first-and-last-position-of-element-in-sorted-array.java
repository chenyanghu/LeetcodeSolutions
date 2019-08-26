/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == nums[mid]){
                int i = mid, j = mid;
                while(i >= 0 && nums[i] == target)
                    i--;
                while(j < nums.length && nums[j] == target)
                    j++;
                return new int[]{i + 1, j - 1};
            }
            else if(target > nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return new int[]{-1, -1};
    }
}

