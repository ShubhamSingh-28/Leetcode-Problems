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
        return solve(head,n);
    }

    public ListNode solve(ListNode head, int n){
         ListNode prev= null;
        ListNode first= head;
        ListNode sec= head;
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
            prev=first;
            first=first.next;
        }
        prev.next=first.next;
        first.next=null;
        return head;
    }
}