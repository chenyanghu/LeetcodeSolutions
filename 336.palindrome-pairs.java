/*
 * @lc app=leetcode id=336 lang=java
 *
 * [336] Palindrome Pairs 
 */
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if(words == null || words.length == 0)
            return res;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++)
            map.put(words[i], i);

        // case 1: blank string ""
        if(map.containsKey("")){
            int blankIdx = map.get("");
            for(int i = 0; i < words.length; i++){
                if(isPalindrome(words[i])){
                    if(i == blankIdx)
                        continue;
                    res.add(Arrays.asList(blankIdx, i));
                    res.add(Arrays.asList(i, blankIdx));
                }
            }
        }
        // case 2: str1 and str2 are palindromed --> abc and cba
        for(int i = 0; i < words.length; i++){
            String str = reverse(words[i]);
            if(map.containsKey(str)){
                int index = map.get(str);
                if(index == i)
                    continue;
                res.add(Arrays.asList(i, index));
            }
        }
        
        for(int i = 0; i < words.length; i++){
            String str = words[i];
            for(int j = 1; j < str.length(); j++){
                // case 3: s1 -> s1[0, cut] is Palindrome 
                //         -> check if there exists s2 = reverse(s1[cut,]) in map 
                //         -> pair(s2, s1)
                if(isPalindrome(str.substring(0, j))){
                    String strcut = reverse(str.substring(j));
                    if(map.containsKey(strcut)){
                        int index = map.get(strcut);
                        if(index == i)
                            continue;
                        res.add(Arrays.asList(index, i));
                    }
                }
                // case 4: s1 -> s1[cut, ] is palindrome 
                //         -> check if there exists s2 = reverse(s1[0, cut]) in map
                //         -> pair(s1, s2)
                if(isPalindrome(str.substring(j))){
                    String strcut = reverse(str.substring(0, j));
                    if(map.containsKey(strcut)){
                        int index = map.get(strcut);
                        if(index == i)
                            continue;
                        res.add(Arrays.asList(i, index));
                    }
                }
            }
        }
        return res;
    }

    private String reverse(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    private boolean isPalindrome(String str){
        int start = 0, end = str.length() - 1;
        while(start <= end){
            if(str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}

