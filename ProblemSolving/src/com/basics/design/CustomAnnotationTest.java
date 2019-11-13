package com.basics.design;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation{

	int value() default 100;
	String value2() default "manju";
}

class Hello{

	@MyAnnotation(value2 = "mahendra", value = 10)
	void getMyName(){
		System.out.println("annotation called");
	}
}


public class CustomAnnotationTest {



	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Hello h = new Hello();
		Method m = h.getClass().getMethod("getMyName", Hello.class);
		MyAnnotation annotation = m.getAnnotation(MyAnnotation.class);
		System.out.println(annotation.value2());
		System.out.println(annotation.value());
	}
}
