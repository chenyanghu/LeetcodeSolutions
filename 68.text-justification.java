/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int index = 0;
        while(index < words.length){
            int count = words[index].length();
            int last = index + 1;
            while(last < words.length){
                if(count + words[last].length() + 1 > maxWidth)
                    break;
                // need to +1 for padding ' '
                count += words[last].length() + 1;
                last++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);
            //count rest # of words in current line
            int diff = last - index - 1;
            //last line OR only one word in a line --> LEFT Adjustification
            if(last == words.length || diff == 0){
                for(int i = index + 1; i < last; i++)
                    sb.append(" " + words[i]);
                for(int i = sb.length(); i < maxWidth; i++)
                    sb.append(" ");
            }
            //else --> Middle Adjustification
            else{
                //# of spaces after each word
                int spaces = (maxWidth - count) / diff;
                //# of spaces to append in the middle
                int r = (maxWidth - count) % diff;
                for(int i = index + 1; i < last; i++){
                    for(int j = spaces; j > 0; j--)
                        sb.append(" ");
                    if(r > 0){
                        sb.append(" ");
                        r--;
                    }
                    sb.append(" " + words[i]);
                }
            }
            res.add(sb.toString());
            index = last;
        }
        return res;
    }
}

