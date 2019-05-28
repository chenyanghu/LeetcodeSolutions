/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (43.71%)
 * Total Accepted:    293.2K
 * Total Submissions: 670.8K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * 
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
    public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode x = h;
        while(h.next != null && h.next.next != null){
            ListNode one = h.next;
            ListNode two = h.next.next;
            ListNode three = h.next.next.next;
            h.next = two;
            two.next = one;
            one.next = three;
            h = one;
        }
        return x.next;
    }
}

