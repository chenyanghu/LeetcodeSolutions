import java.util.Stack;

/*
 * @lc app=leetcode id=385 lang=java
 *
 * [385] Mini Parser
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if(s == null || s.isEmpty())
            return null;
        if(s.charAt(0) != '[')
            return new NestedInteger(Integer.valueOf(s));
        
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger res = new NestedInteger();
        stack.push(res);
        int start = 1;
        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '['){
                NestedInteger ni = new NestedInteger();
                stack.peek().add(ni);
                stack.push(ni);
                start = i + 1;
            }
            else if(c == ',' || c == ']'){
                if(i > start){
                    Integer num = Integer.valueOf(s.substring(start, i));
                    stack.peek().add(new NestedInteger(num));
                }
                start = i + 1;
                if(c == ']')
                    stack.pop();
            }
        }
        return res;
    }
}

