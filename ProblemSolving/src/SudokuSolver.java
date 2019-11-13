
public class SudokuSolver {
	
	public static void main(String[] args){
		int[][] arr = new int[][] 
			    { 
			            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
			            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
			            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
			            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
			            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
			            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
			            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
			            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
			            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
			    }; 
			    print(arr);
			   System.out.println(solve(arr));
			   print(arr);
		
	}

	public static void print(int[][] arr){
		for(int[] ar : arr){
			for(int a : ar){
				System.out.print(a+" ");
			}
			System.out.println(" ");
		}
		
		System.out.println("....................");
	}
	
	public static boolean solve(int[][] arr){
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[0].length; j++){
				if(arr[i][j] == 0){
					for(int k=1; k<=9; k++){
						if(isOk(arr, i, j, k)){
							arr[i][j] = k;
							if(solve(arr)){
								return true;
							}else{
								arr[i][j] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}


	public static boolean isOk(int[][] arr, int row, int col, int num){

		return isRowOk(arr, row, num)&&
				isColOk(arr, col, num) &&
				isBoxOk(arr, row-row%3, col-col%3,num);
	}

	public static boolean isRowOk(int[][] arr, int row, int num){
		for(int i=0; i<arr[0].length; i++){
			if(arr[row][i] == num){
				return false;
			}
		}
		return true;
	}

	static boolean isColOk(int[][] arr, int col, int num){
		for(int i=0; i<arr.length; i++){
			if(arr[i][col] == num){
				return false;
			}
		}
		return true;
	}

	static boolean isBoxOk(int[][] arr, int row, int col, int num){

		for(int i=0; i<3; i++){
			if(arr[i+row][i+col] == num){
				return false;
			}
		}
		return true;
	}
}
