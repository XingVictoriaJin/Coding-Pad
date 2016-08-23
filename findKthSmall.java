/*how to find the kth smallest from two sorted arrays*/
public class KthSmall {
   public int findKthSmall(int[] a, int a_left, int[] b, int b_left, int k ){
	   /*a[0]......a[k/2-1]....
	    *b[0]......b[k/2-1]....
	    **/
	   // if array a has 0 left
	  if ( a_left >= a.length ){
		  return b[b_left + k - 1];
	  }
	  // if array b has 0 left
	  if( b_left >= b.length){
		  return a[a_left + k - 1];
	  }
	  if(k == 1){
		  return a[a_left] < b[b_left] ? a[a_left] : b[b_left];
	  }
	  
	  // try to cut to k/2 size
	  int left = (a_left + k/2 - 1 < a.length)?  a[a_left + k/2 - 1] : Integer.MAX_VALUE;
	  int right = (b_left + k/2 - 1 < b.length)?  b[b_left + k/2 - 1] : Integer.MAX_VALUE;
	  
	 if(left < right){
		 return findKthSmall(a, a_left + k/2, b, b_left, k - k/2 );
     }else{
    	 return findKthSmall(a, a_left, b, b_left + k/2 , k - k/2 );
     }
			  
   }
}
