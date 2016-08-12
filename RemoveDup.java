/*Element deduplication or removal in an array; 
  use two variables: slow and fast */
	public int[] removeDup( int[] input){
		  // assume input is not null
		  int slow = 0; 
		  for( int fast = 1; fast < input.length; fast++){
		      if( input[fast] == input[slow]){
		        continue;
		      }
		      input[++slow] = input[fast]; 
		  }
		  return Arrays.copyOfRange(input, 0, slow+1);
		}
		
		
		
