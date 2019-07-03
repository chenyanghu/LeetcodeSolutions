/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */
class TrieNode{
    public TrieNode[] children;
    public boolean isEnd;
    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}

 class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root;
        for(char a : word.toCharArray()){
            if(temp.children[a - 'a'] == null)
                temp.children[a - 'a'] = new TrieNode();
            temp = temp.children[a - 'a'];
        }
        temp.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        for(char a : word.toCharArray()){
            if(temp.children[a - 'a'] == null)
                return false;
            else
                temp = temp.children[a - 'a'];
        }
        return temp.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(char a : prefix.toCharArray()){
            if(temp.children[a - 'a'] == null)
                return false;
            else
                temp = temp.children[a - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

