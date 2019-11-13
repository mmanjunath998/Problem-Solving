package com.basics.dp;

class Pair{
	int a;
	int b;
	public Pair(int a, int b){
		this.a = a;
		this.b = b;
	}
}
public class LongestPariChain {
	
	public static void main(String[] args) {
		Pair[] a = {
				new Pair(5, 10),
				new Pair(12, 25),
				new Pair(30, 60),
				new Pair(7, 20),
				new Pair(12, 28),
				new Pair(6, 36),
				new Pair(40, 50)
		};
		System.out.println(find(a));
	}

	public static int find(Pair[] pairs){
		int n = pairs.length;
		int[] T = new int[n];
		int[] seq = new int[n];
		int res = 0, start = 0;

		for(int i=0; i<n; i++){
			T[i] = 1;
			seq[i] = -1;
		}

		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				if(pairs[i].a >= pairs[j].b && T[j]+1 > T[i]){
					T[i] = T[j]+1;
					seq[i] = j;
					res = res < T[i] ? T[i] : res;
					start = i;
				}
			}
		}
		give(pairs, seq, start);
		return res;
	}

	public static Pair give(Pair[] a, int[] seq, int s){
		if(s < 0){
			return null;
		}
		else{
			Pair p = a[s];
			give(a, seq, seq[s]);
			System.out.print("("+p.a+","+p.b+") ");
			return p;
		}
	}
	
}
