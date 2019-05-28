import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (53.50%)
 * Total Accepted:    204.3K
 * Total Submissions: 381.8K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * 
 * 
 * Note:
 * 
 * 
 * Each element in the result must be unique.
 * The result can be in any order.
 * 
 * 
 * 
 * 
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];
        Set<Integer> res = new HashSet<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for(int n : nums1)
            set.add(n);
        for(int n : nums2){
            if(set.contains(n))
                res.add(n);
        }
        int[] result = new int[res.size()];
        int i = 0;
        for(int n : res){
            result[i++] = n;
        }
        return result;
    }
}

