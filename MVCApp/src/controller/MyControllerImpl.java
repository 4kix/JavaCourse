package controller;

import controller.interfaces.MyController;
import model.TextModel;
import view.MyView;
import view.MyViewImpl;

/**An implementation of MyController
 * 
 * @author Ilya Falko
 *
 */
public class MyControllerImpl implements MyController {

	private TextModel model;

	public MyControllerImpl() {
		super();
	}
	public MyControllerImpl(TextModel m) {
		super();
		this.model = m;
	}
	
	public TextModel getModel() {
		return model;
	}

	public void setModel(TextModel model) {
		this.model = model;
	}

	/**
	 * method, related to the "OK" button
	 */
	public void ok() {
		//printing of the confirmation into console
		System.out.println("ok pressed. Saved text: "+ model.getText());
	}
	
}
