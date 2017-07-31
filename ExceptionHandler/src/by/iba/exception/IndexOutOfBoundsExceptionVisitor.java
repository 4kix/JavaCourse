package by.iba.exception;

/**Same exception as IndexOutOfBoundsException, but with implemented ExceptionVisitor interface
 * for realization of Visitor Pattern
 * 
 * @author Ilya Falko
 * @see IndexOutOfBoundsException
 * @see ExceptionHandler 
 * @see #visit() 
 */
public class IndexOutOfBoundsExceptionVisitor extends Exception implements ExceptionVisitor {

	public IndexOutOfBoundsExceptionVisitor(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public IndexOutOfBoundsExceptionVisitor(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * prints information about exception into console
	 */
	@Override
	public void visit() {
		System.err.println("IndexOutOfBoundsException: " + super.getMessage());
	}

}
