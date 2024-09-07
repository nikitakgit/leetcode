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
    public boolean isPalindrome(ListNode head) {
       if(head==null || head.next==null) return true;
        ListNode mid=getMiddle(head);
        ListNode secondHalf=reverse(mid.next);
        ListNode firstHalf=head;
        while(secondHalf!=null)
        {
            if(secondHalf.val!=firstHalf.val) return false;
            firstHalf=firstHalf.next;
            secondHalf=secondHalf.next;
        }
        return true;
    }
    public ListNode getMiddle(ListNode head)
    {
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        ListNode nextNode=null;
        while(curr!=null)
        {
            nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }
}

