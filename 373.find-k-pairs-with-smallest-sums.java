/*
 * @lc app=leetcode id=373 lang=java
 *
 * [373] Find K Pairs with Smallest Sums
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length == 0 || nums2.length == 0 || k == 0)
            return new ArrayList<List<Integer>>();

        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> b[0] + b[1] - a[0] - a[1]);

        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                pq.offer(new Integer[]{nums1[i], nums2[j]});                    
            }
        }
        for(int i = k; i > 0; i--){
            if(!pq.isEmpty())
                res.add(Arrays.asList(pq.poll()));
        }
        return res;
    }
}

