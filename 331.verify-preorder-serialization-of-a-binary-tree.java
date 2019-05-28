/*
 * @lc app=leetcode id=331 lang=java
 *
 * [331] Verify Preorder Serialization of a Binary Tree
 */
class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null)
            return false;
        Stack<String> stack = new Stack<String>();
        String[] strs = preorder.split(",");
        for(int index = 0; index < strs.length; index++){
            String cur = strs[index];
            while(cur.equals("#") && !stack.isEmpty() && cur.equals(stack.peek()))
            {
                stack.pop();
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
            stack.push(cur);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}

