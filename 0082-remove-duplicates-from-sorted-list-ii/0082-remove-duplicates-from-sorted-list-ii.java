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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp= head;
        ListNode ans= new ListNode(0);
        ListNode anst= ans;
        HashMap<Integer,Integer> m =new HashMap<>();
        while(temp!=null){
            m.put(temp.val, m.getOrDefault(temp.val, 0)+1);
            temp=temp.next;
        }

        temp=head;
        while(temp!=null){
            if(m.get(temp.val)==1){
                anst.next=new ListNode(temp.val);
                anst=anst.next;
            }
            temp=temp.next;
        }
       return ans.next;
    }
}