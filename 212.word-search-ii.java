import java.util.List;

/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */
class Solution {
    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, list, i, j, root);
            }
        }
        return list;
    }

    private void dfs(char[][] board, List<String> list, int i , int j, TrieNode node){
        char c = board[i][j];
        if(c == '#' || node.next[c - 'a'] == null)
            return;
        node = node.next[c - 'a'];
        
        // find duplicates
        if(node.word != null){
            list.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        if(i > 0)
            dfs(board, list, i - 1, j, node);
        if(j > 0)
            dfs(board, list, i, j - 1, node);
        if(i < board.length - 1)
            dfs(board, list, i + 1, j, node);
        if(j < board[0].length - 1)
            dfs(board, list, i, j + 1, node);
        board[i][j] = c;

    }
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String s : words){
            TrieNode p = root;
            for(char c : s.toCharArray()){
                int i = c - 'a';
                if(p.next[i] == null)
                    p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = s;
        }
        return root;
    }
}

