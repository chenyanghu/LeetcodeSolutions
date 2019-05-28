/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<Integer>();

        int[] table = new int[26];

        for(int i = 0; i < S.length(); i++){
            //record last digit of each character
            table[S.charAt(i) - 'a'] = i;
        }

        int last = 0, start = 0;

        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, table[S.charAt(i) - 'a']);
            //if some characters are all taken
            //put the range into the list
            if(last == i){
                res.add(last - start + 1);
                start = last + 1;
            }
        }
        return res;
    }
}

