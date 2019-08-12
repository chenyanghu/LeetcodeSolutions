/*
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 */
class Solution {

    Random random;
    int[] weightSum;
    public Solution(int[] w) {
        this.random = new Random();
        for(int i = 1; i < w.length; i++)
            w[i] += w[i - 1];
        this.weightSum = w;
    }
    
    public int pickIndex() {
        int len = weightSum.length;
        int index = random.nextInt(weightSum[len - 1]) + 1;
        int left = 0, right = len - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(weightSum[mid] == index)
                return mid;
            else if(weightSum[mid] < index)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

