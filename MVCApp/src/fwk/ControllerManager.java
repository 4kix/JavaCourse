package fwk;

import java.lang.reflect.InvocationTargetException;

import controller.interfaces.MyController;
import model.TextModel;
import view.MyView;

/**Manages all controllers in this application
 * 
 * @author Ilya Falko
 *
 */
public class ControllerManager {

	private static ControllerManager instance;
	
	private AbstractFactory factory;
	private TextModel model;	
	private MyView view;
	
	private ControllerManager() {
		factory = MyControllerFactoryProxy.getInstance();
	}
	
	public static ControllerManager getInstance() {
		if (instance == null) {
			instance = new ControllerManager();
		}
		return instance;
	}
	
	
	public TextModel getModel() {
		return model;
	}

	public void setModel(TextModel model) {
		this.model = model;
	}
	
	public MyView getView() {
		return view;
	}

	public void setView(MyView view) {
		this.view = view;
	}

	/**searches for view's controller by it's name
	 * 
	 * @param viewInstance view to find it's controller
	 * @return view's controller
	 */
	public MyController searchControllerByView(MyView viewInstance) {
		
		view = viewInstance;
		model = view.getModel();
		
		String viewName = view.getClass().getName();
		
		MyController controller = factory.getByView(viewName);
		controller.setModel(model);	
		return controller;
		
	}
	
	/**invokes method in controller, specified in method arguments, by it's name, also specified in arguments
	 * 
	 * @param controller controller
	 * @param methodName name of the invoking method
	 */
	public void invokeControllerMethod(MyController controller, String methodName) {
		//getting controller class
		Class<?> cl = controller.getClass();
		try {
			//invoking method
			cl.getMethod(methodName, null).invoke(controller, null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e1) {
			e1.printStackTrace();
		}
	}
}