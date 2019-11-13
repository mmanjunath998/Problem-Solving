import java.util.List;

public class WordCombination {


	public static void main(String[] args) {
		String s = "2112";
		System.out.println(calculatePossibleCombinations(s));

	}
	public static long calculatePossibleCombinations(String inputStr) {

		if(inputStr == null || inputStr.length() == 0) {
			return 0;
		}
		int n = inputStr.length();
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = inputStr.charAt(0) != '0' ? 1 : 0;
		for(int i = 2; i <= n; i++) {
			int first = Integer.valueOf(inputStr.substring(i-1, i));
			int second = Integer.valueOf(inputStr.substring(i-2, i));
			if(first >= 1 && first <= 9) {
				dp[i] += dp[i-1];  
			}
			if(second >= 10 && second <= 26) {
				dp[i] += dp[i-2];
			}
		}
		return dp[n];
	}


	public static int find(char[] values, int size){
		int[] dp = new int[size+1];
		dp[0] = 1;
		dp[1] = 1;
		if(values[0] == '0'){
			return 0;
		}

		for(int i=2; i<=size; i++){
			dp[i] = 0;

			if(values[i-1] > '0'){
				dp[i] = dp[i-1];
			}

			if(values[i-2] == '1' ||
					values[i-2] == '2' &&
					values[i-2] < '7'){
				dp[i] = dp[i]+dp[i-2];
			}
		}
		return dp[size];
	}


}

