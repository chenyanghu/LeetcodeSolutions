/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];

        int[] res = new int[nums.length - k + 1];
        int indexR = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            if (!deque.isEmpty() && deque.peek() < i - k + 1)
                deque.poll();

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();

            deque.offer(i);
            if (i >= k - 1) {
                res[indexR++] = nums[deque.peek()];
            }
        }
        return res;
    }
}
