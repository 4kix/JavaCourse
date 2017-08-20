package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.interfaces.MyController;
import fwk.ControllerManager;
import fwk.MyButton;
import view.MyView;

/**Action listener for MyView implementations
 * 
 * @author Ilya Falko
 *
 */
public class MyAction implements ActionListener {

	@Override
	/**
	 * gets name of the view where action button was pressed, asks ControllerManager to find view's controller
	 * and to invoke controller's method, related to this button
	 */
	public void actionPerformed(ActionEvent e) {

		MyButton pressedButton = (MyButton) e.getSource();
		//getting the view
		MyView view = pressedButton.getView();
		
		ControllerManager manager = ControllerManager.getInstance();
		//requesting ControllerManager to find view's controller 
		MyController controller = manager.searchControllerByView(view);
		//invoking a method, related to pressed button by it's name
		manager.invokeControllerMethod(controller, pressedButton.getActionCommand().toLowerCase());

	}

}
