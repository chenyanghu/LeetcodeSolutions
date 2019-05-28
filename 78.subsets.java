class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start){
        res.add(new ArrayList<Integer>(tmp));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1])
                continue;
            tmp.add(nums[i]);
            helper(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}

