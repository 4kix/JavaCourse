package view;

import javax.swing.JButton;

public class MyButton extends JButton {
	private MyViewImpl view;
	
	public MyButton(String s, MyViewImpl v)
	{
		super(s);
		view = v;
	}
	
	public MyViewImpl getView() {
		return view;
	}
}