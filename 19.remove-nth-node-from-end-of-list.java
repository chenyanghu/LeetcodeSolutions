/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode first = start; 
        ListNode last = start;
        
        first.next = head;
        
        for(int i = 0;i <= n;i++)
            last = last.next;
        
        while(last != null)
            {
                first = first.next;
                last = last.next;
            }
        
        first.next = first.next.next;
        return start.next;
    }
}

