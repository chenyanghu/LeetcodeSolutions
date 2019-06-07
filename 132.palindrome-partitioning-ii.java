/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 */
class Solution {
    int min = Integer.MAX_VALUE;
    public int minCut(String s) {
        List<String> tmp = new ArrayList<String>();
        dfs(0, tmp, s);
        return min;
    }

    private void dfs(int pos, List<String> tmp, String s){
        if(pos == s.length() && tmp.size() - 1 <= min){
            min = tmp.size() - 1;
            return;
        }
        
        for(int i = pos; i < s.length(); i++){
            if(isPal(s, pos, i)){
                tmp.add(s.substring(pos, i + 1));
                dfs(i + 1, tmp, s);
                tmp.remove(tmp.size() - 1);
            }
        }
        
    }

    private boolean isPal(String s, int low, int high){
        while(low < high){
            if(s.charAt(low++) != s.charAt(high--))
                return false;
        }
        return true;
    }
}

