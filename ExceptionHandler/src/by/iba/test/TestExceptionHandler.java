package by.iba.test;

import by.iba.handler.ExceptionHandler;
import by.iba.handler.ExceptionHandlerInterface;
import by.iba.exception.*;

public class TestExceptionHandler {

	public static void main(String[] args) {
		ExceptionHandlerInterface handler = new ExceptionHandler();
		try {
			System.out.println(5/0);
		} catch (ArithmeticException e) {
			handler.handle(new ArithmeticExceptionVisitor(e.getMessage()), "Dividing error");		
		}
		
		try {
			int[] array = new int[5];
			array[6] = 10;
		} catch (IndexOutOfBoundsException e) {
			handler.handle(new IndexOutOfBoundsExceptionVisitor(e.getMessage()), "Index out of bounds");
		}
		
		try {
			String s = "hello";
			int num = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			handler.handle(new NumberFormatExceptionVisitor(e.getMessage()), "Cannot parse string");
		}
	}

}
