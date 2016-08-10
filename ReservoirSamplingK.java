
public class ReservoirSamplingK {
     private int count;
     private List<Integer> sample;
     private int k;
     public ReservoirSamplingK(int count, List<Integer> sample, int k){
    	 this.count = count;
    	 this.sample = sample;
    	 this.k = k;
     }
     
     public void read(int value){
    	 count++;
    	 // for first k element, just add them in
    	 if(count <= k){
    		 sample.add(value);
    	 }else{
    		 int index = (int)(Math.random() * count);
    		 if(index < k){
    			 sample.set(index, value);
    		 }
    		 
    	 }
     }
}
