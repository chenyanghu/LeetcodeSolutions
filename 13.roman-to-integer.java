/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */
class Solution {
    public int romanToInt(String s) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case 'M':
                    if(i != 0 && s.charAt(i - 1) != 'C')
                        res += 900;
                    else 
                        res += 1000;
                default: 
                    ;
            }
        }
    }
}

