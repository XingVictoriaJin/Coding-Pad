
    
    public long power(int a, int b){
        // assume 0^x, return 0
       if( a == 0 ){
           return 0;
        }
       if( b == 0 ){
           return 1;
       }
       if( b < 0 ){
           return (long)(1/(double)powerHelper(a, -b)); 
       }

       return powerHelper(a, b);
    }
    public long powerHelper(int a, int b){
       long result;
       long temp = power(a, b/2);
       if( b % 2 == 0){
           result = temp * temp; 
       }else{
           result = temp * temp * a;
       }
       return result;
    }
