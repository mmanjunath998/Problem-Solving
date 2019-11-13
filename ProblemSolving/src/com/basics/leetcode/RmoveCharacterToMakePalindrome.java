package com.basics.leetcode;

public class RmoveCharacterToMakePalindrome {
	


	public static void main(String[] args) {
		String s = "aaab";
		System.out.println(palindromeIndex(s));
	}

	static int palindromeIndex(String s) {

        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                if(end >0 && s.charAt(start) == s.charAt(end-1)){
                    return end;
                }
                if(start+1 < s.length() && s.charAt(start+1) == s.charAt(end)){
                    return start;
                }
            }
            start++;
            end--;
        }

    if(end + 1 == s.length()){
        return -1;
    }

    return -1;
    }
}
