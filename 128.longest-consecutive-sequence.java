import java.util.Set;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums)
            set.add(num);
        
        int longestConSeq = 1;

        // check if (num - 1) and (num + 1) exist in nums[]
        for(int num : nums){
            if(!set.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;

                while(set.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestConSeq = Math.max(longestConSeq, currentStreak);
            }
        }
        return longestConSeq;
    }
}

