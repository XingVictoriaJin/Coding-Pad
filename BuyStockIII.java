public class BuyStock {
	 public int maxProfit(int prices[], int K) {
		 int result = 0;
		 /* use m[i][j] to represent i transactions till day j
		  * basecase:m[0][j] = 0, j from 0 to prices.length
		  * 		 m[i][0] = 0, day0 cannot sell, hence no profit at all
		  * induction rule:
		  *  m[i][j] = Math.max ( m[i][j-1] ,  no transaction on day j
		  *  price[j] - price[m] + m[i-1][m], m is from 0 to j-1
		  * 
		  * */
		 int len = prices.length;
		 int[][] m = new int[K+1][len];
		 for(int j = 0 ; j < len; j++){
			 m[0][j] = 0;
		 }
		 for(int i = 0; i < K + 1; i++){
			 m[i][0] = 0;
		 }
		 

		 int i, j, n;
		 for( i = 1; i <= K; i++){
			 for( j = 1; j < len; j++){
				 int maxValue = 0;
				 for( n = 0; n <= j-1; n++){
					 maxValue = Math.max(maxValue, prices[j] - prices[n] + m[i-1][n] );
					  
				 }
				 m[i][j] = Math.max(m[i][j-1],maxValue);
				 //System.out.println("TRAC:"+i+ "DAY:"+j+" value:"+ m[i][j]);
			 }
		 }
		 
		 return m[K][len-1];
	 }
	 
}
