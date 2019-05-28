import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */
class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        if(tickets == null || tickets.length == 0)
            return res;
        //using priority queue to store DESTINATIONs
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        for(int i = 0; i < tickets.length; i++){
            if(!map.containsKey(tickets[i][0]))
                map.put(tickets[i][0], new PriorityQueue<String>());
            map.get(tickets[i][0]).add(tickets[i][1]);
        } 
        Stack<String> stack = new Stack<String>();
        //start with JFK
        stack.push("JFK");
        while(!stack.isEmpty()){
            String next = stack.peek();
            if(map.containsKey(next) && map.get(next).size() > 0)
                // put destination from next
                stack.push(map.get(next).poll());
            else
                res.add(stack.pop());
        }
        return
    }
}

