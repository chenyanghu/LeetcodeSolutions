class Solution {
    public int rob(TreeNode root) {
        int[] nums = dfs(root);
        return Math.max(nums[0], nums[1]);
    }
    //res[0] : Max value wihle robbing this house
    //res[1] : Max value while not robbing this house
    private int[] dfs(TreeNode root){
        if(root == null) return new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];
        //Restriction: Cannot rob continuous two houses
        res[0] = left[1] + right[1] + root.val;
        //If not robbing it, the previous could be robbed. Count the maximum for children nodes
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}

