class Solution {
    public int countNodes(TreeNode root) {
        if(countLeftDepth(root) == countRightDepth(root))
            return (1 << countLeftDepth(root)) - 1;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int countLeftDepth(TreeNode root){
        int depth = 0;
        while(root != null){
            root = root.left;
            depth++;
        }
        return depth;
    }

    private int countRightDepth(TreeNode root){
        int depth = 0;
        while(root != null){
            root = root.right;
            depth++;
        }
        return depth;
    }
}

