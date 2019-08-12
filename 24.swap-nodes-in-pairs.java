/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode start = res;

        while(res.next != null && res.next.next != null){
            ListNode first = res.next;
            ListNode second = res.next.next;
            ListNode third = res.next.next.next;
            
            res.next = second;
            second.next = first;
            first.next = third;

            res = first;
        }
        return start.next;
    }
}

