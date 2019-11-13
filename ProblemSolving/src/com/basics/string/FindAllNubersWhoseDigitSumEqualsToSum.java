package com.basics.string;

public class FindAllNubersWhoseDigitSumEqualsToSum {

	public static void main(String[] args) {
		//find("", 15, 10);
		System.out.println(".......................");
		String[][] T = new String[100][500];
		find("", 15, 10, T);
		
	}
	
	public static String find(String res, int n, int sum, String[][] T){
			
		if(sum < 0 || n < 0){
			return null;
		}
		if(n>0 && sum>=0){
			//if(T[n][sum] != null){
				//return T[n][sum];
			//}
			
			char d = '0';
			if(res == ""){
				d = '1';
			}
			
			for(; d<='9'; d++){
				if(sum > 0 && n > 0){
					find(res+d, n-1, sum-(d-'0'), T);	
				}
				
			}
		}else if( n == 0 && sum==0){
			System.out.println(res);
			T[n][sum] = res;
		}
		T[n][sum] = res;
		return "";
	}
	public static void find(String res, int n, int sum){
		if(n > 0 && sum >= 0){
			char d = '0';
			if(res == ""){
				d = '1';
			}
			
			for(; d<='9'; d++){
				find(res+d, n-1, sum-(d-'0'));
			}
		}else if(n == 0 && sum == 0){
			System.out.println(res);
		}
	}
}
