package view;

import javax.swing.JTextArea;

import model.TextModel;

/**An extension of JTextArea that is able to save it's content in model
 * 
 * @author Ilya Falko
 *
 */
public class MyTextArea extends JTextArea {

	TextModel model;

	public MyTextArea(int arg0, int arg1, TextModel model) {
		super(arg0, arg1);
		this.model = model;
	};
	
	/**
	 * saves text input in model
	 */
	public void saveToModel() {
		model.setText(this.getText()); //or super
	}
}
