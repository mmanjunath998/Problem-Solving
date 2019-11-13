package com.basics.random;

public class CountValley {


	public static int find(int n , String s){
		int res = 0;
		int count = 0;
		boolean movingDown = s.charAt(0) == 'D' ? true: false;
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) == 'U'){
				count++;
			}else if(s.charAt(i) == 'D'){
				count--;
			}
			
			if(count == 0 && movingDown){ 
				res++;
			}
			
			if(!movingDown && (count == 0 && i < s.length()-1 && s.charAt(i+1) == 'D')){
				movingDown = true;
			}else if(movingDown && (count == 0 && i < s.length()-1 && s.charAt(i+1) == 'U')){
				movingDown = false;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println("start");
		String s = "DDUUDDUDUUUD";
		System.out.println(find(s.length(), s));
	}
}
