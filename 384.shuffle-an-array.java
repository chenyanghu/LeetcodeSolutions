import java.util.Random;

/*
 * @lc app=leetcode id=384 lang=java
 *
 * [384] Shuffle an Array
 */
class Solution {
    private int[] nums;
    private Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null)
            return null;
        int[] a = nums.clone();
        for(int j = 1; j < a.length; j++){
            int i = random.nextInt(j + 1);
            // swap
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        return a;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

