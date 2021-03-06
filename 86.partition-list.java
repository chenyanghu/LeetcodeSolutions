/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (36.62%)
 * Total Accepted:    156.6K
 * Total Submissions: 427.6K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(0), l2 = new ListNode(0);
        ListNode cur1 = l1, cur2 = l2;

        while(head != null){
            if(head.val < x){
                cur1.next = head;
                cur1 = cur1.next;
            }
            else{
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        
        cur2.next = null;
        cur1.next = l2.next;

        return l1.next;
    }
}

