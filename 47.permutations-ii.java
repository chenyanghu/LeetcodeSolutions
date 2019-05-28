class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), nums, used);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] used){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i])
                continue;
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            tmp.add(nums[i]);
            helper(res, tmp, nums, used);
            used[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}

