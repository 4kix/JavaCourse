package view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import action.MyAction;
import model.TextModel;

public class MyViewImpl implements MyView {

	private JTextArea textArea;
	private MyButton okBtn;
	private TextModel model;
	
	public MyViewImpl(TextModel m) {
		textArea = new JTextArea(3,10);
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
