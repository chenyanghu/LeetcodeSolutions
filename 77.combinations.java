class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> tmp, int start, int n, int k){
        if(k == 0){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = start; i <= n; i++){
            tmp.add(i);
            helper(res, tmp, i + 1, n , k - 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}

