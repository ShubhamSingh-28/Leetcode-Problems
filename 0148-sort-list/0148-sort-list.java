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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow= head;
        ListNode prev= null;
        ListNode fast= head;
        while(fast!=null && fast.next!=null){
            prev=slow;
           slow= slow.next;
           fast= fast.next.next;
        }
        prev.next=null;
        ListNode head1= mergeSort(head);
        ListNode head2= mergeSort(slow);
        ListNode ans= merge(head1,head2);
        return ans;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode anshead= new ListNode(-1);
        ListNode anstail=anshead;

        while(l1!=null && l2!= null){
            if(l1.val<=l2.val){
                anstail.next=new ListNode(l1.val);
               l1= l1.next;
            }else{
                anstail.next=new ListNode(l2.val);
               l2= l2.next;
            }
           anstail= anstail.next;
        }
         while(l1!=null){
            anstail.next=new ListNode(l1.val);
            l1=l1.next;
            anstail=anstail.next;
         }
         while(l2!=null){
            anstail.next=new ListNode(l2.val);
            l2=l2.next;
            anstail=anstail.next;
         }

         //ListNode t1 = anshead;
         anshead=anshead.next;
        // t1.next=null;
         return anshead;

    }
}