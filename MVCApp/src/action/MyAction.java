package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;

import controller.ControllerManager;
import controller.interfaces.MyController;
import view.MyButton;
import view.MyView;

public class MyAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		MyButton pressedButton = (MyButton) e.getSource();
		MyView view = pressedButton.getView();
		
		ControllerManager manager = ControllerManager.getInstance();
		MyController controller = manager.searchControllerByView(view);
		
		manager.invokeControllerMethod(controller, pressedButton.getActionCommand().toLowerCase());

	}

}
