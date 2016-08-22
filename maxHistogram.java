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
