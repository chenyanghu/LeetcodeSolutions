/*
 * @lc app=leetcode id=412 lang=java
 *
 * [412] Fizz Buzz
 */
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i % 3 != 0 && i % 5 != 0)
                list.add(String.valueOf(i));
            else if(i % 3 == 0 && i % 5 != 0)
                list.add("Fizz");
            else if(i % 3 != 0 && i % 5 == 0)
                list.add("Buzz");
            else
                list.add("FizzBuzz");
        }
        return list;
    }
}

