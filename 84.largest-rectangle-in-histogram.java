/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0, n = heights.length;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while (i < n) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                // update max value
                // size = width * height
                max = Math.max(max, heights[stack.pop()] * (i - (stack.isEmpty() ? 0 : stack.peek() + 1)));
            }
            stack.push(i++);
        }
        while (!stack.isEmpty()) {
            max = Math.max(max, heights[stack.pop()] * (n - (stack.isEmpty() ? 0 : stack.peek() + 1)));
        }
        return max;
    }
}
