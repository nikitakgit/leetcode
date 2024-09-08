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
        int cnt=0;
        ListNode temp=head;
        while(temp!=null)
        {
            cnt++;
            temp=temp.next;
        }
        temp=head;
        ListNode prev=null;
        int pos=cnt-n;
        if(pos==0)
        {
            return head.next;
        }
        
        for(int i=0;i<pos-1;i++)
        {
            
            temp=temp.next;
        }
        temp.next=temp.next.next;
        
        return head;
    }
}
        