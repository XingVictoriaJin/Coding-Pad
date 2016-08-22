/* Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
find the area of largest rectangle in the histogram
http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
O(n) time complexity
when poped an element out of teh stack,the element's right
border = the current index -1, the left border of the element
= the index of the element on top of the stack + 1
*/
public int maxHistogram(int[] input){
     int max = Integer.MIN_VALUE;
	 Deque<Integer> stack = new LinkedList<Integer>();
	 for(int i = 1 ; i <= input.length; i++){
		 int curr = (i == input.length) ? 0 : input[i];
				 while(!stack.isEmpty() && (curr <= input[stack.peekFirst()])){
				   int height = input[stack.pollFirst()];
				   // need to check whether stack isEmpty or not again
				   int left = stack.isEmpty() ? 0 : (stack.peekFirst() + 1);
				   int temp = height * (i - left);
				   max = Math.max(max, temp);
				 }
				 stack.offerFirst(i); // insert indices instead of values
		   
	 }
	 
	 return max;
 }
