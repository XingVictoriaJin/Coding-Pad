 /* find x element from a (sorted/unsorted) array such that their sum is equal to a target value
  * for unsorted one: sorted first O(n)
  * for sorted one: 
  * opitonA-->step1: hashset  step2: target-x search so it is O(n) for time/space
  * optionB-->two pointer: i and j... i++ ... j-- A[i] + A[j] compare to sum
  * additional: what about duplicate values there?
  * */
	public List<List<Integer>> twoSum(int[] array, int target){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int n = array.length;
		int i = 0;
		int j = n - 1;
		while( i <= n-1 && j > i){
			//ignore all the consecutive duplicate values when we want 
			// to determine the smaller element of the pair
			if(i > 0 && array[i] == array[i-1]){
				i++;
				continue;
			}
			if(array[i] + array[j] == target){
				List<Integer> pair = new ArrayList<Integer>();
				pair.add(array[i]);
				pair.add(array[j]);
				result.add(pair);
				i++;
				j--;
			}else if(array[i] + array[j] > target){
				j--;
			}
			else{
				i++;
			}
		}
		
		return result;
		
	}
	
	  public List<List<Integer>> twoSum(int[] array, int target){
	   List<List<Integer>> result = new ArrayList<List<Integer>>();
	   if(array == null){
		   return result;
	   }
	   // create a hashset to store array's each item
	   Set<Integer> set = new HashSet<Integer>();
	   for(int i = 0; i < array.length; i++){
		   if(i > 0 && array[i] == array[i-1]){
			   continue;
		   }
		   if(set.contains(target - array[i])){
			   List<Integer> pair = new ArrayList<Integer>();
			   pair.add(array[i]);
			   pair.add(target - array[i]);
			   result.add(pair);
		   }else{
			   set.add(array[i]);
		   }
		   
	   }
	   return result;
  }
