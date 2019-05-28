class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int res = dfs(root);
        return res;
    }
    private int dfs(TreeNode root){
        if(root == null)
            return 0;
        int ans = 0;
        if(root.left != null)
            if(root.left.left == null && root.left.right == null)
                ans += root.left.val;
            else
                ans += dfs(root.left);
        ans += dfs(root.right);
        return ans;
    }
}

