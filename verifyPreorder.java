/*
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
You may assume each number in the sequence is unique.
Follow up:
Could you do it using only constant space complexity
*/
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
		  if( preorder == null) {return false;}
          Deque<Integer> stack = new LinkedList<Integer>();
		  stack.offerFirst(preorder[0]);
		  int i = 1;
				while (i < preorder.length 
				  &&  (stack.isEmpty() || preorder[i] < stack.peekFirst() ) ) {
					stack.offerFirst(preorder[i]);
					i++;
				}
				while( i < preorder.length 
					&& !stack.isEmpty() && stack.peekFirst() < preorder[i]){
					stack.pollFirst();
				}
			if(stack.size() == 1){
				return true;
			}
		return false;
    }
}
