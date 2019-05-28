/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || words == null || words.length == 0)
            return res;

        int len = words[0].length();
        // count the # of each string in words
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : words)
            map.put(str, map.getOrDefault(str, 0) + 1);

        // s.length() - len * word.length: MAX Start Index
        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < words.length; j++) {
                // Generate each len length of substring of s
                // Check if it can be found in words[]
                String str = s.substring(i + j * len, i + (j + 1) * len);
                if (copy.containsKey(str)) {
                    int count = copy.get(str);
                    if (count == 1)
                        copy.remove(str);
                    else
                        copy.put(str, count - 1);
                    if (copy.isEmpty()) {
                        res.add(i);
                        break;
                    }
                } else
                    break;
            }
        }
        return res;
    }
}
