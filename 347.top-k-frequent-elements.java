import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (53.87%)
 * Total Accepted:    185.6K
 * Total Submissions: 344.4K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * Note: 
 * 
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * 
 * 
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
            else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        List<Integer>[] bucket = new List[nums.length + 1];

        for(int n : map.keySet()){
            int freq = map.get(n);
            if(bucket[freq] == null){
                bucket[freq] = new LinkedList<Integer>();
            } 
            bucket[freq].add(n);
        }
        List<Integer> res = new LinkedList<Integer>();
        for(int i = bucket.length - 1; i > 0 && k > 0; i--){
            if(bucket[i] != null){
                res.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }
        return res;
    }
}

