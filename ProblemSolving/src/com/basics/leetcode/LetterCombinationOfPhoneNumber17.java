package com.basics.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber17 {
	
	public static void main(String[] args) {
		find("2347");
	}

	public static List<String> find(String digits){
		List<String> result = new ArrayList<>();
		Map<Character, char[]> map = new HashMap<>();
		map.put('2', new char[] {'a','b','c'});
		map.put('3', new char[] {'d','e','f'});
		map.put('4', new char[] {'g','h','i'});
		map.put('5', new char[] {'j','k','l'});
		map.put('6', new char[] {'m','n','o'});
		map.put('7', new char[] {'p','q','r','s'});
		map.put('8', new char[] {'t','u','v'});
		map.put('9', new char[] {'w','x','y','z'});

		StringBuilder choosen = new StringBuilder();
		letters(digits, 0, map, choosen, result);
		System.out.println(result);
		return result;
	}

	public static void letters(String digits, int start, Map<Character, char[]> map, StringBuilder choosen, List<String> result){

		if(start == digits.length()){
			result.add(choosen.toString());
			return;
		}

		for(char c : map.get(digits.charAt(start))){
			choosen.append(c);
			letters(digits, start+1, map, choosen, result);
			choosen.deleteCharAt(choosen.length()-1);
		}
	}


}
