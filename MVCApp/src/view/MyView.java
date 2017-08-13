package view;

import javax.swing.JTextArea;

import model.TextModel;

public interface MyView {
	public JTextArea getTextArea();
	public TextModel getModel();
	public void launchFrame();
}
