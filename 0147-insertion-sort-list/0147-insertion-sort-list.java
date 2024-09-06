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
    public ListNode insertionSortList(ListNode head) {
        ListNode first= head;
        ListNode sec= head.next;

        while(sec!=null){
            if(first.val<=sec.val){
                first=sec;
                sec=sec.next;
                continue;
            }
            first.next=sec.next;
            ListNode prev= null;
            ListNode t1= head;
            while(t1!=first.next){
               if(sec.val<=t1.val){
                break;
                }
                prev=t1;
                t1=t1.next;
            }
            if(prev==null){
                sec.next=head;
                head=sec;
            } else{
                sec.next=prev.next;
                prev.next=sec;
            }
            sec=first.next;
        }
        return head;
    }
}