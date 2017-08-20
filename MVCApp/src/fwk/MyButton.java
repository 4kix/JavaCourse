package fwk;

import javax.swing.JButton;

import view.MyViewImpl;

/**An Implementation of JButton that knows it's view
 * 
 * @author Ilya Falko
 *
 */
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