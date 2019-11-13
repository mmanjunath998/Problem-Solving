package com.basics.array;
class RevreseIntLC {
	
	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}
    public static int reverse(int x) {
        
        boolean isNegetive = x < 0 ? true : false;
        if(isNegetive){

            x = x * -1;
        }
        
        int res = 0;
        while(x > 0){
            if( (long)res*10 > Integer.MAX_VALUE || (long)res*10 < Integer.MIN_VALUE){
              return 0;
             }
            res = res*10 + x%10;
            x = x/10;
        }
        return isNegetive ? - res :  res;
        
    }
}