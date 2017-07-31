package by.iba.handler;

import by.iba.exception.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**ExceptionHandler handles incoming exceptions and logging additional information into log.txt file
 * 
 * @author Ilya Falko
 *
 */
public class ExceptionHandler implements ExceptionHandlerInterface {

	/**Handles incoming exceptions
	 * 
	 * @param e incoming exception
	 * @param comment custom comment
	 */
	@Override
	public void handle(ExceptionVisitor e, String comment) {		
		System.err.println(comment);
		e.visit();
		log(comment);
	}
	
	/**Logs time when exception has been caught and a comment into log.txt
	 *
	 * @param comment comment for logging
	 */
	private static void log(String comment) {
		Date date = new Date();
		FileWriter fw;
		try {
			fw = new FileWriter("log.txt", true);
			fw.write(comment + " " + date + "\n");
			fw.close();
		} catch (IOException e1) {
			System.out.println("Cannot write in file");
		}
		
	}

}
