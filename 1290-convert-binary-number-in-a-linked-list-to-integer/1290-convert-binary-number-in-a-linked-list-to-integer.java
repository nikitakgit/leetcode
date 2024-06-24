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
    public int getDecimalValue(ListNode head) {
        StringBuilder bv = new StringBuilder();
        while (head != null) {
            bv.append(head.val);
            head = head.next;
        }
        
        return binaryToDec(bv.toString());
    }
    
    public int binaryToDec(String s)
    {
        int n=s.length();
        int res=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='1')
            {
                 res+=Math.pow(2,n-1-i);
            }
        }
        return res;
    }
}