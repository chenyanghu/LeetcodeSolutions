/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */
class Solution {
    public String removeKdigits(String num, int k) {
        int length = num.length();
        if(length == k)
            return "0";
        
        int index = 0;
        Stack<Character> stack = new Stack<>();

        while(index < length){
            // Greedy
            // remove ele in stack if stack.peek() > charAt(i)
            // stack: stores result
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(index)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index));
            index++;
        }
        // case: "1111"
        while(k > 0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        sb.reverse();
        // case: "011"
        while(sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        
        return sb.toString();
    }
}

