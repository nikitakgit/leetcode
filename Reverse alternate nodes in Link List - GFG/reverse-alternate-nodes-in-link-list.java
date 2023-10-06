//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node odd)
    {
        Node parent = null;
        Node temp = null;
        Node temp_start = null;
        int count = 0;
        while(odd != null){
            count++;
            if(count % 2 == 0){
                parent.next = odd.next;
                if(temp == null){
                    temp = new Node(odd.data);
                }else{
                    Node newNode = new Node(odd.data);
                    newNode.next= temp;
                    temp = newNode;
                }
            }else{
               temp_start = odd; 
            }        
            parent  = odd;
            odd = odd.next;
        }
        temp_start.next = temp;
    }
}
