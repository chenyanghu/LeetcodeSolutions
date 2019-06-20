/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 */
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        // [start, end, height] in buildings[]
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        /**
         * height first element: position second element: height [start, end, height],
         * START POSITION has the negative height
         * 
         */

        List<int[]> height = new ArrayList<>();

        for (int[] building : buildings) {
            height.add(new int[]{building[0], -building[2]});
            height.add(new int[]{building[1], building[2]});
        }

        /**
         * Redefine comparator Sort height list by positions from left to right
         * 
         */

        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        // maxHeap to store possible HEIGHT
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        // view all points in order
        for (int[] point : height) {
            int currentHeight = Math.abs(point[1]);
            if (point[1] < 0) {
                if (currentHeight > pq.peek())
                    res.add(Arrays.asList(point[0], currentHeight));
                pq.offer(currentHeight);
            } else {
                pq.remove(currentHeight);
                if (currentHeight > pq.peek())
                    res.add(Arrays.asList(point[0], pq.peek()));
            }
        }
        return res;
    }
}
