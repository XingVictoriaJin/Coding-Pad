
public class SlidingWindowK {
	static class Element{
		int value;
		int index;
		public Element(int value, int index){
			 this.value = value;
			 this.index = index;
		}
	}
	
  public List<Integer> MaxInSlidingWindowK(int[] input, int k){
	   // create a deque to keep storing m ( k=< m <= n) items from array
	   // assume input.length > k
	  Deque<Element> dq = new LinkedList<Element>();
	  List<Integer> result = new ArrayList<Integer>();
	   for(int i = 0; i < k; i++){
		   dq.offerLast(new Element(input[i], i));
	   }
	   result.add(max(dq));
	   for(int i = k; i < input.length; i++){

		   // if left element from the deque is out of the range
		   if(!dq.isEmpty() && (1 + dq.peekLast().index - dq.peekFirst().index) > 2 ){
				   dq.pollFirst();
		   }
		   while(!dq.isEmpty() && input[i] >= dq.peekLast().value){
			   dq.pollLast();
		   }
		   if(dq.isEmpty() || input[i] < dq.peekLast().value){
			   dq.offerLast(new Element(input[i], i));
		   }
		  result.add(max(dq));
	   }

	   return result;
   }
  
   public int max(Deque<Element> dq){
	   int max = 0;
       Iterator<Element> it = dq.iterator();
       while(it.hasNext()){
    	   max = Math.max(max, it.next().value);
       }
	   return max;
   }
  
}
