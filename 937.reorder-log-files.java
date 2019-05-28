import java.util.Arrays;

/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Log Files
 */
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComparator = new Comparator<String>(){
        @Override
        // s1 < s2 --> -1
        // s1 == s2 --> 0
        // s1 > s2 --> 1
            public int compare(String s1, String s2){
                int s1_Second_Index = s1.indexOf(' ');
                int s2_Second_Index = s2.indexOf(' ');
                char s1_First_Char = s1.charAt(s1_Second_Index + 1);
                char s2_First_Char = s2.charAt(s2_Second_Index + 1);

                if(s1_First_Char <= '9'){
                    //if: both are digit-logs
                    if(s2_First_Char <= '9')
                        return 0;
                    //else: s2 is letter-logs
                    else return 1;
                }
                if(s2_First_Char <= '9')
                    return -1;
                
                int preCompute = s1.substring(s1_Second_Index + 1).compareTo(s2.substring(s2_Second_Index +1));
                if(preCompute == 0)
                    //case: log names are the same
                    //compare it identifier 
                    return s1.substring(0, s1_Second_Index).compareTo(s2.substring(0, s2_Second_Index));
                return preCompute;
            }
        }; 

        Arrays.sort(logs, myComparator);

        return logs;
    }
}

