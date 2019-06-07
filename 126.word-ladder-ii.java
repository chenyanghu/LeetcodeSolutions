/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// BFS + DFS
// Step 1: BFS to build graph (adjaceny list of each word)
//         calculating distance from beginWord to each node in the graph
// Step 2: DFS to traverse and record path from beginWord to endWOrd with shortest path.
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0)
            return new ArrayList<>();
        /**
         * @param result:   result list to store final return list
         * @param graph:    adjacency list of key - store all neighbors of each word
         *                  (neighbor means all words in dictionary that only has one
         *                  character difference with key)
         * @param distance: distance between beginWord and current key word, used for
         *                  tracing path when we do DFS
         * @param dict:     word dictionary, efficient for searching purpose
         */
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        Set<String> dict = new HashSet<>(wordList);

        bfs(beginWord, endWord, dict, map, distance);
        dfs(res, map, distance, endWord, beginWord, new ArrayList<>(Arrays.asList(beginWord)));
        return res;
    }

    // bfs: build adjacent map
    private void bfs(String beginWord, String endWord, Set<String> dict, Map<String, Set<String>> map, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            boolean reachEnd = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                // change each character from 'a' to 'c'
                for (int j = 0; j < curWord.length(); j++) {
                    char[] cArray = curWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        cArray[j] = c;
                        String newString = new String(cArray);
                        if (dict.contains(newString)) {
                            map.putIfAbsent(curWord, new HashSet<String>());
                            map.get(curWord).add(newString);
                        }
                    }
                }

                for (String neighbor : map.get(curWord)) {
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, distance.get(curWord) + 1);
                        if (neighbor.equals(endWord))
                            reachEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
                if(reachEnd)
                    break;
            }
        }
    }

    private void dfs(List<List<String>> res, Map<String, Set<String>> map, Map<String, Integer> distance, String endWord, String curWord, List<String> tempList){
        if(curWord.equals(endWord)){
            res.add(new ArrayList<>(tempList));
            return;
        }

        for(String nextWord : map.get(curWord)){
            // find the word which the distance to curWord is 1
            if(distance.get(nextWord) == distance.get(curWord) + 1){
                tempList.add(nextWord);
                dfs(res, map, distance, endWord, nextWord, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
