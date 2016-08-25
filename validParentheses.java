public class ValidPS {
	/*
	Get all valid permutations of l pairs of (), m pairs of [] and n pairs of {}.
	Assumptions
	l, m, n >= 0
	Examples
	l = 1, m = 1, n = 0, all the valid permutations are ["()[]", "([])", "[()]", "[]()"]
	*/
	private final static char[] PS = new char[]{'(', ')', '[',']', '{', '}'};
	
	public List<String> validParentheses(int l, int m, int n) {
	   List<String> result = new ArrayList<String>();
		 StringBuilder sb = new StringBuilder();
		 Deque<Character> stack = new LinkedList<Character>();
		 int[] remain = new int[]{ l, l, m, m, n, n };
		 int len = 2 * l +  2 * m  + 2 * n;
		 helper(sb, stack, remain, len, result);
		 return result;
	  }
	  
	  public void helper(StringBuilder sb, Deque<Character> stack, int remain[], int len, List<String> result){
	     if(sb.length() == len) {
			 result.add(sb.toString());
			 return;
		 }
		 for( int i = 0; i < remain.length; i++){
		    if( i % 2 == 0 ){
		    	if(remain[i] > 0){ // forgot this check for the 1st time
					sb.append(PS[i]);
					stack.offerFirst(PS[i]);
					remain[i]--;
					helper(sb, stack, remain, len, result);
					sb.deleteCharAt(sb.length() - 1);
					stack.pollFirst();
					remain[i]++;
		    	}
			}
			else{
			   if ( !stack.isEmpty() && stack.peekFirst() == PS[i - 1]){
				sb.append(PS[i]);
				stack.pollFirst();
				remain[i]--;
				helper(sb, stack, remain, len, result);
				sb.deleteCharAt(sb.length() - 1);
				stack.offerFirst(PS[i-1]);
				remain[i]++;
			   }
			}
		 }
		 
	 }
}
