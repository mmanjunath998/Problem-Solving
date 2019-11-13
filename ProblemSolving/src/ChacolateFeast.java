
public class ChacolateFeast {
	
	public static void main(String[] args) {
		System.out.println(chacolateFeast(15 ,3 ,2));
		System.out.println(lognSolution(15, 3, 2));
	}

	public static int chacolateFeast(int n, int c, int m){
		int count = 0;
		int z = 0;
		int total = n/c;
		if(total < m){
			return total;
		}
		while(total > 1){
			System.out.println("couting : "+z++);
			int wraffer = total/m;
			int remaining = total%m;
			count = count + wraffer * m;
			total = wraffer + remaining;
		}
		
		return count+total;
	}
	
	public static int lognSolution(int n, int c, int m){
		int total = 0;
		total = n/c;
		int z = 0;
		int wraffer = total;
		while(wraffer >= m){
			System.out.println("couting : "+z++);
			total = total + wraffer/m;
			wraffer = wraffer/m + wraffer%m;
		}
		return total;
	}
}
