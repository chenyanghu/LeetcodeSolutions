class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<List<Integer>>();
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), nums);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> tmp, int[] nums){
        if(tmp.size() == nums.length){ //所有元素被选中，添加到结果中
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(tmp.contains(nums[i]))//元素存在于列表中，跳过
                continue;
            tmp.add(nums[i]);
            helper(res, tmp, nums);//recursion for backtracking
            tmp.remove(tmp.size() - 1);
        }
    }
}

