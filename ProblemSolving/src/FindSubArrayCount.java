import java.util.HashMap;
import java.util.Map;

public class FindSubArrayCount {

	public static void main(String[] args){
		int[] arr = {0,0,0,0,0,0,0,0,0,0};
		System.out.println(find(arr, 0));
	}

	public static int find(int[] arr, int k){

		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int sum = 0;
		for(int i=0; i<arr.length; i++){

			sum = sum + arr[i];
			if(sum == k){
				count++;
			}

			if(map.containsKey(sum-k)){
				count = count + map.get(sum-k);
			}

			Integer counter = map.get(sum);
			if(counter == null){
				map.put(sum, 1);
			}else{
				map.put(sum, counter+1);
			}
		}		

		return count;

	}
}
