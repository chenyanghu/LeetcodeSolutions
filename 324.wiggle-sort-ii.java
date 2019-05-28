import java.util.Arrays;

/*
 * @lc app=leetcode id=324 lang=java
 *
 * [324] Wiggle Sort II
 *
 * https://leetcode.com/problems/wiggle-sort-ii/description/
 *
 * algorithms
 * Medium (27.61%)
 * Total Accepted:    56K
 * Total Submissions: 202.7K
 * Testcase Example:  '[1,5,1,1,6,4]'
 *
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] >
 * nums[2] < nums[3]....
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * 
 * Note:
 * You may assume all input has valid answer.
 * 
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
class Solution {
    public void wiggleSort(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int n = nums.length;
        int left = (n + 1) / 2 - 1;
        int right = n - 1;
        for(int i = 0; i < n; i++){
            if(i % 2 == 1){
                nums[i] = sorted[right];
                right--;
            }
            else{
                nums[i] = sorted[left];
                left--;
            }
        }
    }
}

