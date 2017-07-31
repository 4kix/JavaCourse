package by.iba.handler;

import by.iba.exception.ExceptionVisitor;

public interface ExceptionHandlerInterface {

	public void handle(ExceptionVisitor e, String comment);
}
