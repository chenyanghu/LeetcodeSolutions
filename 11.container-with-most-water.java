/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */
class Solution {
    public int maxArea(int[] height) {
        // solution: two pointers from start and end to middle
        int max = 0, left = 0, right = height.length - 1;
        while(left < right){
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if(height[left] >= height[right])
                right--;
            else
                left++;
        }
        return max;
    }
}

