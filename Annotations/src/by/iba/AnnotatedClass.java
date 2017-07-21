package by.iba;

import by.iba.annotation.CouldBeInvoked;

public class AnnotatedClass {

	@CouldBeInvoked
	public void printMessage1() {
		System.out.println("This invoked medhod is annotated");
	}
	
	public void printMessage2() {
		System.out.println("This invoked medhod is not annotated");
	}
}