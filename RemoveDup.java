/*Element deduplication or removal in an sorted array; 
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
		
/*if <=2 can be kept for each item */
	public int[] removeDup( int[] input){
		  // assume input is not null
		  int slow = 2; // left part which is not including slow is processed part 
		  for( int fast = 2; fast < input.length; fast++){
		      if( input[fast] == input[slow - 2]){
		        continue;
		      }
		      input[slow++]=input[fast];
		  }
		  return Arrays.copyOfRange(input, 0, slow);
		}

/* what if remove all the duplicate items */
	public int[] removeDup(int[] input){
		  // assume input is not null
          int fast = 0;
          int slow = 0;
          while( fast < input.length){
        	  	int begin = fast;
        	  	while( fast < input.length && input[fast] == input[begin]){
        	  		fast++;
        	  	}
        	  	if( (fast - begin) == 1 ){
        	  		input[slow++] = input[begin++];
        	  	}
          }
          return Arrays.copyOfRange(input, 0, slow);
		}
