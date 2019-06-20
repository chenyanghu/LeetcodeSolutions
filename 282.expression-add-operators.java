/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 */
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, target, 0, num, 0, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, int target, int pos, String num, long prev, long multi){
        if(pos == num.length()){
            if(target == prev)
                res.add(sb.toString());
            return;
        }

        for(int i = pos; i < num.length(); i++){
            if(num.charAt(pos) == '0' && i != pos)
                break;
            
            long curr = Long.parseLong(num.substring(pos, i + 1));
            int len = sb.length();
            if(pos == 0){
                dfs(res, sb.append(curr), target, i + 1, num, curr, curr);
                sb.setLength(len);
            }
            else{
                dfs(res, sb.append("+").append(curr), target, i + 1, num, prev + curr, curr);
                sb.setLength(len);
                dfs(res, sb.append("-").append(curr), target, i + 1, num, prev - curr, -curr);
                sb.setLength(len);
                dfs(res, sb.append("*").append(curr), target, i + 1, num, prev - multi + multi * curr, multi * curr);
                sb.setLength(len);
            }
        }
    }
}

