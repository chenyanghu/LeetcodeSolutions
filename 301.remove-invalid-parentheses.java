/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null)
            return res;
        // Set: check if candidate string has been visited
        // Exclude duplicate
        Set<String> visited = new HashSet<String>();
        // BFS queue
        Queue<String> queue = new LinkedList<String>();
        // Initialize
        visited.add(s);
        queue.add(s);
        // found: avoid adding new string to the queue
        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();
            if (isValid(s)) {
                res.add(s);
                found = true;
            }

            if (found)
                continue;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')')
                    continue;
                // remove charAt(i) and put into queue;
                String t = s.substring(0, i) + s.substring(i + 1);
                if (!visited.contains(t)) {
                    visited.add(t);
                    queue.add(t);
                }
            }
        }

        return res;
    }

    private boolean isValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                count++;
            if (str.charAt(i) == ')' && count-- == 0)
                return false;
        }
        return count == 0;
    }
}
