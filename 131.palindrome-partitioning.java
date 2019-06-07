/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(res, 0, new ArrayList<String>(), s);
        return res;
    }

    private void dfs(List<List<String>> res, int pos, List<String> tmp, String s){
        if(pos == s.length()){
            res.add(new ArrayList<>(tmp));
            return;
        }
        
        for(int i = pos; i < s.length(); i++){
            if(isPal(s, pos, i)){
                tmp.add(s.substring(pos, i + 1));
                dfs(res, i + 1, tmp, s);
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

