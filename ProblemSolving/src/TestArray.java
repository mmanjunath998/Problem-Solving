public class TestArray {
public static void main(String[] args) {
	String[] s ={"234", "999", "999"};
	System.out.println(find(s));
}
	
	public static String find(String[] strArr){
		
		int row = strArr.length;
		int col = strArr[0].length();
		int[][] arr = new int[row][col];
		int i =0;
		int j = 0;
				
		for(String s : strArr){
			for(int k=0; k<s.length(); k++){
				arr[i][j]= Integer.parseInt(String.valueOf(s.charAt(k)));
				j++;
			}
			i++;
			j=0;
		}
	
		
		return find(arr);
	}
	
	public static String find(int[][] arr){
		int res = 0;
		int maxRes = 0;
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[0].length; j++){
				
				if(isValid(arr, i, j+1) && isValid(arr, i+1, j)){
					 res = arr[i][j] + arr[i][j+1] + arr[i+1][j];
					 String resValue = String.valueOf(res);
					 
					 if(resValue.length() == 1){
						 if(res == arr.length || res == arr[0].length){
							 maxRes = Math.max(maxRes, res);
						 }
					 }else if(resValue.length() > 1){
						 String firstDigit = String.valueOf(resValue.charAt(0));
						 String secondDigit = String.valueOf(resValue.charAt(1));
						 if(Integer.parseInt(firstDigit)>=0 && Integer.parseInt(firstDigit)<arr.length &&
								 Integer.parseInt(secondDigit)>=0 && Integer.parseInt(secondDigit)<arr[0].length){
							 if(res == arr.length || res == arr[0].length){
								 maxRes = Math.max(maxRes, res);
							 }
						 }
					 }
				}
			}
		}
		
		return String.valueOf(res);
	}

	private static boolean isValid(int[][] arr, int i, int j) {
		return  i>=0 && i<arr.length &&
				j>=0 && j<arr[0].length;
	}
}

