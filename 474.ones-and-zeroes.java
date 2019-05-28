import java.util.Map;

/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int count = 0;
        for(String s : strs){
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int i = 0; i < s.length(); i++)
            {
                int num = s.charAt(i) - '0';
                if(!map.containsKey(num))
                    map.put(num, 1);
                map.put(num, map.get(num) + 1);
            }
            int num0 = map.getOrDefault(0, 0);
            int num1 = map.getOrDefault(1, 0);
            if(num0 <= m && num1 <= n)
                count++;
        }
        return count;
    }
}

