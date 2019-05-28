import java.util.Arrays;
import java.util.Comparator;

import javax.lang.model.util.ElementScanner6;

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
        Comparator<Object> comparator = new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2){
                int[] p1 = (int[]) o1;
                int[] p2 = (int[]) o2;
                return (p1[0] * p1[0] + p1[1] * p1[1]) 
                - (p2[0] * p2[0] + p2[1] * p2[1]);
            }   
        };
        Arrays.sort(points, comparator);
        return Arrays.copyOfRange(points, 0, K);
    }
}

