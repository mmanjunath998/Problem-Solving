
public class IslandProblem {

	public static void main(String[] args){
		int[][] arr = {
				{0,1,1,0},
				{1,0,1,1},
				{0,1,1,0},
				{0,1,1,0}
		};
		System.out.println(find(arr));
	}
	
	public static int find(int[][] arr){
		int count = 0;
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[0].length; j++){
				if(isValid(arr, i, j, visited)){
					visited[i][j] = true;
					count++;
					dfs(arr, i, j, visited);
				}
			}
		}
		return count;
	}
	
	static int[] rows = {1,-1, 0, 0, 1,-1, 1 ,-1};
	static int[] cols = {0, 0, 1,-1, 1,-1, -1 ,1};
	
	public static void dfs(int[][] arr, int row, int col, boolean[][] visited){
		for(int k=0; k<rows.length; k++){
			int c = col+cols[k];
			int r = row+rows[k];
			if(isValid(arr, r, c,visited)){
				visited[r][c] = true;
				dfs(arr, r, c, visited);
			}
		}
	}
	
	
	static boolean isValid(int[][] arr,int row, int col, boolean[][] visited){
		return  row>=0 && row < arr.length &&
				col>=0 && col<arr[0].length &&
				arr[row][col] == 0 && 
				!visited[row][col];
	}
}
