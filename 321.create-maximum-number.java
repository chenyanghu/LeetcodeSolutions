/*
 * @lc app=leetcode id=321 lang=java
 *
 * [321] Create Maximum Number
 */
class Solution {
    // step 1: find largest number of two arrays with length from 1 to k 
    // step 2: merge each pairs of largest numbers
    // step 3: find the largest one.
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[k];
        for(int len1 = Math.max(0, k - n); len1 <= Math.min(m, k); len1++){
            int len2 = k - len1;
            int[] candidate = merge(maxArray(nums1, len1), maxArray(nums2,len2));
            if(greater(candidate, 0, res, 0))
                res = candidate;
        }
        return res;
    }
    // step 1: find largest number of array in "nums1[]" with length of "len"
    private int[] maxArray(int[] nums, int len){
        int[] res = new int[len];
        // i: index of array nums1[]
        // idx: index of result array res[]
        for(int i = 0, idx = 0; i < nums.length && idx < len; i++){
            // nums1.length - i >= len - idx
            // # of remaining elements in nums1[] is larger than that of remaining elements in res[]
            // need to go back to replace element in res[]
            while(idx != -1 && nums[i] > res[idx] && nums.length - i >= len - idx)
                idx--;
            if(idx + 1 < len)
                res[++idx] = nums[i];
        }
        return res;
    }
    // step 2: merge two arrays
    private int[] merge(int[] a, int[] b){
        int[] res = new int[a.length + b.length];
        for(int idx = 0, i = 0, j = 0; idx < res.length; idx++){
            if(greater(a, i, b, j))
                res[idx] = a[i++];
            else
                res[idx] = b[j++];
        }
        return res;
    }

    private boolean greater(int[] a, int i, int[] b, int j){
        for(; i < a.length && j < b.length; i++, j++){
            if(a[i] == b[j])
                continue;
            return a[i] > b[j];
        }
        return i != a.length;
    }
}

