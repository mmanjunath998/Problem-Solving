package com.basics.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllCombination {
	
	public static void main(String[] args) {
		System.out.println(findAllCombination(5));
	}

	public static List<List<Integer>> findAllCombination(int num) {

        List<List<Integer>>[] dp = new List[num];

        Arrays.fill(dp, new ArrayList<>());

        List<Integer> temp = Arrays.asList(1);
        List<List<Integer>> combinations = new ArrayList<>();
        combinations.add(temp);

        dp[1] = combinations;

        for (int i = 1; i <= num; i++) {
            for (int j = 2; j < dp.length; j++) {

                List<List<Integer>> prevCombinations = dp[j - 1];

                for (List<Integer> list : prevCombinations) {
                    list.add(i);
                }
                dp[j] = prevCombinations;
            }
        }
        return dp[dp.length - 1];
    }
	
	
}
