
public class MaxIntegerAvg {

	public static void main(String[] args) {
		int a = Integer.MAX_VALUE,b = Integer.MAX_VALUE;
		
		System.out.println(find(a, b));
		
	}
	public static int find(int a, int b){
		
		int r1 = a/2;
		int r2 = b/2;
		return (r1+r2);
	}
}
