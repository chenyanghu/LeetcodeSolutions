/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2)
            return;
        int index = nums.length - 1;
        
        while(index > 0){
            if(nums[index] > nums[index - 1])
                break;
            index--;
        }
        // example: 321 --> 123
        if(index == 0){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // example: 132 -> 312
        else{
            int j = nums.length - 1;
            while(j >= index){
                if(nums[j] > nums[index - 1])
                    break;
                j--;
            }

            swap(nums, j, index - 1);
            reverse(nums, index, nums.length - 1);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end){
        if(start > end)
            return;
        while(start < end){
            swap(nums, start++, end--);
        }
    }
}

