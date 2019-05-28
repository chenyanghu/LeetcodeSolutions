class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //if(head == null || head.next == null)
          //  return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = head;
        ListNode pre = res;
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }   
            if(pre.next == cur){
                pre = cur;
            }  
            else{
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return res.next;
    }
}

