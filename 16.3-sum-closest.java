/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3)
            return Integer.MIN_VALUE;
        Arrays.sort(nums);
        int res = 0;
        int abs = Integer.MAX_VALUE;
        for(int start = 0; start < nums.length; start++){
            int mid = start + 1, end = nums.length - 1;
            while(mid < end){
                int sum = nums[start] + nums[mid] + nums[end];
                int tmp = sum - target;
                
                if(Math.abs(tmp) < abs){
                    abs = Math.abs(tmp);
                    res = sum;
                }

                if(sum < target){
                    while(++mid < end && nums[mid - 1] == nums[mid])
                        ;
                }
                    
                else{
                    while(--end > mid && nums[end + 1] == nums[end])
                        ;
                }
                    
            }   
        }
        return res;
        }
}

