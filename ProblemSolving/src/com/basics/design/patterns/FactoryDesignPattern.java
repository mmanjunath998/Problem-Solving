package com.basics.design.patterns;

interface OperatingSystem{
	
	void spec();
}

class Android implements OperatingSystem{
	
	@Override
	public void spec(){
		 System.out.println("Android OS");
	}
}

class IOS implements OperatingSystem{

	@Override
	public void spec() {
		System.out.println("IOS operating system");
		
	}
}

class Windows implements OperatingSystem{
	
	@Override
	public void spec(){
		System.out.println("Windows OS");
	}
}

class OSFactory{
	public OperatingSystem getInstance(String type){
		if(type.equals("Android")){
			return new Android();
		}else if(type.equals("IOS")){
			return new IOS();
		}else{
			return new Windows();
		}
	}
}

public class FactoryDesignPattern {

	public static void main(String[] args) {
		/*OperatingSystem os = new IOS();
		os.spec();*/
		
		OSFactory factory = new OSFactory();
		factory.getInstance("IOS").spec();
		factory.getInstance("Android").spec();
		factory.getInstance("windows").spec();
		
	}
}
