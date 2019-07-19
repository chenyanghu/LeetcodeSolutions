/*
 * @lc app=leetcode id=368 lang=java
 *
 * [368] Largest Divisible Subset
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();

        int[] dp = new int[nums.length];
        Arrays.sort(nums);
        
        // step 1: find the length of longest subset using DP
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        // step 2: find max length of subset and the index of that
        // the index is also the index of element in nums[]
        int max = 0;
        int index = 0;

        for(int i = 0; i < nums.length; i++){
            if(dp[i] > max){
                max = dp[i];
                index = i;
            }
        }
        
        int num = nums[index];
        List<Integer> ans = new ArrayList<>();
        for(int i = index; i >= 0 ;i--){
            if(num % nums[i] == 0 && dp[index] - dp[i] <= 1){
                ans.add(nums[i]);
                num = nums[i];
                index = i;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}

