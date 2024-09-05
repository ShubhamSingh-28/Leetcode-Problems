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
    public ListNode reverseKGroup(ListNode head, int k) {
        return rev(head,k);
    }

    public int counter(ListNode head){
        int count= 0;
        ListNode temp = head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }

    public ListNode rev(ListNode head, int k){
        int count= counter(head);
        int groups = count/k;
            ListNode prevhead= null;
            ListNode curhead= head;
            ListNode ans= null;
        for(int i=0;i<groups;i++){
            ListNode prev= null;
            ListNode cur= curhead;
            ListNode nextNode= null;
            for(int j=0;j<k;j++){
                nextNode=cur.next;
                cur.next=prev;
                prev=cur;
                cur=nextNode;
            }
            if(prevhead==null){
                ans=prev;
            } else{
                prevhead.next=prev;
            }
            prevhead=curhead;
            curhead=cur;
        }
        // to link the remaining incomplete group.
        prevhead.next=curhead;
        return ans;
    }
}