/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        doSerialize(root, sb);
        return sb.toString();
    }

    private void doSerialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }     
        sb.append(root.val + ",");
        doSerialize(root.left, sb);
        doSerialize(root.right, sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
            return null;
        Queue<String> nodes = new LinkedList<String>(Arrays.asList(data.split(",")));
        return doDeserialize(nodes);
    }
    private TreeNode doDeserialize(Queue<String> nodes){
        if(nodes.isEmpty())
            return null;
        String removed = nodes.remove();
        if(removed.equals("null"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(removed));
        node.left = doDeserialize(nodes);
        node.right = doDeserialize(nodes);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

