package view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import action.MyAction;
import action.MyFocusListener;
import model.TextModel;

public class MyViewImpl implements MyView {

	private MyTextArea textArea;
	private MyButton okBtn;
	private TextModel model;
	
	public MyViewImpl(TextModel m) {
		textArea = new MyTextArea(3,10, m);
		textArea.addFocusListener(new MyFocusListener());
		okBtn = new MyButton("OK", this);
		okBtn.addActionListener(new MyAction());
		model = m;
	}
	
	/**
	 * launches the frame
	 */
	public void launchFrame() {
		JFrame frame = new JFrame("MyApp");
		frame.setLayout(new BorderLayout());
		frame.add(textArea, BorderLayout.NORTH);
		frame.add(okBtn, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public JTextArea getTextArea() {
		return textArea;
		
	}
	
	@Override
	public TextModel getModel() {
		return model;
	}
	
	
}
