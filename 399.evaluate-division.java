/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i = 0; i < values.length; i++){
            map.putIfAbsent(equations.get(i).get(0), new HashMap<>());
            map.putIfAbsent(equations.get(i).get(1), new HashMap<>());
            map.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            map.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
        }

        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1, map, new HashSet<>());
        }
        return res;
    }

    private double dfs(String s, String t, double result, Map<String, Map<String, Double>> map, Set<String> seen){
        if(!map.containsKey(s) || !seen.add(s))
            return -1;
        if(s.equals(t))
            return result;

        Map<String, Double> next = map.get(s);

        for(String str : next.keySet()){
            double res = dfs(str, t, result * next.get(str), map, seen);
            if(res != -1)
                return res;
        }
        return -1;
    }
}

