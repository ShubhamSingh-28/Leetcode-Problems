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
    public ListNode swapPairs(ListNode head) {
        ListNode prev= null;
        ListNode cur=  head;
        while(cur!=null && cur.next!=null){
        ListNode nextNode = cur.next;
        cur.next= nextNode.next;
        nextNode.next = cur;
        if(prev==null){
            head=nextNode;
        }else{
            prev.next=nextNode;
        }
        prev=cur;
        cur=cur.next;
        }
        return head;
    }
}