public static List<List<Integer>> nqueen(int n){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if( n == 0 ){
			return result;
		}
		// use curr to keep track each row which column to put queen
	    int[] curr = new int[n];
	    // create three boolean arrays, one for same column mark, 2nd for diagonal, 3rd to revdiagonal
	    boolean[] usedcols = new  boolean[n];
	    boolean[] useddiagonals = new boolean[2*n-1];
	    boolean[] usedrevdiagoals = new boolean[2*n-1];
	    nqueenHelper(n, 0, curr, result, usedcols, useddiagonals, usedrevdiagoals);
		return result;
	}
	
	public static void nqueenHelper(int n, int row, int[] curr, List<List<Integer>> result, boolean[] usedcols, boolean[] useddiagonals, boolean[] usedrevdiagoals ){
		if( n == row){
			for(int i = 0; i < curr.length; i++){
				System.out.print(curr[i]);
			}
			System.out.println("");
			result.add(asList(curr));
			return;
		}
		
		for(int i = 0; i < n; i++){
			if(valid(n, row, i, usedcols, useddiagonals, usedrevdiagoals)){
				curr[row] = i;
				mark(n, row, i, usedcols, useddiagonals, usedrevdiagoals );
				nqueenHelper(n, row+1,  curr, result, usedcols, useddiagonals, usedrevdiagoals);
				unmark(n, row, i, usedcols, useddiagonals, usedrevdiagoals );
			}
		}
		
	}
	
	public static boolean valid(int n, int row, int column, boolean[] usedcols, boolean[] useddiagonals, boolean[] usedrevdiagoals ){
		return !usedcols[column] && !useddiagonals[column + row] && !usedrevdiagoals[column - row + n-1 ];
	}
	
	public static void mark(int n, int row, int column,  boolean[] usedcols, boolean[] useddiagonals, boolean[] usedrevdiagoals){
		usedcols[column] = true;
		useddiagonals[row + column] = true;
		usedrevdiagoals[column - row + n - 1] = true;
	}
	
	public static void unmark(int n, int row, int column, boolean[] usedcols, boolean[] useddiagonals, boolean[] usedrevdiagoals){
		usedcols[column] = false;
		useddiagonals[row + column] = false;
		usedrevdiagoals[column - row + n - 1] = false;
	}
	
	public static List<Integer> asList(int[] array){
		List<Integer> result = new ArrayList<Integer>();
		for(int item: array){
			result.add(item);
		}
		return result;
	}
