import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (23.33%)
 * Total Accepted:    241.7K
 * Total Submissions: 1M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = beginWord.length();

        Map<String, ArrayList<String>> dict = new HashMap<String, ArrayList<String>>();

        for(String word : wordList){
            for(int i = 0; i < length; i++){
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);
                ArrayList<String> transformation = dict.getOrDefault(newWord, new ArrayList<String>());
                transformation.add(word);
                dict.put(newWord, transformation);
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<Pair<String, Integer>>();
        queue.add(new Pair<String, Integer>(beginWord, 1));

        Map<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);

        while(!queue.isEmpty()){
            Pair<String, Integer> pair = queue.remove();
            String word = pair.getKey();
            int level = pair.getValue();
            for(int i = 0; i < length; i++){
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);
                for(String s : dict.getOrDefault(newWord, new ArrayList<>())){
                    if(s.equals(endWord))
                        return level + 1;
                    
                    if(!visited.containsKey(s)){
                        visited.put(s, true);
                        queue.put(new Pair<String, Integer>(s, level + 1));
                    }

                }
            }
        }
        return 0;
    }
}

