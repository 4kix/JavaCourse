package by.iba.exception;

/**Same exception as NumberFormatException, but with implemented ExceptionVisitor interface
 * for realization of Visitor Pattern
 * 
 * @author Ilya Falko
 * @see NumberFormatException
 * @see ExceptionHandler 
 * @see #visit() 
 */
public class NumberFormatExceptionVisitor extends Exception implements ExceptionVisitor {

	public NumberFormatExceptionVisitor(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public NumberFormatExceptionVisitor(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * prints information about exception into console
	 */
	@Override
	public void visit() {
		System.err.println("NumberFormatException: " + super.getMessage());
	}

}
