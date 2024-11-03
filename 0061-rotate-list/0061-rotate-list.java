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
    public ListNode rotateRight(ListNode head, int k) {
        if(head== null || head.next==null || k<=0){
            return head;
        }
        //neads some optimizations

        // ListNode prev=null;
        // ListNode cur=head;
        // for(int i=0;i<k;i++){
        //     while(cur.next!=null){
        //     prev=cur;
        //     cur=cur.next;
        //     }
        //      ListNode temp=head;
        // cur.next=temp;
        // head=cur;
        // prev.next= null;
        // }
        
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
         tail.next = head;
        k=k%length;

        if(k==0){
            tail.next = null;
            return head;
        }
        // Step 3: Find the new tail and new head
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        // Step 4: Break the circle
        newTail.next = null;

        return newHead;
    }
}