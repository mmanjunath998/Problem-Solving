package com.basics.design.patterns;

//1: Lazy initialization/classic method
class Logger{
	private static Logger logger;

	public static Logger getInstance(){
		if(logger == null){
			logger = new Logger();
		}

		return logger;
	}
	private Logger(){

	}
}

//2 Eager initialization
class Logger2{
	private static Logger2 logger  = new Logger2();

	public static Logger2 getInstance(){
		return logger;
	}
	private Logger2(){

	}
}

//3: Thread safe

class Logger3{
	private static Logger3 logger;

	private Logger3(){
		
	}
	
	public static synchronized Logger3 getInstance(){

		if(logger == null){
			logger = new Logger3();
		}

		return logger;
	}
}

//double check
class Logger4{
	private static Logger4 logger;
	
	private Logger4(){
		
	}
	
	public static Logger4 getInstance(){
		
		if(logger == null){
			
			synchronized(Logger4.class){
				if(logger == null){
					logger = new Logger4();
				}
			}
		}
		
		return logger;
	}
}


public class SingletonDesignPattern {
	public static void main(String[] args) {
		Logger lazy = Logger.getInstance();
		Logger lazy2 = Logger.getInstance();
		System.out.println(lazy);
		System.out.println(lazy2);
		
		Logger2 eager = Logger2.getInstance();
		Logger2 eager2 = Logger2.getInstance();
		System.out.println(eager);
		System.out.println(eager2);
		
		Logger3 tsafe = Logger3.getInstance();
		Logger3 tsafe2 = Logger3.getInstance();
		System.out.println(tsafe);
		System.out.println(tsafe2);
		
		Logger4 dcheck = Logger4.getInstance();
		Logger4 dcheck2 = Logger4.getInstance();
		System.out.println(dcheck);
		System.out.println(dcheck2);
		
	}
}
