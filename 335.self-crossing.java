/*
 * @lc app=leetcode id=335 lang=java
 *
 * [335] Self Crossing
 */
class Solution {
    public boolean isSelfCrossing(int[] x) {
        if(x.length < 4)
            return false;
        
        boolean isUp = false;

        if(x[2] > x[0])
            isUp = true;

        int a0 = 0;
        for(int i = 3; i < x.length; i++){
            //check parallel
            
            //case 1: first paralla decreases and second parallas increases
            //        return true: must cross itself
            if(!isUp && x[i] >= x[i - 2]){
                return true;
            }
            else if(isUp && x[i] <= x[i - 2]){
                //case 2: new pair of parallas keep decreasing
                if(x[i] + a0 < x[i - 2] || (i + 1 < x.length && x[i + 1] + x[i - 3] < x[i - 1]))
                    isUp = false;
                //case 3: 
                else if(i + 1 < x.length)
                    return true;
            }
            a0 = x[i - 3];
        }
        return false;
    }
}

