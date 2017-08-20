package controller.interfaces;

import model.TextModel;

public interface MyController {

	public TextModel getModel();

	public void setModel(TextModel model);
	
	public void ok();
}
