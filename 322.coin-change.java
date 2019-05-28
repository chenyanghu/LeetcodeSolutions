import java.util.Map;

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */
class Solution {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        if(map.containsKey(amount))
            return map.get(amount);
        int n = amount + 1; // the number of coins will not exceed amount + 1
        for(int coin : coins){
            int cur = 0;
            if (amount >= coin){
                //recursion to get how many left are needed
                int next = coinChange(coins, amount - coin);
                if(next >= 0)
                    cur = 1 + next;
            }
            if(cur > 0)
                n = Math.min(n, cur);
        }
        int finalCount = (n == amount + 1) ? -1 : n;
        map.put(amount, finalCount);
        return finalCount;
    }
}

