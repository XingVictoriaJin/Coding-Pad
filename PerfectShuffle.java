/* Take shuffling cards for example, you have 52 cards. 4 kinds: hearts, diamonds, clubs, shapes. 
Design one algorithm to get each card show up at equal chance.
*/
public class PerfectShuff{
  		public void shuffle(int[] array){
			if( array == null){
				return;
			}
			int n = array.length;// n items in the input array
//			for(int i = 0; i < n; i++){
//				Random random = new Random();
//				int temp = random.nextInt(i+1);
//				swap(temp, i, array);
//			}
			for(int i = array.length; i >=1;i--){
				int index = (int)(Math.random()*i);
				swap(i-1, index, array);
			}
		}
		
		public void swap(int left, int right, int[] array){
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
		}
}
