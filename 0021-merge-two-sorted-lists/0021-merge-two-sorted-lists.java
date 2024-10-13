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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         ListNode anshead= new ListNode(-1);
        ListNode anstail=anshead;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                anstail.next=new ListNode(list1.val);
                list1=list1.next;
            }else{
                anstail.next=new ListNode(list2.val);
                list2=list2.next;
            }
            anstail=anstail.next;
        }
        while(list1!=null){
                anstail.next=new ListNode(list1.val);
                list1=list1.next;
            anstail=anstail.next;
        }

        while( list2!=null){
                anstail.next=new ListNode(list2.val);
                list2=list2.next;
            anstail=anstail.next;
        }
        ListNode t1 = anshead;
         anshead=anshead.next;
         t1.next=null;
         return anshead;
    }
}