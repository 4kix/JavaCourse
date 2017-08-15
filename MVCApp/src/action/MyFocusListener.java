package action;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import view.MyTextArea;

public class MyFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * this method is invoking when text area becomes out of focus
	 */
	@Override
	public void focusLost(FocusEvent e) {

		MyTextArea textArea = (MyTextArea) e.getSource();
		textArea.saveToModel();
		textArea.setText("text saved");
		
	}

}
