/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        
        int len = 0;
        ListNode l = head; //len is the length of this list
        while(l != null)
        {
            len++;
            l = l.next;
        }
           
        int round = len / k;   //cut the list, so we have 'round' lists with size k 
        if(round == 0) return head;

        ListNode dummy = new ListNode(0);
        dummy.next= head;
        ListNode pre = dummy;

        // reverse round groups of k - size nodes
        for(int i = 0; i < round; i++){
            ListNode first = pre.next;
            ListNode second = first.next;
            // reverse k nodes
            for(int j = 0; j < k - 1; j++){
                first.next = second.next;
                second.next = first;
                pre.next = second;
                second = first.next;
            }
            pre = first;
        }
        return dummy.next;
    }
}

