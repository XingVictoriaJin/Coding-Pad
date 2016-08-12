/*
Write a program to find the node at which the intersection of two singly 
linked lists begins.
For example, the following two linked lists:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */

public class Solution160 {
      public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA= headA;
        ListNode nodeB= headB;
        int n=0;
        int m=0;
        if(nodeA == null || nodeB == null){return null;}
        
        while( nodeA != null ){
             n++;
             nodeA=nodeA.next;
        }
        
        while( nodeB != null ){
             m++;
             nodeB=nodeB.next;
        }
        nodeA=headA;
        nodeB=headB;
        int diff =Math.abs(n-m);
        int i=0;
        if (n>m) {
          while(diff > 0){nodeA=nodeA.next;diff--;}
           while(i<m-1){
            if(nodeA.val == nodeB.val) {return nodeA;}
            i++;
            nodeA=nodeA.next;
            nodeB=nodeB.next;
           }

        }
        else{
           while(diff >0){nodeB=nodeB.next;diff--;}
           while(i<n-1){
            if(nodeB.val == nodeA.val) {return nodeB;}
            i++;
            nodeA=nodeA.next;
            nodeB=nodeB.next;
           }
        }
        
     return null;
    }
}
