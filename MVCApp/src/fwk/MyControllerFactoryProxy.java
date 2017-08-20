package fwk;


import java.util.HashMap;

import controller.interfaces.MyController;

/**Proxy class for MyControllerFactory.
 * Also implements Singleton.
 * @author Ilya Falko
 *
 */
public class MyControllerFactoryProxy implements AbstractFactory {	
	
	private HashMap<String, MyController> cache = new HashMap<String, MyController>();
	private MyControllerFactory factory;

	
	//---------Constructor-----------
	private MyControllerFactoryProxy() {
		
	}
	//------Singleton Holder---------

	private static class SingletonHolder {
		public static final MyControllerFactoryProxy instance = new MyControllerFactoryProxy();
	}

	// ---------Methods------------

	/**
	 * 
	 * @return instance returns an instance of MyControllerFactory
	 */
	public static MyControllerFactoryProxy getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * @param viewName name of the view to find it's controller
	 */
	@Override
	public MyController getByView(String viewName) {
		
		MyController controller = null;
		//checking cache for the loaded controller
		controller = checkCache(viewName);
		//if no controller was found in cache, then asking factory for it and put it in cache
		if(controller == null) {	
			factory = MyControllerFactory.getInstance();
			controller =  factory.getByView(viewName);
			cache.put(viewName, controller);
			}
		return controller;
	}
	
	/**
	 * 
	 * @param key key for finding controller in cache
	 * @return
	 */
	private MyController checkCache(String key) {	
		return cache.get(key);
	}

}
