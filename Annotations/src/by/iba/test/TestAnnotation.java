package by.iba.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import by.iba.AnnotatedClass;
import by.iba.annotation.CouldBeInvoked;

public class TestAnnotation {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		AnnotatedClass myClass = new AnnotatedClass();
		Class<?> ClassForTest = myClass.getClass();
		
		Method[] method = ClassForTest.getMethods();
		
		for(Method md: method){
		       if(md.isAnnotationPresent(CouldBeInvoked.class))
		       {
		    	   md.setAccessible(true);
		    	   md.invoke(myClass, null);
		       }
		}

	}

}
