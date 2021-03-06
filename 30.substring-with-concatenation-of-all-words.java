/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(s == null || words == null || words.length == 0)
            return res;
        Map<String, Integer> map = new HashMap<>();
        for(String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        
        int len = words[0].length();

        for(int i = 0; i <= s.length() - len * words.length; i++){
            Map<String, Integer> copy = new HashMap<>(map);
            for(int j = 0; j < words.length; j++){
                String str = s.substring(i + j * len, i + (j + 1) * len);
                if(copy.containsKey(str)){
                    int count = copy.get(str);
                    if(count == 1)
                        copy.remove(str);
                    else
                        copy.put(str, count - 1);
                    if(copy.isEmpty()){
                        res.add(i);
                        break;
                    }
                }
                else
                    break;
            }
        }
        return res;
    }
}
