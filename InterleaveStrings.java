public class MajorityNumberI {
  public int majority(int[] array){
	  int cur = array[0];
	  int count = 1;
	  for(int i = 1; i < array.length; i++){
		  if(count == 0){
			cur = array[i];  
			count++;// I missed this part!
		  }
		  else if( cur != array[i]){
			  count--;
		  }else{
			  count++;
		  }
	  }
   return cur;
  }
}
