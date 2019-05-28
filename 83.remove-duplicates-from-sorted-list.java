/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (42.10%)
 * Total Accepted:    310.4K
 * Total Submissions: 737.3K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->1->2
 * Output: 1->2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->2->3->3
 * Output: 1->2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        
        ListNode res = new ListNode(0);
        res.next = head;

        ListNode l1 = head, pre = res;
        
        while(l1 != null){
            while(l1.next != null && l1.val == l1.next.val ){
                l1 = l1.next;
            }
            pre.next = l1;
            pre = pre.next;
            l1 = l1.next;
        }
        return res.next;
    }
}

