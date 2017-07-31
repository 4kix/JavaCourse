package by.iba.exception;

/**Same exception as ArithmeticException, but with implemented ExceptionVisitor interface
 * for realization of Visitor Pattern
 * 
 * @author Ilya Falko
 * @see ArithmeticException
 * @see ExceptionHandler 
 * @see #visit() 
 */
public class ArithmeticExceptionVisitor extends Exception implements ExceptionVisitor {
	
	public ArithmeticExceptionVisitor(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public ArithmeticExceptionVisitor(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * prints information about exception into console
	 */
	@Override
	public void visit() {
		System.err.println("ArithmeticException: " + super.getMessage());

	}

}
