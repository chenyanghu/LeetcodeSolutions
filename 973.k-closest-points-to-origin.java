/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        //Use comparator
        //to sort all points by x^2 + y^2
        //return first K
        
        Comparator<int[]> comparator = (p1, p2) -> {
            return (p1[0] * p1[0] + p1[1] * p1[1] - (p2[0] * p2[0] + p2[1] * p2[1]));
        };

        Arrays.sort(points, comparator);
        return Arrays.copyOfRange(points, 0, K);
    }
}

