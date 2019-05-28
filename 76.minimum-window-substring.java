/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0)
            return "";
        // Count how many of each character appears
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        // minLeft: start index of min window
        // minLen: length of min window
        // count: record how many character in t has been traversed
        int left = 0, minLeft = 0, minLen = s.length() + 1, count = 0;
        // rigth: second pointer, move right and check
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0)
                    count++;
                // when all character in t has been traversed
                while (count == t.length()) {
                    // update minLen
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0)
                            count--;
                    }
                    left++;
                }
            }
        }
        if (minLen > s.length())
            return "";

        return s.substring(minLeft, minLeft + minLen);
    }
}
