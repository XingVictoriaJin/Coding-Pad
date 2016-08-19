  public boolean fourSum(int[] array, int target){
	  boolean result = false;
	  Arrays.sort(array);
	  // assume array is not null, and length >=4
	  for(int i = 0; i < array.length - 3; i++){
		  for(int j = i+1; j < array.length - 2; j++ ){
			  int left = j+1;
			  int right = array.length -1;
			  int curTarget = target - array[i] - array[j];
			  while(left < right){
				  if(array[left] + array[right] == curTarget){
				      return true;
				  }
				  else if(array[left] + array[right] < curTarget){
				    left++;
				  }
				  else{
				  	right--;
				  }
			  }
		  }
	  }
	  
	  return result;
  }
