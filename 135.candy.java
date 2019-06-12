/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */
class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        int[] res = new int[ratings.length];

        Arrays.fill(res, 1);

        for(int i = 1; i < res.length; i++){
            if(ratings[i] > ratings[i - 1])
                res[i] = res[i - 1] + 1;
        }

        for(int i = res.length - 1; i > 0; i--){
            if(ratings[i - 1] > ratings[i]){
                res[i - 1] = Math.max(res[i] + 1, res[i - 1]);
            }
        }
        int sum = 0;

        for(int num : res)
            sum += num;

        return sum;
    }
}

