import java.util.HashMap;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    private List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);
        LinkedList<String> res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String str : wordDict) {
            // check if each word in wordDict is a start of given String
            if (s.startsWith(str)) {
                // Recursion
                // divide the string and put substring into the function
                List<String> sublist = DFS(s.substring(str.length()), wordDict, map);
                for (String substr : sublist)
                    res.add(str + (substr.isEmpty() ? "" : " ") + substr);
            }
        }
        map.put(s, res);
        return res;
    }
}

