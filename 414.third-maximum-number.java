/*
 * @lc app=leetcode id=414 lang=java
 *
 * [414] Third Maximum Number
 */
class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for(int num : nums)
            treeSet.add(num);
        
        if(treeSet.size() < 3)
            return treeSet.last();

        treeSet.remove(treeSet.last());
        treeSet.remove(treeSet.last());
        return treeSet.last();
    }
}

