import java.util.ArrayList;

public class LongestPalindromicSubstring {
	
	public static void main(String[] args) {
		String str = "GeekskeeforGeek";
		find(str);
	}

	public static void find(String str){
		ArrayList<Integer> list = new ArrayList<>();
		int maxLength = 0;
		int start = 0;
		int n = str.length();
		boolean[][] T = new boolean[n][n];

		for(int i=0; i<str.length(); i++){
			T[i][i] = true;
		}

		for(int i=0; i<str.length()-1; i++){
			if(str.charAt(i) == str.charAt(i+1)){
				T[i][i+1] = true;
				maxLength = 2;
				start = i;
			}
		}

		for(int k=3; k<=n; k++){

			for(int i=0; i<n-k+1; i++){

				int j  = k+i-1;

				if(str.charAt(i) == str.charAt(j) && T[i+1][j-1]){
					T[i][j] = true;
					if(k > maxLength){
						maxLength = k;
						start = i;
					}
				}
			}
		}
		
		System.out.println("max palindromic substring length "+maxLength);
		System.out.println("substring "+str.substring(start, start+maxLength));

	}


}
