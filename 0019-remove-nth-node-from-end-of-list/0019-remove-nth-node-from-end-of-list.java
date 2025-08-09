/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev=null;
        ListNode cur=head;
        ListNode sec=head;
        while(n>0 && sec!=null){
            n--;
            sec=sec.next;
        }
        
        if(n!=0){
            return head;
        }

        if(sec==null){
            ListNode temp= head;
            head= head.next;
             temp.next= null;
             return head;
        }

        while(sec!=null){
            sec=sec.next;
            prev=cur;
            cur=cur.next;
        }
        prev.next=cur.next;
        cur.next=null;
        return head;
    }
}