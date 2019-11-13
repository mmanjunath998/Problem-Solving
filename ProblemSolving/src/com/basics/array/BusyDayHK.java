package com.basics.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class BusyDayHK {
	
	public static void main(String[] args) {
		List<List<String>> list = new ArrayList<>();
		String[] s1 = {"2018-01-01","2018-01-03"};
		String[] s2 = {"2018-01-03","2018-01-03"};
		String[] s3 = {"2018-01-01","2018-01-02"};
		String[] s4 = {"2018-01-02","2018-01-02"};
		String[] s5 = {"2018-01-01","2018-01-05"};
		
		list.add(Arrays.asList(s1));
		list.add(Arrays.asList(s2));
		list.add(Arrays.asList(s3));
		list.add(Arrays.asList(s4));
		list.add(Arrays.asList(s5));
		System.out.println(solve(list));
		System.out.println(solve2(list));
	}

	public static String solve(List<List<String>> reservations){
		Map<String, Integer> map = new TreeMap<>();
		for(List<String> dates : reservations){
			for(String date : dates){
				if(map.containsKey(date)){
					map.put(date, map.get(date)+1);
				}else{
					map.put(date, 1);
				}
			}
		}

		String res = "";
		int count = 0;
		for(Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > count){
                count = entry.getValue();
                res = entry.getKey();
            }
        }

		return res;
	}
	
static String solve2(List<List<String>> reservations) {
        
        List<String> src = new ArrayList<String>();
        List<String> dest = new ArrayList<String>();
        
        for(List<String> list : reservations){
                src.add(list.get(0));
                dest.add(list.get(1));
        }
        Collections.sort(src);
        Collections.sort(dest);
        int i=0, j=0, count = 0, max = 0; 
        String res = "";
        int n = src.size();
        while(i<n && j<n){

        long l1 = Long.parseLong(src.get(i).replaceAll("-",""));
        long l2 = Long.parseLong(dest.get(j).replaceAll("-","")); 
            if(l1 < l2){
                i++;
                count++;
                if(count > max){
                    max = count;
                    res = src.get(i);
                }
            }else{

                j++;
                count--;
            }
        }
        return res;
        

    }
}
