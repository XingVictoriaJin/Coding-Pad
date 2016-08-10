/* How to do sampling for an unlimited data flow and when reading the nth element 
we are required to return one random numbe among all numbers read so far, such that
the probability of returning any element read so far is 1/n.
*/
public class ReservoirSampling {
	public int count;
	private Integer sample;
	public ReservoirSampling(int count, Integer sample){
		this.count = count;
		this.sample = sample;
	}
	
	public void read(int value){
		count++;
		int temp =(int)(Math.random()* count);
		if(temp == 0){
			sample = value;
		}
	}
	
	public Integer sample(){
		return sample;
	}
}
