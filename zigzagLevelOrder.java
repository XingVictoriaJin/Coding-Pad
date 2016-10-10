/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
                   List<List<Integer>> result = new ArrayList<List<Integer>>();
		   int flag = 0;
		   TreeNode curr = root;
		   Deque<TreeNode> stack = new LinkedList<TreeNode>();
		   stack.offerFirst(curr);
		   int size = 0;
		   TreeNode node = null;		  
		   while( !stack.isEmpty()){
				size = stack.size();
				 List<Integer> list = new ArrayList<Integer>();
			  if(flag == 0){// need to print from left to right, store opposite				
				while( size > 0) {
				   node = stack.pollLast();
				   list.add(node.val);
				   if(node.left != null)stack.offerFirst(node.left);
				   if(node.right != null)stack.offerFirst(node.right);
				   size--;
				 }
			  }else{// need to print from right to left
				while( size > 0) {
			       node = stack.pollFirst();
			       list.add(node.val);
				   if(node.right != null)stack.offerLast(node.right);
				   if(node.left != null)stack.offerLast(node.left);
				   size--;
				   }
			  }
			  result.add(list);
			  flag = 1 - flag;
		   }
		   return result;
    }
}
