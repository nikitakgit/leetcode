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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur=head;
        ListNode[] ans=new ListNode[k];
        int i=0,len=0;
        while(cur!=null)
        {
            len++;
            cur=cur.next;
        }
        
        int extra=len%k;
        int partLen=len/k;
        cur=head;
        while(cur!=null)
        {
            ans[i++]=cur;
            int curLen=partLen-1+((extra-- >0)?1:0);
            
            for(int j=0;j<curLen;j++)
                cur=cur.next;
            ListNode temp=cur.next;
            cur.next=null;
            cur=temp;
        }
        return ans;
    }
}



