import java.util.Stack;

public class FindNextAllGreaters {

	public static void main(String[] args){
		int[] arr = {3,2,5,7,1,9,4,6};
		find(arr);
	}


	public static void find(int[] arr){
		Stack<Integer> sk = new Stack<Integer>();

		for(int i=0; i<arr.length; i++){
			while(!sk.isEmpty() && arr[i] >= sk.peek()){
				Integer pop = sk.pop();
				System.out.println(pop+"-->"+arr[i]);
			}
			sk.push(arr[i]);
		}
		
		while(!sk.isEmpty()){
			System.out.println(sk.pop()+"--> -1");
		}

	}
}
