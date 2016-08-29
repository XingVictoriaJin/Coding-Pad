/*
Given three strings A, B and C. Determine if C can be created by merging A and B in a way that maintains the relative order of the characters in A and B.

Assumptions

none of A, B, C is null
Examples

C = "abcde", A = "acd", B = "be", return true
C = "abcde", A = "adc", B = "be", return false
*/
public class Solution {
	  public boolean canMerge(String a, String b, String c) {
		    // assume a and b dont have common characters. 
		    // assume a , b and c are not null, and not empty
		   char[] strA = a.toCharArray();
		   char[] strB = b.toCharArray();
		   char[] strC = c.toCharArray();
		   int i = 0;
		   int j = 0;
		   int k = 0;
		   while(k < c.length()){
			   if(i < a.length() && strC[k] == strA[i]){
				   k++;
				   i++;
			   }else if(j < b.length() && strC[k] == strB[j]){
				   k++;
				   j++;
			   }else{
				   return false;
			   }
		   }
		  
		    return true;
		  }
}

