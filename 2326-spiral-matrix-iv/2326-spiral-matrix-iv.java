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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat=new int[m][];
        for(int i=0;i<m;i++)
        {
            mat[i]=new int[n];
            Arrays.fill(mat[i],-1);
        }
        
        int topRow=0,bottomRow=m-1,leftCol=0,rightCol=n-1;
        while(head!=null)
        {
            for(int col=leftCol;col<=rightCol && head!=null;col++)
            {
                mat[topRow][col]=head.val;
                head=head.next;
            }
            topRow++;
            
            for(int row=topRow;row<=bottomRow && head!=null ;row++)
            {
                mat[row][rightCol]=head.val;
                head=head.next;
            }
            rightCol--;
            for(int col=rightCol;col>=leftCol && head!=null ;col--)
            {
                mat[bottomRow][col]=head.val;
                head=head.next;
            }
            bottomRow--;
            for(int row=bottomRow;row>=topRow && head!=null;row--)
            {
                mat[row][leftCol]=head.val;
                head=head.next;
            }
            leftCol++;
        }
        return mat;
    }
}

