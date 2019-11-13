package com.basics.random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args){
		String s = "2018-01-03";
		System.out.println(s.replaceAll("-", ""));
		
		TreeMap<String, Integer> map = new TreeMap<>();
		map.put("2018-01-03", 3);
		map.put("2018-01-02", 2);
		map.put("2018-01-01", 4);
		map.put("2018-01-06",5);
		map.put("2018-01-04",5);
		System.out.println(map);
		
		List<String> list = new ArrayList<>();
		list.add("2018-01-03");
		list.add("2018-01-02");
		list.add("2018-01-01");
		list.add("2018-01-05");
		list.add("2018-01-06");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		String s1 = "2018-01-06";
		String s2 = "2018-01-02";
		System.out.println(s1.compareTo(s2));
		
		
	}
	
	
static String solve(List<List<String>> reservations) {
        
        List<String> src = new ArrayList<String>();
        List<String> dest = new ArrayList<String>();
        
        for(List<String> list : reservations){
                src.add(list.get(0));
                dest.add(list.get(1));
        }
        
        int i=0, j=0, count = 0, max = 0; 
        String res = "";
        int n = src.size();
        while(i<n && j<n){

        long l1 = Long.parseLong(src.get(i).replaceAll("-",""));
        long l2 = Long.parseLong(dest.get(j).replaceAll("-","")); 
            if(l1 > l2){
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
