/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            // skip all duplicate
            if(i != 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                int temp = nums[i] + nums[j] + nums[k];
                if(temp == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);

                    while(++j < k && nums[j - 1] == nums[j])
                        ;
                    while(--k > j && nums[k + 1] == nums[k])
                        ;
                }
                // result > 0 : k--
                // result < 0 : j++;
                else if (temp < 0)
                    j++;
                else
                    k--;
            }
        }

        return res;
    }
}

