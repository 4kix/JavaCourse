package controller;

import controller.interfaces.MyController;
import model.TextModel;
import view.MyView;
import view.MyViewImpl;

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

	
	public void ok() {
		ControllerManager manager = ControllerManager.getInstance();
		MyView view = manager.getView();
		model.setText(view.getTextArea().getText());
		
		System.out.println("ok pressed. Saved text: "+ model.getText());
	}
	
}
