package controller.interfaces;

import controller.ControllerManager;
import model.TextModel;
import view.MyView;

public interface MyController {

	public TextModel getModel();

	public void setModel(TextModel model);
	
	public void ok();
}
