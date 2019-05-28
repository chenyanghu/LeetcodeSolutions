/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
 *
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (35.44%)
 * Total Accepted:    213.8K
 * Total Submissions: 602.9K
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example:
 * 
 * 
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        while(head != null){
            if(head.val == val){
                pre.next = head.next;
            } 
            else{
                pre = pre.next;
            }
            head = head.next;
        }
        return res.next;
    }
}

