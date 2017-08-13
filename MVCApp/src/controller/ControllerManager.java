package controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import controller.interfaces.AbstractFactory;
import controller.interfaces.MyController;
import model.TextModel;
import view.MyView;

public class ControllerManager {

	private static ControllerManager instance;
	
	private AbstractFactory factory;
	private TextModel model;	
	private MyView view;
	private HashMap<String, MyController> cache = new HashMap<String, MyController>();
	
	private ControllerManager() {
		factory = new MyControllerFactory();
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

	public MyController searchControllerByView(MyView viewInstance) {
		
		view = viewInstance;
		model = view.getModel();
		
		String viewName = view.getClass().getName();
		
		MyController controller = null;
		if(!cache.containsKey(viewName)) {
			controller = factory.getByView(viewName);
			cache.put(viewName, controller);
		} else {
			controller = cache.get(viewName);
		}
		controller.setModel(model);	
		return controller;
		
	}
	
	public void invokeControllerMethod(MyController controller, String methodName) {
		
		Class<?> cl = controller.getClass();
		try {
			cl.getMethod(methodName, null).invoke(controller, null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e1) {
			e1.printStackTrace();
		}
	}
}