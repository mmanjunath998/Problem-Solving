
public class TestCall {
	
	private static TestCall test = getTestCall();
	
	
	public static void main(String[] args) {
		System.out.println(test);
	}

	public static TestCall getTestCall(){
		return new TestCall();
	}
}
