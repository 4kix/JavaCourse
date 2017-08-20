package test;

import model.TextModel;
import view.MyViewImpl;

/**Main class
 * 
 * @author Ilya Falko
 *
 */
public class TestApp {

	public static void main(String[] args) {

		TextModel model = new TextModel();
		MyViewImpl view = new MyViewImpl(model);
		
		view.launchFrame();

	}

}
